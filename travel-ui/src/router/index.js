import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index_manage' // 当访问 / 时，重定向到 /index_manage
  },
  {
    path: '/index_manage',
    name: 'index_manage',
    component: () => import('../views/admin/index_manage')
  },
  {
    path: '/hotel_manage',
    name: 'hotel_manage',
    component: () => import('../views/admin/hotel_manage')
  },
  {
    path: '/traffic_manage',
    name: 'traffic_manage',
    component: () => import('../views/admin/traffic_manage')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
