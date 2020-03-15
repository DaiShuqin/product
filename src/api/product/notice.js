import request from '@/api/request';

export function noticelist(query) {
  return request({
    url:'/notice/list',
    method:'post',
    params:query
  })
}
