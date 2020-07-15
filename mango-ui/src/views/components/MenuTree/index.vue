<template>
  <el-submenu v-if="menu.children && menu.children.length >= 1" :index="'' + menu.id">
    <template slot="title">
      <i :class="menu.icon"></i>
      <span slot="title">{{menu.name}}</span>
    </template>
    <MenuTree v-for="item in menu.children" :key="'' + item.id" :menu="item"></MenuTree>
  </el-submenu>
  <el-menu-item v-else :index="'' + menu.id" @click="handleRoute(menu)">
    <i :class="menu.icon"></i>
    <span slot="title">{{menu.name}}</span>
  </el-menu-item>
</template>

<script>
  export default {
    name: 'MenuTree',
    props: {
      menu: {
        type: Object,
        required: true,
      }
    },
    data() {
      return {}
    },
    computed: {
      tabsName: {
        get() {
          return this.$store.state.tab.tabsName
        },
        set(val) {
          this.$store.commit('setTabsName', val)
        }
      },
      mainTabs: {
        get() {
          return this.$store.state.tab.mainTabs
        },
        set(val) {
          this.$store.commit('setMainTabs', val)
        }
      },
    },
    methods: {
      handleRoute(menu) {
        let tab = false;
        this.mainTabs.forEach((item,index,array)=>{
          if(item.name === this.menu.id){
            tab = true
          }
        })
        if (!tab) {
          tab = {
            title: this.menu.name,
            name: this.menu.id,
            icon: this.menu.icon,
            url: this.menu.url
          }
          this.tabsName = this.menu.id;
          this.mainTabs = this.mainTabs.concat(tab);
          sessionStorage.setItem("tabsName",this.tabsName);
          sessionStorage.setItem("mainTabs",JSON.stringify(this.mainTabs));
        }
        if (menu.url) {
          this.$router.push(menu.url)
        }
      }
    },
    mounted() {
    }
  }
</script>

<style scoped>

</style>
