import request from '@/api/request';

export function retrievename(queryParams) {
  return request({
    url:'/retrieve/retrievename',
    method:'post',
    params: queryParams
  })
}
export function updateUsername(query) {
  return request({
    url:'/retrieve/updateusername',
    method:'post',
    params:query
  })
}

export function retrievepwd(queryParams) {
  return request({
    url:'/retrieve/retrievepwd',
    method:'post',
    params:queryParams
  })
}
export function updateUserpwd(query) {
  return request({
    url:'/retrieve/updateuserpwd',
    method:'post',
    params:query
  })
}
