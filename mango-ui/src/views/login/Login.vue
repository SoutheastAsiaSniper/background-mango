<template>
  <!--  <div class="page">-->
  <!--    <h2>Login Page</h2>-->
  <!--  </div>-->
  <el-form :model="loginForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
    <h2 class="title">系统登录</h2>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.account" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-col :span="12">
        <el-form-item prop="captcha">
          <el-input type="test" v-model="loginForm.captcha" auto-complete="off" placeholder="验证码, 单击图片刷新"
                    style="width: 100%;">
          </el-input>
        </el-form-item>
      </el-col>
      <el-col class="line" :span="1">&nbsp;</el-col>
      <el-col :span="11">
        <el-form-item>
          <img style="width: 100%;" class="pointer" :src="loginForm.src" @click="refreshCaptcha">
        </el-form-item>
      </el-col>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 48%" @click="test">注册</el-button>
      <el-button type="primary" style="width: 48%" @click="login">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import Cookies from "js-cookie";
  import api from "@/axios/api";

  export default {
    name: "",
    data() {
      return {
        loginForm: {
          account: "",
          password: ""
        }
      }
    },
    methods: {
      login() {
        let params = {
          name: this.loginForm.account,
          password: this.loginForm.password
        }
        this.$axios.post("/login", params).then((res) => {
          if (res.rejCode == "000000") {
            let userinfo = res.userInfo;
            Cookies.set("token", res.token)
            sessionStorage.setItem("user", JSON.stringify(res.userInfo));
            this.$store.commit("setUserInfo", userinfo);
            this.$router.push("/")
          } else {
            this.$message({
              message: res.rejMsg,
              type: 'error'
            })
          }
        })
      },
      refreshCaptcha() {

      },
      test() {
        let params = {
          userName: 'admin'
        }
        this.$axios.get("/sys/findMenuByUsername", {userName: 'admin'}).then(res => {
          if (res.rejCode === "000000") {
            this.$store.commit("setNavTree", res.menuList);
          } else {
            message({
              message: res.rejMsg,
              type: 'error'
            })
          }
        })
      }
    },
  }
</script>

<style scoped lang="scss">
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;

    .title {
      margin: 0px auto 30px auto;
      text-align: center;
      color: #505458;
    }
  }
</style>
