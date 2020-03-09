<template>
  <div class="hello">
    <el-form v-model="loginForm" ref="loginForm">
      <h3 class="title">在线购物系统</h3>
      <el-button @click="wm">wm</el-button>
    </el-form>
  </div>
</template>

<script>
  import {wm} from "@/api/product/product";
export default {
  name: 'index',
  data () {
    return {
      loginForm: {
        userName: undefined,
        userPwd: undefined,
        yzm:""
      },
      msg:{}
    }
  },
  methods:{
    wm(){
      wm().then(response=>{
        this.msg=response.data.msg;
        alert(this.msg.oprName)
      })
    },
    // handleLogin() {
    //   // this.$router.push({ path: "/hello" });页面跳转
    // },
    /** 提交按钮 */
    yzmyz(){
      this.url='http://localhost:8083/defaultKaptcha?d='+new Date()*1;
    },
    handleLogin: function() {
      if(this.loginForm.userName==undefined||this.loginForm.userName==""){
        this.msgError("用户名不能为空");
        return false;
      }
      if(this.loginForm.userPwd==undefined||this.loginForm.userPwd==""){
        this.msgError("密码不能为空");
        return false;
      }
      Login(this.loginForm).then(response => {
          if(response.data.retCode=="1000"){
            this.$router.push({ path: "/Main" });
          }else{
            this.msgError(response.data.retMsg);
          }
        }
      );
    },register(){
      this.$router.push({path:"/Register"});
    },
    goMain(){
      this.$router.push({ path: "/Main" });
    }
}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
