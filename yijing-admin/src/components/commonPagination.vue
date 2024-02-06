<template>
  <div>
    <div class="commonPagination">
      <el-pagination
          background
          :layout="cusLayout"
          :page-sizes="[5, 10, 20,30,40,50,60]"
          v-on="$listeners"
          :current-page="pageNum"
          :page-size="pageSize"
          v-bind="$attrs"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      ></el-pagination>
    </div>
    <div style="clear:both;"></div>
  </div>
</template>
<script>
export default {
  props:{
    pageNum:{
      type:Number,
      default: 1
    },
    pageSize:{
      type:Number,
      default: 1
    },
    cusLayout:{
      type:String,
      default:'total, sizes, prev, pager, next, jumper'
    },
  },
  data() {
    return {
    };
  },
  mounted() {
    this.pageSize = 'pageSize' in this.$getPage({name:this.$route.name}) ? this.$getPage({name:this.$route.name}).pageSize :  10
    this.pageNum= 'pageNum' in this.$getPage({name:this.$route.name}) ? this.$getPage({name:this.$route.name}).pageNum :  1
    // console.log(this.$listeners);
    // console.log(this.$attrs);
  },
  methods: {
    handleSizeChange(val) {
      this.$listeners.sizeChange(val)
      this.$changePage({name:this.$route.name,page:{pageNum:this.pageNum,pageSize:val}})
    },
    handleCurrentChange(val) {
      this.$listeners.currentChange(val);
      this.$changePage({name:this.$route.name,page:{pageNum:val,pageSize:this.pageSize}})
    }
  }
};
</script>
<style lang="scss">
</style>
