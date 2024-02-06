<template>
  <el-container style="height:calc(100%);">
    <el-aside width="200px;height:calc(100%)" class="aside">
      <mainLeft style="width:200px;hegith:100%;"></mainLeft>
    </el-aside>
    <el-main>

<!--      <router-view></router-view>-->
      <keep-alive> <!-- 使用keep-alive包了一层，就可以缓存啦 -->
        <router-view></router-view>
      </keep-alive>

    </el-main>
  </el-container>
</template>
<script>
import mainLeft from '@/components/views/main/mainLeft'

export default {
  name: "mainPage",
  components:{mainLeft},
  data() {
    return {
      screenWidth: document.documentElement.clientWidth,     // 屏幕宽
      screeHeight: document.documentElement.clientHeight,    // 屏幕高
      topHeight: document.documentElement.clientHeight*0.3,

    };
  },
  methods: {
    getHeight(){
      console.log(document.body.clientHeight);
      return document.body.clientHeight;
    },

  }
};
</script>

<style lang="scss" scoped>
.el-header{
  padding:0px;
}
.aside{

}
</style>
