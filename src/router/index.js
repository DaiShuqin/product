import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import Main from "../components/common/pre/shopmain";
import goodsdeatil from "../components/common/goods/goodsdeatil";
import login from "../components/common/login";
import register from "../components/common/register";
import shopcenter from "../components/common/pre/shopcenter";
import mywallet from "../components/common/pre/centerdetail/mywallet";
import RetrieveName from "../components/common/RetrieveName";
import RetrievePwd from "../components/common/RetrievePwd";
import newslist from "../components/common/notice/newslist";
import newsdetail from "../components/common/notice/newsdetail";
import shophelp from "../components/common/pre/shophelp";
import shopuser from "../components/common/pre/shopuser";
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
      path: '/shopuser',
      component: shopuser
    }
    ,
    {
      path: '/goodsdeatil',
      component: goodsdeatil
    },
    {
      path: '/shopcenter',
      component: shopcenter
    },
    {
      path: '/shophelp',
      component: shophelp
    },
    {
      path: '/mywallet',
      redirect: mywallet
    },
    {
      path: '/register',
      component: register
    },
    {
      path: '/RetrieveName',
      component: RetrieveName
    },
    {
      path: '/RetrievePwd',
      component: RetrievePwd
    },
    {
      path: '/newslist',
      component: newslist
    },
    {
      path: '/newsdetail',
      component: newsdetail
    }

  ]
})
