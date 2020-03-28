<template>
  <div>
    <el-container>
      <el-header>
        <shopheader @goodsd="getgoods" @indexsy="sy"/>
      </el-header>
      <el-main class="m">
        <shopmain  ref="smain"/>
      </el-main>
      <el-footer>
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
      getgoods(e){
        this.$refs.smain.goodsDe(e);
      },
      sy(){
        this.$refs.smain.index();
      }
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
  .m{
    z-index: 999;
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
