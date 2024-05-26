<template>
  <div class="login" >
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <h3 class="title">登录</h3>
      <el-form-item prop="username">
        <el-input
            v-model="loginForm.username"
            type="text"
            auto-complete="off"
            placeholder="账号"
        >
        </el-input>

      </el-form-item>
      <el-form-item prop="password">
        <el-input
            v-model="loginForm.password"
            type="password"
            auto-complete="off"
            placeholder="密码"
            @keyup.enter.native="handleLogin"
        >
        </el-input>
      </el-form-item>

      <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 30px 0px;">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button
            :loading="loading"
            size="medium"
            type="primary"
            style="width:100%;"
            @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right;" v-if="register">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
import {login} from "@/api/common/login";

export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      loginForm: {
        username: null,
        password: null,
        rememberMe: false,
        code: "",
        uuid: ""
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        // code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined
    };
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true
    }
  },
  created() {
  },
  methods: {

    // 登录
    handleLogin() {
            login(this.loginForm).then((res)=>{
              if (res.data.code === 200) {
                this.$message({
                  message: "登录成功",
                  type: "success",
                  duration: 800, // 提示消息显示时间，单位毫秒
                });
                sessionStorage.setItem('userLoggedIn', true)
                sessionStorage.setItem('user',JSON.stringify(res.data.data));
                sessionStorage.setItem('userRole', res.data.data.roles);
                sessionStorage.setItem('username', res.data.data.username);
                // 操作成功，执行其他逻辑
                this.$router.push({name:"首页",path:'/index'});

              }else {
                this.$message({
                  message: "用户名或密码错误",
                  type: "error",
                  duration: 2000,
                });
              }
            })
    },

  }
}
</script>

<style scoped>
html, body ,#main-content{
  height: 100%;
  margin: 0;
  padding: 0;
}
.login {
  display: flex;
  justify-content: flex-end; /* 将内容放置在右侧 */
  align-items: center;
  height: 100%;
  width: 100%;
  background-image: url("../../assets/login.jpg");
  background-repeat:no-repeat;
  background-size: cover;
  margin: 0; /* 清除外边距 */
}

.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  margin-top: 100px;
  margin-bottom: calc(100vh - 572px);
  border-radius: 6px;
  margin-left: auto;
  margin-right: auto;
  background: rgba(255, 255, 255, 0.85); /* 使用 rgba 来设置背景颜色透明度 */
  width: 360px;
  height: 420px; /* 调整整个表单的高度 */
  box-sizing: content-box; /* 防止高度溢出内容 */
  padding: 40px 40px 12px 40px;
}
/*.login-tip {*/
/*  font-size: 13px;*/
/*  text-align: center;*/
/*  color: #bfbfbf;*/
/*}*/

/*::v-deep #app #main-content {*/
/*  margin-left: 0;*/
/*  max-width: none;*/
/*  flex: auto;*/
/*  flex-direction: row;*/
/*  overflow-y: visible;*/
/*}*/

/*@media screen and (max-width: 768px) {*/
/*  .login-form {*/
/*    margin-right: 0;*/
/*  }*/
/*  .login {*/
/*    background: #EEE;*/
/*  }*/
/*}*/
</style>
