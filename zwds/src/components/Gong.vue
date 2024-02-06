<template>
  <div >
<!--    {{ok}}-->
    {{ok.nickname}}
    {{ok.changsheng}}
    {{ok.xiaoxian}}
    {{ok.daxian}}
    {{ok.boshixing}}
    {{ok.name}}
    {{ok.suiqian}}
    {{ok.jiangqian}}
    <ul >
      <li v-for="item in ok.rixing" :key="item">
        {{ item }}
      </li>
    </ul>
    <ul >
      <li v-for="item in ok.yuexing" :key="item">
        {{ item }}
      </li>
    </ul>

    <ul >
      <li v-for="item in ok.ganxing" :key="item">
        {{ item }}
      </li>
    </ul>
    <ul >
      <li v-for="item in ok.zhuxing" :key="item">
        {{ item }}
      </li>
    </ul>
    <ul >
      <li v-for="item in ok.shixing" :key="item">
        {{ item }}
      </li>
    </ul>
    <ul >
      <li v-for="item in ok.zhixing" :key="item">
        {{ item }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'projectDetails',
  props: {
    // ok:{
    //   type:Object,
    //   default(rawProps) {
    //     return null
    //   }
    // }
  },
  computed: {

  },
  emits: {

  },
  mounted() {
  },
  data(){
    return{
      caseListHeight:"",
      pageSize:this.pageSize,
      currentPage:this.currentPage,
      total:10,
    }

  },
  methods:{

    handleSizeChange(val){
      this.pageSize=val;
      this.currentPage=1
      const params={
        currentPage:this.currentPage,
        pageSize:val
      };
      this.$emit("handleSizeChange",params)
    },
    handleCurrentChange(val){
      const params={
        currentPage:val,
        pageSize:this.pageSize
      };
      this.$emit("handleSizeChange",params)
    }
  }
}
</script>


<style scoped>

</style>
