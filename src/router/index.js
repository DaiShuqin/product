import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import Main from "../components/common/pre/shopmain";
import goodsdeatil from "../components/common/goods/goodsdeatil";
import login from "../components/common/login";
import register from "../components/common/register";
// import news from "../components/common/notice/news";
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
    },
    {
      path: '/register',
      component: register
    }
    ,
    {
      path: '/goodsdeatil',
      component: goodsdeatil
    }
  ]
})
