<template>
    <div class="login-container">
      <div class="login-box"
           style="background-image: url('https://dn-coding-net-production-static.qbox.me/a8f69aba-9700-4c81-88e2-6aee3d36f8f9.jpg')">
        <div class="login-box-form">
          <el-form :model="loginForm">
            <el-form-item>

            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      }
    }
  }
}
</script>

<style scoped lang="less">
.login-container {
  min-height: 100%;
  overflow-x: hidden;

  .login-box {
    position: relative;
    display: flex;
    -moz-box-pack: center;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -moz-box-align: center;
    align-items: center;
    height: calc(100vh);
    background-size: cover;
    background-position: center center;
    .login-box-form {
      position: relative;
      width: 400px;
      z-index: 10;
      padding: 30px;
      border-radius: 2px;
      background: rgb(255, 255, 255);
    }
  }
}
</style>
