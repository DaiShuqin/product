import request from '@/api/request';

export function TranVcode(vcode) {
  return request({
    url:'/register/vcode',
    method:'post',
    params:vcode
  })
}

export function reguser(query) {
  return request({
    url:'/register/',
    method:'post',
    params:query
  })
}
