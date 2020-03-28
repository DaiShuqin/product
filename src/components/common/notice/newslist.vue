<template>
<div>
  <shopheader/>
  <div>
    <p></p>
    <div class="mem_tit">资讯列表</div>
    <el-table v-loading="loading" :data="newsList" style="width: 50%;align-items: center">
      <el-table-column prop="noticeName" label="文章标题">
        <template slot-scope="scope">
            <p @click="noticedetail(scope.row.noticeId)">{{ scope.row.noticeName }}</p>
        </template>
      </el-table-column>
      <el-table-column prop="startTime" label="创建时间"/>
<!--      <tr>-->
<!--        <td width="20%">文章标题</td>-->
<!--        <td width="25%">创建时间</td>-->
<!--      </tr>-->
<!--      <c:forEach items="${newsList}" var="temp">-->
<!--        <tr>-->
<!--          <td><a href="${ctx}/admin/news?action=newsDeatil&id=${temp.id}">${temp.title}</a></td>-->
<!--          <td>${temp.createTime}</td>-->
<!--        </tr>-->
<!--      </c:forEach>-->
    </el-table>
      <el-pagination
        :page-sizes="[2,3, 5, 10]"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        :page-size.sync="queryParams.pageSize"
        :current-page.sync="queryParams.pageNum"
        @current-change="getlist"
        @size-change="getlist"
      />
  </div>
  <shopfooter/>
</div>
</template>

<script>
  import {noticelistp} from "../../../api/product/notice";
  import shopheader from "../pre/shopheader";
  import shopfooter from "../pre/shopfooter";

  export default {
        name: "newslist",
        data(){
          return{
            newsList:{},
            queryParams:{
              pageSize:5,
              pageNum:1
            },
            total:1,
            loading:false
          }
        },
        methods:{
          getlist(){
              this.loading=true;
              noticelistp(this.queryParams).then(response=>{
              this.newsList=response.data.retData
              this.total=response.data.retTotal
                // alert(this.total)
              this.loading=false;
            })
          },
          noticedetail(e){
            this.$router.push({path:"/newsdetail",query:{id:e}})
          }
        },
        created() {
          this.getlist()
        },
    components:{
      shopheader,
      shopfooter
    }
  }
</script>

<style scoped>

</style>
