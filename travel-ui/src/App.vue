<template>
  <div id="app">
    <Sidebar/>
    <div id="main-content">
      <Navbar/>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Sidebar from '@/components/sidebar/sidebar.vue';
import Navbar from "@/components/navbar/navbar.vue";
export default {
  components: {
    Sidebar,
    Navbar,
  },
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  //text-align: center;
  color: #2c3e50;
}

body {
  margin: 0;
}
#main-content {
  flex: 1; /* 填充剩余空间 */
  max-width: calc(100% - 200px); /* 侧边栏的宽度 */
  margin-left: 200px;
  flex-direction: column;
  overflow-y: auto;
}
</style>
