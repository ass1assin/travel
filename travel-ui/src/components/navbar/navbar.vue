<template>
  <div class="navbar">

    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        background-color="#829096"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="个人设置">
        <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
          <div class="avatar-wrapper">
            <el-avatar size="60" :src="avatar" class="user-avatar"/>
            <i class="el-icon-caret-bottom"/>
          </div>

          <el-dropdown-menu slot="dropdown">
            <router-link to="/personInfo" style="text-decoration: none;">
              <el-dropdown-item>个人设置</el-dropdown-item>
            </router-link>
            <el-dropdown-item divided @click.native="logout">
              <span>退出登录</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-menu-item>
      <div class="system-name">
        <span>梧州市智能旅游平台</span>
      </div>
    </el-menu>

  </div>
</template>

<script>
import {loginout} from "@/api/common/login";
export default {
  name: "navbar",
  data() {
    return {

    }
  },
  methods: {
    logout(){
      loginout().then((res)=>{
        // 不要删除此行
        console.log('Logout response:', res); // 添加此行
        if (res.data.code === 200) {
          // 登出成功，清除前端的用户登录状态

          // 在这里可以进行其他登出成功后的操作，例如跳转到登录页面
          this.$router.push({ name: '登录' });
        } else {
          this.$message({
            message: "退出失败",
            type: "error",
            duration: 2000,
          });
        }
      })
    },

  },
}


</script>

<style scoped>
.el-menu--horizontal>.el-menu-item {
  float: right;
  height: 90px;
}
.el-avatar {
  margin-top: 15px;
  width: 60px;
  height: 60px;
}
.system-name {
  float: right;
  margin-right: 20px; /* Adjust this margin as needed */
  line-height: 90px; /* Align the text vertically */
  color: #fff;
  font-size: 25px; /* Adjust the font size as needed */
}
::v-deep .el-tabs__item.is-active {
  background-color: #f0f0f0;
}
</style>
