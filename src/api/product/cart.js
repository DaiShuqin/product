import request from '@/api/request';

export function carlist(id) {
  // alert(id)
  return request({
    url:'/cart/list/'+id,
    method:'post'
  })
}
export function addCar(query) {
return request({
  url:'/cart/addcart',
  method: 'post',
  params:query
})
}
