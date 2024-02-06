<template>
  <div class="app-container pull-height">
<!--    {{$route.name}}-->
    <basic-container>
<!--      用户管理{{$store.getters.getselect.select}}-->
      <el-input v-model="input.name" placeholder="请输入内容"></el-input>
      <el-input v-model="input.value" placeholder="请输入内容"></el-input>
    </basic-container>
  </div>
</template>
<script>

export default {
  name: "user",
  data() {
    return {
      input:{

      }
    }
  },
  created() {

  },
  mounted() {
    // this.input=this.$store.getters.getselect.user
  },
  destroyed() {
    console.log("user被销毁了")
  },
  methods: {
  },
};
</script>
<style lang="scss" scoped>

</style>
