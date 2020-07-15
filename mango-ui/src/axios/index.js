// 导入所有接口
import api from './api'

const install = Vue => {
  if (install.installed)
    return;
  install.installed = true;
  // 挂载 $axios 到 原型
  Vue.prototype.$axios = api
}

export default install
