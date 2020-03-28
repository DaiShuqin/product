import request from '@/api/request';

export function login(query) {
  return request({
    url:'/login/',
    method:'post',
    params:query
  })
}
export function islogin() {
  return request({
    url:'/login/header',
    method:'post'
  })
}
export function logoutr() {
  return request({
    url:'/login/logout',
    method:'post'
  })
}
