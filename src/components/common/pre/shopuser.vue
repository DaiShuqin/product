<template>
    <div>
      <div>
        <div class="i_bg bg_color">
          <shopheader/>
          <!--Begin 用户中心 Begin -->
          <div class="m_content">
            <div class="m_right" id="content">
              <div class="m_des">
                <table border="0" style="width:870px; line-height:22px;text-align: left;font-size: 18px" cellspacing="15" cellpadding="0">
                  <tr valign="top">
                    <td width="115">
                      <viewer>
                        <img :src="url+user.url" width="100" height="100" />
                      </viewer>
                    </td>
                    <td>
                      <div class="m_user">{{user.userName}}</div>
                      <p>
                        性别:
                      <span v-if="user.sex==1">男</span>
                        <span v-else>女</span></p>
                        余额:￥{{user.userBalance}}<br /><br />
                        电话:{{user.phoneno}}<br /><br />
                        注册时间:{{user.createTime}}<br /><br />
                    </td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
        <div class="btmbg">
          <div class="btm">
            备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
            <img :src="url+'b_1.gif'" width="98" height="33" /><img :src="url+'b_2.gif'" width="98" height="33" /><img :src="url+'b_3.gif'" width="98" height="33" /><img :src="url+'b_4.gif'" width="98" height="33" /><img :src="url+'b_5.gif'" width="98" height="33" /><img :src="url+'b_6.gif'" width="98" height="33" />
          </div>
      </div>
    </div>
    </div>
</template>

<script>
  import shopheader from "./shopheader";
  import {userinfo} from "../../../api/product/user";

  export default {
        name: "shopuser",
      data(){
          return{
            url:"http://127.0.0.1:89/productimg/",
            user:{}
          }
      },
      created() {
        userinfo().then(response=>{
          if(response.data.retCode=='1000'){
            this.user=response.data.retData;
            // alert(this.user.url);
          }else{
            this.$confirm("请先登录！");
          }
        })
      },
      components:{
          shopheader
      }
    }
</script>

<style scoped>

</style>
