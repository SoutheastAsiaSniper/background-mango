// /*
//  * 接口统一集成模块
//  */
// import * as login from './modules/login'
// import * as user from './modules/user'
// import * as dept from './modules/dept'
// import * as role from './modules/role'
// import * as menu from './modules/menu'
// import * as dict from './modules/dict'
// import * as config from './modules/config'
// import * as log from './modules/log'
// import * as loginlog from './modules/loginlog'
//
//
// // 默认全部导出
// export default {
//     login,
//     user,
//     dept,
//     role,
//     menu,
//     dict,
//     config,
//     log,
//     loginlog
// }
import axios from './axios'
import qs from 'qs'
//公共数据
let commonData = {};

export default {
  get(url, params = {}) {
    return axios({
      url,
      method: 'get',
      params
    })
  },
  post(url, data = {}) {
    let t={UserId: sessionStorage.getItem('userID')==='undefined'||window.sessionStorage.getItem("userID")==='null'||!window.sessionStorage.getItem("userID")?"":JSON.parse(sessionStorage.getItem('userID'))};
    let ed= Object.assign({}, commonData,t, data);
    return axios({
      url,
      method: 'post',
      data: ed
    })
  },
  postForm(url, data = {}) {
    let t={UserId: sessionStorage.getItem('userID')==='undefined'||window.sessionStorage.getItem("userID")==='null'||!window.sessionStorage.getItem("userID")?"":JSON.parse(sessionStorage.getItem('userID'))};
    let ed= Object.assign({}, commonData,t, data);
    return axios({
      url,
      method: 'post',
      data: qs.stringify(ed)
    })
  }
}
