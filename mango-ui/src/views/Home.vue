<template>
  <div class="container">
    <!-- 导航菜单栏 -->
    <nav-bar></nav-bar>
    <!--    头部区域-->
    <heard-bar></heard-bar>
    <!--    主内容区域-->
    <main-content></main-content>
  </div>
</template>

<script>
  import HeardBar from "./components/home/HeardBar";
  import NavBar from "./components/home/NavBar";
  import MainContent from "./components/home/MainContent";
    export default {
      components:{
        HeardBar,
        NavBar,
        MainContent
      },
      name: ""
    }
</script>

<style scoped>

</style>
