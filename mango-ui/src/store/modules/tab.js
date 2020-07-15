export default {
  state: {
    //main页面标签
    mainTabs:[
      {
        title:"首页",
        name:"0",
        icon:"el-icon-s-home",
        url:"/"
      }
    ],
    // 当前标签页名
    tabsName:"0"
  },
  getters: {
    //get方法
  },
  mutations: {
    //set方法
    setMainTabs(state,mainTabs){
      state.mainTabs = mainTabs
    },
    setTabsName(state,tabsName){
      state.tabsName = tabsName
    }
  },
  actions: {

  }
}
