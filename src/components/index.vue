<template>
  <div>
    <el-container>
      <el-header>
        <shopheader/>
      </el-header>
      <el-main>
        <shopmain/>
      </el-main>
      <el-footer class="footer">
        <shopfooter/>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  import shopfooter from "./common/pre/shopfooter";
  import shopheader from "./common/pre/shopheader";
  import shopmain from "./common/pre/shopmain"
  export default {
    name: 'index',
    data () {
      return {
      }
    },
    methods:{
    },
      components:{
        shopfooter,
        shopheader,
        shopmain
      }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .footer{
    z-index: -1;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
