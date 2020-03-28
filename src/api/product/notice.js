import request from '@/api/request';

export function noticelist(query) {
  return request({
    url:'/notice/list',
    method:'post',
    params:query
  })
}
export function noticelistp(query) {
  return request({
    url:'/notice/listp',
    method:'post',
    params:query
  })
}
export function noticedetail(id) {
  return request({
    url:'/notice/detail/'+id,
    method:'post'
  })
}
