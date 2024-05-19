<template>
  <div id="app">
    <nav class="navbar1">
      <div class="contain1">
        <ul class="ulcontain">
          <li><router-link to="/spot">首页</router-link></li>
          <li><router-link to="/spot">首页</router-link></li>
        </ul>
      </div>
      <div class="contain2">
        <router-link to="/spot">个人中心</router-link>
      </div>
    </nav>
    <nav class="navbar2">
      <router-link to="/spot">景点</router-link>
      <router-link to="/hotel">酒店</router-link>
      <router-link to="/traffic">交通</router-link>
      <router-link to="/evaluate">用户评价</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background:#F8F9FA;
}
nav {
  a {
    text-decoration: none;
    padding: 10px;
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
      color: #ebaa3d;
    }
  }
}
.navbar1 {
  display: flex;
  flex-direction: row;
  text-align: left;
  background: black;
  a{
    color: white;
    transition: color 0.3s;
    &:hover {
      color: #ebaa3d;
    }
  }
}
.contain1{
  margin-left: 20%;
}
.contain2{
  flex: 1;
  display: flex;
  align-items: center;
  margin-right: 20%;
  a{
    // text-align: right; // 这对行内元素无效，因为 text-align 是用于块级元素的
    margin-left: auto;
  }
}
.ulcontain{
  list-style: none;
  display: flex;
  padding-inline-start:0px;
  flex-direction: row;
}
.navbar2 {
  padding: 20px;
  a{
    padding: 0 40px 0 40px;
    transition: color 0.3s,border-bottom;
    &:hover {
      border-bottom: 2px solid #ebaa3d;
      color: #ebaa3d;
    }
    &.router-link-exact-active {
      color: #ebaa3d;
    }
  }
}
</style>
