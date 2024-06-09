<template>
  <el-row  class="full-height">
    <el-row class="top-bar">
      <el-col :span="24">
        <div class="system-name">
          <span>梧州市智能旅游平台</span>
        </div>
      </el-col>
    </el-row >
    <el-col class="el-col-full">
      <el-menu
          style="height: 100%;"
          class="el-menu-vertical-demo"
          background-color="#545c64"
          text-color="#fff"
          @open="handleOpen"
          @close="handleClose"
          @select="handleMenuSelect"
          active-text-color="#ffd04b">

        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>前台信息管理</span>
          </template>
          <el-menu-item-group style="padding: 0">
            <router-link to="/index_manage" style="text-decoration: none;">
              <el-menu-item index="景点管理">景点管理</el-menu-item>
            </router-link>
            <router-link to="/hotel_manage" style="text-decoration: none;">
              <el-menu-item index="酒店管理">酒店管理</el-menu-item>
            </router-link>
            <router-link to="/notice_manage" style="text-decoration: none;">
              <el-menu-item index="文章管理">文章管理</el-menu-item>
            </router-link>
            <router-link to="/traffic_manage" style="text-decoration: none;">
              <el-menu-item index="交通管理">交通管理</el-menu-item>
            </router-link>
          </el-menu-item-group>
        </el-submenu>

      </el-menu>
    </el-col>
  </el-row>
</template>

<script>

export default {
  name: "sidebar",
  data(){
    return{
    }
  },

  methods: {
    handleMenuSelect(index){
      const currentRoute = this.$route.name;
      // 如果当前路由就是目标路由，不执行导航
      if (currentRoute === index) {
        return;
      }
      this.$router.push({
        name: index,
      });
    },
    handleOpen(key, keyPath) {
      this.closeOtherSubmenus(key);
    },
    handleClose(key, keyPath) {

    },
    // 有些问题
    closeOtherSubmenus(currentIndex) {
      // Close other submenus except the current one
      this.$refs.menuItems.forEach((submenu) => {
        if (submenu.index !== currentIndex) {
          submenu.collapse();
        }
      });
    },
  }
}
</script>

<style scoped>

.full-height {
  position: fixed; /* 固定在屏幕上 */
  height: 100vh; /* 占据整个视口高度 */
  display: flex;
  /*指定了flex容器的子元素应该沿着垂直方向从上到下排列*/
  flex-direction: column;
  overflow: hidden;
}
.el-menu{
  min-width:200px;
  flex: 1;
}

.el-menu .el-submenu .el-menu-item {
  min-width: inherit; /* 或者使用其他你想要的值，或者 unset */
}

.top-bar {
  background-color: #545c64;
  color: #fff;
  height: 90px;
  line-height: 70px;
  padding: 10px 20px;
}

.system-name {
  text-align: center;
}
.el-col-full {
  flex: 1;
}
</style>
