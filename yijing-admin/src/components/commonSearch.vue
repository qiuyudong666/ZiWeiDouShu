<template>
  <div class="commonSearch">
    <el-form v-if="querys.length <= showCount" :inline="true" @submit.native="submitForm">
      <div class="commonSearch_topBasic">
        <div>
          <el-form-item v-for="(query, index) in querys" :key="index" :label="query.label"
                        v-show="query.show != null ? query.show : true">

            <el-select v-on="query.on" v-bind="query.attrs" v-if="judgmentQueryType(query, 'select')"
                       v-model="query.value"
                       :disabled="query.disabled" :style="query.style" filterable>
              <el-option v-for="(option, index) in query.options" :key="index" :label="option.label"
                         :value="option.value"></el-option>
            </el-select>
            <el-cascader v-on="query.on" v-bind="query.attrs" :options="query.options" v-model="query.value"
                         v-else-if="judgmentQueryType(query, 'cascader')" :props="query.props" :show-all-levels="false">
            </el-cascader>
            <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'date')"
                            v-model="query.value"
                            :type="query.options[0]" :value-format="query.options[1]"
                            :format="query.options[2]"></el-date-picker>
            <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'daterange')"
                            v-model="query.value"
                            :type="query.options[0]" :value-format="query.options[1]" :format="query.options[2]"
                            range-separator="至"
                            start-placeholder="选择开始日期" end-placeholder="选择结束日期"></el-date-picker>
            <el-date-picker v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'monthrange')"
                            v-model="query.value" :type="query.options[0]" :value-format="query.options[1]"
                            :format="query.options[2]"
                            range-separator="至" start-placeholder="选择开始月度" end-placeholder="选择结束月度"></el-date-picker>
            <el-input v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'input')"
                      v-model="query.value">
            </el-input>
            <template v-else-if="judgmentQueryType(query, 'slot')">
              <slot :name="query.name" :query="query"></slot>
            </template>
          </el-form-item>
          <el-form-item>
            <el-button @click="submit('1')" type="primary">查询</el-button>
            <el-button @click="reset('1')">重置</el-button>
          </el-form-item>
        </div>
      </div>
    </el-form>
    <el-form v-else :inline="true" @submit.native="submitForm">
      <div class="commonSearch_topBasic" :style="{ 'border-bottom': advancedQuery ? 'none' : '1px solid #ccc' }">
        <div>
          <template v-for="(query, index) in querys">
            <el-form-item :label="querys[index].label" :key="'query_' + index" v-if="index < showCount"
                          v-show="query.show != null ? query.show : true">
              <!-- <el-input :placeholder="querys[index].attrs.placeholder" v-model="querys[index].value" v-bind="querys[index].attrs"
              :suffix-icon="el - icon - search" @input="submit" clearable>
              <i class="el-icon-search" slot="suffix"></i>
            </el-input> -->
              <el-select v-on="query.on" v-if="judgmentQueryType(query, 'select')" v-model="query.value"
                         v-bind="query.attrs"
                         :disabled="query.disabled" :style="query.style" filterable>
                <el-option v-for="(option, index) in query.options" :key="index" :label="option.label"
                           :value="option.value"></el-option>
              </el-select>
              <el-cascader v-on="query.on" v-bind="query.attrs" v-model="query.value" :options="query.options"
                           v-else-if="judgmentQueryType(query, 'cascader')" :props="query.props"
                           :show-all-levels="false">
              </el-cascader>
              <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'date')"
                              v-model="query.value"
                              :type="query.options[0]" :value-format="query.options[1]" :format="query.options[2]">
              </el-date-picker>
              <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'daterange')"
                              v-model="query.value" range-separator="至" start-placeholder="选择开始日期"
                              end-placeholder="选择结束日期"
                              :type="query.options[0]" :value-format="query.options[1]" :format="query.options[2]">
              </el-date-picker>
              <el-date-picker v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'monthrange')"
                              v-model="query.value" :type="query.options[0]" :value-format="query.options[1]"
                              :format="query.options[2]" range-separator="至" start-placeholder="选择开始月度"
                              end-placeholder="选择结束月度">
              </el-date-picker>
              <el-input v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'input')"
                        v-model="query.value"
                        clearable>
              </el-input>
              <template v-else-if="judgmentQueryType(query, 'slot')">
                <slot :name="query.name" :query="query"></slot>
              </template>

            </el-form-item>
          </template>
          <el-form-item v-if="!advancedQuery">
            <el-button type="primary" @click="submit('1')">查询</el-button>
            <el-button @click="reset('1')">重置</el-button>
          </el-form-item>
        </div>
        <div class="commonSearch_btn" v-if="!advancedQuery && showCount > 0" @click="changeAdvancedQueryStatus"
             style="min-width:75px;">
          高级检索
          <i class="el-icon-arrow-down"></i>
        </div>
        <div class="commonSearch_btn" v-if="advancedQuery && showCount > 0" @click="changeAdvancedQueryStatus"
             style="min-width:75px;">
          收起筛选
          <i class="el-icon-arrow-up"></i>
        </div>
      </div>
      <div v-show="advancedQuery" style="border-bottom:1px solid #ccc;padding:0 20px;">
        <el-form-item v-for="(query, index) in querys.slice(showCount)" :key="index" :label="query.label">
          <el-select v-on="query.on" v-if="judgmentQueryType(query, 'select')" v-model="query.value"
                     v-bind="query.attrs"
                     :disabled="query.disabled" :style="query.style" filterable>
            <el-option v-for="(option, index) in query.options" :key="index" :label="option.label"
                       :value="option.value"></el-option>
          </el-select>
          <el-cascader v-on="query.on" v-bind="query.attrs" :options="query.options" v-model="query.value"
                       v-else-if="judgmentQueryType(query, 'cascader')" :props="query.props" :show-all-levels="false">
          </el-cascader>
          <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'date')"
                          v-model="query.value"
                          :type="query.options[0]" :value-format="query.options[1]"
                          :format="query.options[2]"></el-date-picker>
          <el-date-picker v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'daterange')"
                          v-model="query.value"
                          range-separator="至" start-placeholder="选择开始日期" end-placeholder="选择结束日期"
                          :type="query.options[0]"
                          :value-format="query.options[1]" :format="query.options[2]"></el-date-picker>
          <el-date-picker v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'monthrange')" v-model="query.value"
                          :type="query.options[0]" :value-format="query.options[1]" :format="query.options[2]"
                          range-separator="至"
                          start-placeholder="选择开始月度" end-placeholder="选择结束月度"></el-date-picker>
          <el-input v-on="query.on" v-bind="query.attrs" v-else-if="judgmentQueryType(query, 'input')"
                    v-model="query.value" clearable>
          </el-input>
          <template v-else-if="judgmentQueryType(query, 'slot')">
            <slot :name="query.name" :query="query"></slot>
          </template>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submit('1')">查询</el-button>
          <el-button @click="reset('1')">重置</el-button>
        </el-form-item>
      </div>
    </el-form>
  </div>
