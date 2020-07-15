<template>
  <div class="main-container" :class="collapse?'position-collapse-left':'position-left'">
    <div class="main-tab">
      <el-tabs class="tabs" v-model="tabsName" closable type="card" @tab-remove="removeTabs" @tab-click="clickTabs">
        <el-tab-pane
          v-for="item in mainTabs"
          :key="item.name"
          :label="item.title"
          :name="item.name">
          <span slot="label"><i :class="item.icon"></i> {{item.title}} </span>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="main-content">
      <keep-alive>
        <transition name="fade" mode="out-in">
          <router-view></router-view>
        </transition>
      </keep-alive>
    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  export default {
    name: "",
    data() {
      return {
        // tabsName:"",
        // mainTabs:[],
      }
    },
    computed: {
      ...mapState({
        collapse: state => state.app.collapse
      }),
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
    methods:{
      clickTabs(tab){
        this.mainTabs.forEach((item,index,array)=>{
          if(item.name === tab.name){
            this.$router.push(item.url)
          }
        })
        sessionStorage.setItem("tabsName",tab.name);
      },
      removeTabs(tabName){
        if(tabName == '0'){
          return;
        }
        for(let i = 0; i < this.mainTabs.length; i++){
          if(this.mainTabs[i].name === tabName){
            this.mainTabs.splice(i,1);
            this.tabsName = this.mainTabs[0].name;
          }
        }
        console.log(this.mainTabs)
        sessionStorage.setItem("tabsName",this.tabsName);
        sessionStorage.setItem("mainTabs",JSON.stringify(this.mainTabs));
      }
    }
  }
</script>

<style scoped lang="scss">
  .main-container {
    padding: 0 5px 5px;
    position: absolute;
    top: 60px;
    left: 1px;
    right: 1px;
    bottom: 0px;
  }

  .position-left {
    left: 200px;
  }

  .position-collapse-left {
    left: 65px;
  }
</style>
