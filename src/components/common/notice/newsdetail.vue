<template>
    <div>

      <div class="m_content">
        <shopheader/>
        <div class="m_left">
          <div class="left_m">
            <div class="left_m_t t_bg2">资讯中心</div>
            <ul>
              <li><a @click="newsl">资讯列表</a></li>
            </ul>
          </div>
        </div>
        <div style="height: 200px;font-size: 22px;font-family: 楷体">
          <p></p>
          <div class="mem_tit">{{news.noticeName}}</div>
          <p style="padding:0 40px; margin:0 auto 20px auto;">
            {{news.noticeContent}}
          </p>
        </div>
      </div>
      <div class="btmbg">
        <div class="btm">
          备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
          <img :src="url+'b_1.gif'" width="98" height="33" /><img :src="url+'b_2.gif'" width="98" height="33" /><img :src="url+'b_3.gif'" width="98" height="33" /><img :src="url+'b_4.gif'" width="98" height="33" /><img :src="url+'b_5.gif'" width="98" height="33" /><img :src="url+'b_6.gif'" width="98" height="33" />
        </div>
      </div>
<!--      <shopfooter/>-->
    </div>
</template>

<script>
  import {noticedetail} from "../../../api/product/notice";
  import shopheader from "../pre/shopheader";
  import shopfooter from "../pre/shopfooter";
  export default {
        name: "newsdetail",
    data(){
          return{
            news:{},
            url:"http://127.0.0.1:89/productimg/",
          }
    },
    methods:{
          detail(e){
            noticedetail(e).then(response=>{
              this.news=response.data.retData;
            })
          },
      newsl(){
        this.$router.push({path:"/newslist"});
      }
    },
    created() {
          debugger
          const id=this.$route.query.id;
          // alert(id)
      this.detail(id);
    }
    ,
    components:{
          shopheader,
      shopfooter
    }
    }
</script>

<style scoped>

</style>
