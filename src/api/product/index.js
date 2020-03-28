import request from "@/api/request";

export function listgoods(goods) {
    return request({
      url: '/goods/list',
      method: 'post',
      params: goods
  })
}
export function goodsBean(goodsId) {
  return request({
    url: '/goods/goodsId/'+goodsId,
    method: 'post',
  })
}
export function slideshows() {
  return request({
    url: '/slideshow/list',
    method: 'post',
  })
}
