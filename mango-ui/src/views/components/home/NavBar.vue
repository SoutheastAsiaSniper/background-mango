<template>
  <div class="menu-bar-container">
    <div class="logo" :class="collapse?'menu-bar-collapse-width':'menu-bar-width'">
      <img src="../../../assets/images/mangologo.png"/><div>{{collapse?'':appName}}</div>
    </div>
    <el-menu
      ref="navmenu"
      default-active="1"
      :class="collapse?'menu-bar-collapse-width':'menu-bar-width'"
      :collapse="collapse"
      :collapse-transition="false"
      :unique-opened="true"
      @open="handleopen"
      @close="handleclose"
      @select="handleselect"
      class="menu">
      <menu-tree v-for="item in navTree" :key="'' + item.id" :menu="item"></menu-tree>
    </el-menu>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import MenuTree from '@/views/components/MenuTree'
    export default {
    components:{
      MenuTree
    },
      data(){
        return{}
      },
      computed:{
        ...mapState({
          collapse: state => state.app.collapse,
          appName: state => state.app.appName,
          navTree: state => state.menu.navTree
        })
      },
      methods:{
        handleopen() {
          // console.log('handleopen')
        },
        handleclose() {
          // console.log('handleclose')
        },
        handleselect(a, b) {
          // console.log('handleselect')
        },
      }
    }
</script>

<style scoped lang="scss">
.menu-bar-container{
  position: fixed;
  top:0px;
  left: 0px;
  bottom: 0;
  z-index: 1020;
  .logo{
    position: absolute;
    top: 0px;
    height: 60px;
    background-color: #2c3e50;
    line-height: 60px;
    cursor: pointer; /*光标类型*/
    img{
      width: 40px;
      height: 40px;
      border-radius: 0px;
      margin: 10px 10px 10px 10px;
      float: left;
    }
    div {
      font-size: 22px;
      color: white;
      text-align: left;
      padding-left: 20px;
    }
  }
  .menu{
    margin-top: 60px;
  }
}
  .menu-bar-collapse-width{
    width: 65px;
  }
  .menu-bar-width{
    width: 200px;
  }
</style>
