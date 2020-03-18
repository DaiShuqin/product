import request from '@/api/request';

export function login(query) {
  return request({
    url:'/login/',
    method:'post',
    params:query
  })
}
