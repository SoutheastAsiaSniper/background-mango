import Vue from 'vue'
import Router from 'vue-router'
import axios from '@/axios/api'
import store from '@/store'
import HelloWorld from '@/views/HelloWorld'
import Login from '@/views/login/Login'
import Home from '@/views/Home'
import User from '@/views/user/User'
// import 'font-awesome/css/font-awesome.min.css'

Vue.use(Router)

/**
 * 重写路由的push方法
 */
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error)
}

const router = new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    }, {
      path: '/login',
      name: 'Login',
      component: Login
    }, {
      path: '/',
      name: 'Home',
      component: Home,
      children: [
        {
          path: '/user',
          name: 'User',
          component: User
        }
      ]
    }
  ]
})

router.beforeEach((to, from, next) => {

  //取出tabs
  let tabsName = sessionStorage.getItem("tabsName");
  let mainTabs = JSON.parse(sessionStorage.getItem("mainTabs"));
  if (tabsName) {
    store.commit('setTabsName', tabsName);
  }
  if (mainTabs) {
    store.commit('setMainTabs', mainTabs);
  }
  // 登录界面登录成功之后，会把用户信息保存在会话
  // 存在时间为会话生命周期，页面关闭即失效。
  let user = sessionStorage.getItem("user");
  let userInfo = JSON.parse(user);
  if (to.path == '/login') {
    if (userInfo) {
      next({path: '/'})
    } else {
      next();
    }
  } else {
    if (!userInfo) {
      next({path: '/login'})
    } else {
      getMenu(userInfo.name)
      next();
    }
  }


})

function getMenu(userName) {
  axios.get("/sys/findMenuByUsername", {userName: userName}).then(res => {
    if (res.rejCode === "000000") {
      let menu = res.menuList;
      for (let i = 0; i < menu.length; i++) {
        menu[i].id = menu[i].id.toString();
        if (menu[i].children.length > 0) {
          for (let j = 0; j < menu[i].children.length; j++) {
            menu[i].children[j].id = menu[i].children[j].id.toString();
          }
        }
      }
      store.commit("setNavTree", menu);
    } else {
      message({
        message: res.rejMsg,
        type: 'error'
      })
    }
  })
}

export default router;
