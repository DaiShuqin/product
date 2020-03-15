import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import Main from "../components/common/pre/shopmain";
import HH from "../components/common/hh";
import login from "../components/common/login"
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/login',
      component: login
    },
    {
      path: '/index',
      component: index
    }
  ]
})
