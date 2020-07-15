<template>
  <div class="headbar" :class="collapse?'position-collapse-left':'position-left'">
    <el-tooltip class="item" effect="dark" :content="tooltipMsg" placement="bottom">
      <div class="menuImg" @click="showMenu">
        <img src="@/assets/images/showMenu1.png"/>
      </div>
    </el-tooltip>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
    export default {
      data(){
        return{
          tooltipMsg:"缩小菜单栏",
        }
      },
      computed:{
        ...mapState({
          collapse: state => state.app.collapse
        })
      },
      methods:{
        showMenu(){
          if(this.$store.state.app.collapse){
            this.tooltipMsg = "显示菜单栏"
          }else{
            this.tooltipMsg = "缩小菜单栏"
          }
          this.$store.state.app.collapse = !this.$store.state.app.collapse;
        }
      },
      mounted() {
      }
    }
</script>

<style scoped lang="scss">
  .headbar{
    position: fixed;
    top: 0px;
    right: 0px;
    height: 60px;
    /*left:65px;*/
    z-index: 1030;
    background-color: #2c3e50;
    .menuImg{
      position: absolute;
      img{
        width: 30px;
        height: 30px;
        margin: 15px 15px 15px 15px;
      }
    }
  }
  .position-left {
    left: 200px;
  }
  .position-collapse-left {
    left: 65px;
  }

</style>
