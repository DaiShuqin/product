import request from "@/api/request";

export function listgoods(goods) {
    return request({
      url: '/goods/list',
      method: 'post',
      params: goods
  })
}
