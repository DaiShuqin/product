import request from '@/api/request';
export function wm() {
  return request({
    url:'/w/wm',
    method:'post'
  })
}