</template>

<script>
import _ from "lodash";

//^ 检索事件 search
export default {
  name: "CommonSearch",
  data() {
    return {
      copyData:[],
      advancedQuery: false,
    };
  },
  props: {
    placeholder: {
      type: String,
      default: "请输入检索词",
    },
    querys: {
      type: Array,
      default: [],
    },
    isParentSet:{
      type:Boolean,
      default:false,
    },
    // copyData: {
    //   type: Array,
    //   default: [],
    // },
    showCount: {
      type: Number,
      default: 1,
    },
    disabled: {
      type: Boolean,
      default: false,
    },
    style: {
      type: String,
      default: "",
    },
    show: {
      type: Boolean,
      default: true,
    },
    callbackfunction: {
      type: Function,
      default: null
    },
  },
  created() {
    this.querys=this.$getSearchParams({params:this.querys,name:this.$route.name})
    //this.copyData=JSON.parse(JSON.stringify(this.querys));
    this.copyData=[];
    for (let i=0;i<this.querys.length;i++) {
      this.copyData.push(this.querys[i].value);
    }
    //alert(this.copyData[3]);
    },
  methods: {
    judgmentQueryType(query, type) {
      let result;
      switch (type) {
        case "slot":
          //TODO name 为插槽名称（solt 值）
          result = !!this.$scopedSlots[query.name];
          break;
        case "select":
          //TODO options 下拉框可选择项：[{ label: '', value: 0 }]
          result = query.type === "select" && Array.isArray(query.options);
          break;
        case "cascader":
          //TODO options 下拉框可选择项：[{ label: '', value: 0 }]
          result = query.type === "cascader" && Array.isArray(query.options);
          break;
        case "date":
          //TODO options 日期控件属性：[type, value-format, format]
          result = (query.type === "date" || query.type === "year" || query.type === "month") && query.options.length === 3;
          break;
        case "daterange":
          //TODO options 日期期间空间属性:[type,value-format,format]
          result = query.type === "daterange" && query.options.length === 3;
          break;
        case "monthrange":
          result = query.type === "monthrange" && query.options.length === 3;
          break;
        case "input":
          result = query.type === "input";
          break;
        default:
          result = false;
          break;
      }
      return result;
    },
    reset(removeSelFlag) {
      //removeSelFlag ,1:移除已选，0：不移除
      // let querys = _.clone(this.querys);
      // this.querys = querys.map((item) => {
      //
      //   if (item.disabled && item.disabled == true) {
      //
      //   } else {
      //     if (item.type === "daterange") {
      //       item.value = [];
      //     } else if (item.type === "select" && typeof (item.value) == 'object') {
      //
      //       item.value = []
      //     } else {
      //       item.value = "";
      //     }
      //
      //   }
      //   return item;
      // });
      // this.$emit("reset",removeSelFlag);
      //this.querys=this.copyData;
     if (this.isParentSet) {
       //alert("111");
       this.$emit("reset");

       this.submit(removeSelFlag);
     }
      else {

        for (let i = 0; i < this.querys.length; i++) {


          this.querys[i].value = this.copyData[i];
        }
        //alert(JSON.stringify(this.copyData));
        this.submit(removeSelFlag);

      }
    },
    convertQueryToSearchParams() {
      //TODO 将查询值转换为请求参数
      return this.querys.reduce((acc, cur) => {
        acc[cur.field || cur.name] = cur.value;
        return acc;
      }, {});
    },
    changeAdvancedQueryStatus() {
      this.advancedQuery = !this.advancedQuery;
      typeof (this.callbackfunction) === 'function' && this.callbackfunction();
    },
    submit(removeSelFlag) {
      var condition = this.convertQueryToSearchParams();
      this.$addSearchParams({name:this.$route.name,condition:condition,page:{pageNum:this.pageNum,pageSize:this.pageSize}})
      condition.removeSelFlag = removeSelFlag === '0' ? '0' : '1';
      this.$emit("search", condition);
    },
    submitForm(event) {
      event.preventDefault();
    },
  },
};
</script>

<style lang="scss" scoped>
// /deep/.el-form--inline .el-form-item__label {
//   display: none !important;
// }
</style>
