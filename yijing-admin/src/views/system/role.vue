<template>
  <div class="app-container pull-height">
<!--    {{$route.name}}-->
    <basic-container>
      角色管理
<!--      用户管理{{$store.getters.getselect.role}}-->
      <el-input v-model="input.name" placeholder="请输入内容"></el-input>
      <el-input v-model="input.value" placeholder="请输入内容"></el-input>
    </basic-container>
  </div>
</template>
<script>

export default {
  name: "role",
  data() {
    return {
      input:{

      }
    }
  },
  created() {
  },
  mounted() {
    // this.input=this.$store.getters.getselect.role
  },
  destroyed() {
    console.log("role被销毁了")
  },
  methods: {

  },
};
</script>
<style lang="scss" scoped>
</style>
