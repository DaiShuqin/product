import request from "@/api/request";
export function userinfo() {
  return request({
    url:'/user/info',
    method:'post'
  })
}
