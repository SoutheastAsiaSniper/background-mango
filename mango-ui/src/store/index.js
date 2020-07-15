import Vue from 'vue'
import vuex from 'vuex'

Vue.use(vuex);

//引入子模块
import app from './modules/app'
import menu from './modules/menu'
import tab from './modules/tab'
import user from './modules/user'

const store = new vuex.Store({
  modules: {
    app: app,
    menu: menu,
    tab: tab,
    user: user
  }
})

export  default store
