export default {
  state: {
    // 导航菜单树
    navTree:[
      {
        id:'1',
        icon:'el-icon-location',
        name:'菜单一',
        children:[
          {
            id:'5',
            name:'分组1.1',
            url:'/user'
          },
          {
            id:'6',
            name:'分组1.2'
          }
        ]
      },
      {
        id:'2',
        icon:'el-icon-menu',
        name:'菜单二'
      },
      {
        id:'3',
        icon:'el-icon-document',
        name:'菜单三'
      },
      {
        id:'4',
        icon:'el-icon-setting',
        name:'菜单四'
      },
    ],
  },
  getters: {
    //get方法
  },
  mutations: {
    //set方法
    setNavTree(state,navTree){
      state.navTree = navTree
    }
  },
  actions: {

  }
}
