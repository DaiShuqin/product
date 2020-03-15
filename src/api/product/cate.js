import request from '@/api/request';

export function categorylist(query) {
  return request({
    url:'/cate/list',
    method:'post',
    params:query
  })
}
