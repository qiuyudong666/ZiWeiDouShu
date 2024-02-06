<template>
  <div class="app-container pull-height">
    <CommonSearch :querys="querys" @search="loadList" @reset="loadList" :showCount="4" id="searchDiv" ref="commonSearch"></CommonSearch>
    {{$route.name}}
    <basic-container>
      权限管理
      <el-input v-model="input.name" placeholder="请输入内容"></el-input>
      <el-input v-model="input.value" placeholder="请输入内容"></el-input>
      <el-button type="primary" @click="ok">主要按钮</el-button>
    </basic-container>
    <CommonPagination ref="ok" :total="total" :pageNum="pageNum" :pageSize="pageSize"
                      @currentChange="handlePageNum" @sizeChange="handlePageSize"> </CommonPagination>
  </div>
</template>
<script>
import CommonSearch from "@/components/commonSearch";
import CommonPagination from "@/components/commonPagination";
export default {
  name: "authority",
  components: {
    CommonSearch,
    CommonPagination
  },
  data() {
    return {
      input:{

      },
      total:140,
      pageSize:30,
      pageNum:2,
      querys: [

        {
          name: "code",
          field: "code",
          value: "",
          type: "input",
          label: "单据编号：",
          attrs: { clearable: true, placeholder: "请输入单据编号" },
        },
        {
          name: "serialNumber",
          field: "serialNumber",
          value: "",
          type: "input",
          label: "设备序列号：",
          attrs: { clearable: true, placeholder: "请输入设备序列号" },
        },


        {
          name: "searchAcceptRq",
          field: "acceptanceDate",
          value: [],
          type: "daterange",
          label: "日期：",
          attrs: { clearable: true, placeholder: "请选择验收日期" },
          options: ["daterange", "yyyy-MM-dd", "yyyy-MM-dd"],
        },
        {
          name: "searchContractCode",
          field: "contractCode",
          value: "",
          type: "input",
          label: "合同编号：",
          attrs: { clearable: true, placeholder: "请输入合同编号" },
        },
        {
          name: 'searchStatus',
          field: "statusList",
          value: [],
          type: "select",
          label: "单据状态：",
          attrs: { clearable: true, placeholder: "请选择单据状态", multiple: true, 'collapse-tags': true },
          options: [],
        },
        {
          name: "searchGoodsName",
          field: "goodsName",
          value: "",
          type: "input",
          label: "物资名称：",
          attrs: { clearable: true, placeholder: "请输入物资名称" },
        },
        {
          name: "searchDemandOrg",
          field: "demandOrgName",
          value: "",
          type: "input",
          label: "需求部门：",
          attrs: { clearable: true, placeholder: "请输入需求部门" },
        },
        {
          name: "searchUserOrg",
          field: "userOrgName",
          value: "",
          type: "input",
          label: "使用部门：",
          attrs: { clearable: true, placeholder: "请输入使用部门" },
        },
      ],

    }
  },
  created() {
this.loadList()
  },
  mounted() {
    this.loadList()
    this.pageNum=this.$refs.ok.pageNum
    this.pageSize=this.$refs.ok.pageSize
    console.log(this.pageNum,this.pageSize,"-----------"
    )
  },
  methods: {
    handlePageNum(val) {
      this.pageNum = val;
      this.$refs.commonSearch.submit("0");
    },

    handlePageSize(val) {
      this.pageSize = val;
      this.$refs.commonSearch.submit("0");
    },
    ok(){
      this.$store.commit("add",this.input)
    },
    loadList(condition) {
      condition=this.$store.getters.getselect[this.$route.name]
      this.querys[0].value = condition.code;
    console.log("查询条件",condition)
    },
  },
};
</script>
<style lang="scss" scoped>
</style>
