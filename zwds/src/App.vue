<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <div class="home">
      <div class="turnClass">
        <div id="flipbook">
          <div v-for="(item) in imgUrl" :key="item.index"
               :style="`
          background:url(${item.imgurl}) no-repeat 100% 100%

          `"
          >
          </div>
        </div>
      </div>
    </div>
  </div>
<!--  <el-row :gutter="20">-->
<!--    <el-col :span="4"><div class="grid-content bg-purple">1</div></el-col>-->
<!--    <el-col :span="16"><div class="grid-content bg-purple">-->
<!--      <el-select v-model="form.type" placeholder="请选择" style="width:100px">-->
<!--        <el-option-->
<!--            v-for="item in types"-->
<!--            :key="item.value"-->
<!--            :label="item.label"-->
<!--            :value="item.value">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-select v-model="form.sex" placeholder="请选择" style="width:100px">-->
<!--        <el-option-->
<!--            v-for="item in sexs"-->
<!--            :key="item.value"-->
<!--            :label="item.label"-->
<!--            :value="item.value">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-date-picker-->
<!--          v-model="form.year"-->
<!--          type="year"-->
<!--          value-format=yyyy-->
<!--          placeholder="选择日期">-->
<!--      </el-date-picker>-->
<!--      <el-select v-model="form.month" placeholder="请选择">-->
<!--        <el-option-->
<!--            v-for="item in months"-->
<!--            :key="item.value"-->
<!--            :label="item.label"-->
<!--            :value="item.value">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-select v-model="form.day" placeholder="请选择">-->
<!--        <el-option-->
<!--            v-for="item in days"-->
<!--            :key="item.value"-->
<!--            :label="item.label"-->
<!--            :value="item.value">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-select v-model="form.hour" placeholder="请选择">-->
<!--        <el-option-->
<!--            v-for="item in hours"-->
<!--            :key="item.value"-->
<!--            :label="item.label"-->
<!--            :value="item.value">-->
<!--        </el-option>-->
<!--      </el-select>-->
<!--      <el-button type="primary" @click="select()">主要按钮</el-button>-->
<!--      <table border="1px solid #cccccc" width="100%" class="mt">-->
<!--        <tr >-->
<!--          <td width="25%" height="200px">-->
<!--            <Gong :ok="pan[5]" ></Gong>-->
<!--          </td>-->
<!--          <td width="25%">-->
<!--            <Gong :ok="pan[6]" ></Gong>-->
<!--          </td>-->
<!--          <td width="25%">-->
<!--            <Gong :ok="pan[7]" ></Gong>-->
<!--          </td>-->
<!--          <td width="25%">-->
<!--            <Gong :ok="pan[8]" ></Gong>-->
<!--          </td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td height="200px">-->
<!--            <Gong :ok="pan[4]" ></Gong>-->
<!--          </td>-->
<!--          <td rowspan=2 colspan=2 class="bj"    >-->
<!--            {{wuxingju}}-->
<!--          </td>-->
<!--          <td>-->
<!--            <Gong :ok="pan[9]" ></Gong>-->
<!--          </td>-->
<!--        </tr>-->
<!--        <tr>-->
<!--          <td height="200px">-->
<!--            <Gong :ok="pan[3]" ></Gong>-->
<!--          </td>-->
<!--          <td>-->
<!--            <Gong :ok="pan[10]" ></Gong>-->
<!--          </td>-->
<!--        </tr>-->

<!--        <tr>-->
<!--          <td height="200px">-->
<!--            <Gong :ok="pan[2]" ></Gong>-->
<!--          </td>-->
<!--          <td >-->
<!--            <Gong :ok="pan[1]" ></Gong>-->
<!--          </td>-->
<!--          <td>-->
<!--            <Gong :ok="pan[0]" ></Gong>-->
<!--          </td>-->
<!--          <td>-->
<!--            <Gong :ok="pan[11]" ></Gong>-->
<!--          </td>-->
<!--        </tr>-->
<!--        </table>-->
<!--    </div></el-col>-->
<!--    <el-col :span="4"><div class="grid-content bg-purple">-->
<!--      <div class='box' contenteditable='true' >-->

<!--      </div>-->
<!--    </div></el-col>-->
<!--  </el-row>-->


</template>

<script>
// // import Gong from './components/Gong.vue'
// import axios from "axios";
// import BaseUrl from "@/utils/Store";
import turn from '@/utils/turn.js'
export default {

  data() {
    return {
      imgUrl:[
        {imgurl:'https://www.zihuaa.com/wp-content/uploads/2018/07/c608c731bae44bb.jpg',index:1},
        {imgurl:'https://www.zihuaa.com/wp-content/uploads/2018/07/c608c731bae44bb.jpg',index:2},
        {imgurl:'https://ts1.cn.mm.bing.net/th/id/R-C.6f88b0b0e35cd0aad9e5ad47f2a9d77f?rik=hZhw2jTezUioPA&riu=http%3a%2f%2fwww.52wwz.cn%2fupFiles%2finfoImg%2f2013011670529913.jpg&ehk=sKZ4khHLIx0XQlf7CtgdUzQMT9kFAgD5UpKT1wtB0%2fM%3d&risl=&pid=ImgRaw&r=0',index:3},
        {imgurl:'https://ts1.cn.mm.bing.net/th/id/R-C.b65bff1416a6e93b34c72d51bb20e097?rik=S7XNupxJ8AQsVg&riu=http%3a%2f%2fwww.9610.com%2fqing%2fchenjieqi%2f0409.jpg&ehk=mjNQewfexQRdM%2fiGwZMKuwYKMv7kGdYetJMjxXn3AeA%3d&risl=1&pid=ImgRaw&r=0',index:4},
        {imgurl:'https://c.cidianwang.com/file/20172/3_2017022209243185.jpg',index:5},
      ],
      types: [{
        value: '阳历',
        label: '阳历'
      }, {
        value: '农历',
        label: '农历'
      },],
      sexs: [{
        value: '男',
        label: '男'
      }, {
        value: '女',
        label: '女'
      },],
      hours: [{
        value: '子',label: '子(23～1)'
      }, {
        value: '丑',label: '丑(1～3)'
      },{
        value: '寅',label: '寅(3～5)'
      },{
        value: '卯',label: '卯(5～7)'
      },{
        value: '辰',label: '辰(7～9)'
      },{
        value: '巳',label: '巳(9～11)'
      },{
        value: '午',label: '午(11～13)'
      },{
        value: '未',label: '未(13～15)'
      },{
        value: '申',label: '申(15～17)'
      },{
        value: '酉',label: '酉(17～19)'
      },{
        value: '戌',label: '戌(19～21)'
      },{
        value: '亥',label: '亥(21～23)'
      },],
      months: [{
        value: '正月',label: '正月'
      }, {
        value: '二月',label: '二月'
      },{
        value: '三月',label: '三月'
      },{
        value: '四月',label: '四月'
      },{
        value: '五月',label: '五月'
      },{
        value: '六月',label: '六月'
      },{
        value: '七月',label: '七月'
      },{
        value: '八月',label: '八月'
      },{
        value: '九月',label: '九月'
      },{
        value: '十月',label: '十月'
      },{
        value: '冬月',label: '冬月'
      },{
        value: '腊月',label: '腊月'
        },
      ],
      days: [{
        value: '初一',label: '初一'
      }, {
        value: '初二',label: '初二'
      },{
        value: '初三',label: '初三'
      },{
        value: '初四',label: '初四'
      },{
        value: '初五',label: '初五'
      },{
        value: '初六',label: '初六'
      },{
        value: '初七',label: '初七'
      },{
        value: '初八',label: '初八'
      },{
        value: '初九',label: '初九'
      },{
        value: '初十',label: '初十'
      },{
        value: '十一',label: '十一'
      },{
        value: '十二',label: '十二'
      },{
        value: '十三',label: '十三'
      },{
        value: '十四',label: '十四'
      },{
        value: '十五',label: '十五'
      },{
        value: '十六',label: '十六'
      },{
        value: '十七',label: '十七'
      },{
        value: '十八',label: '十八'
      },{
        value: '十九',label: '十九'
      },{
        value: '二十',label: '二十'
      },{
        value: '廿一',label: '廿一'
      },{
        value: '廿二',label: '廿二'
      },{
        value: '廿三',label: '廿三'
      },{
        value: '廿四',label: '廿四'
      },{
        value: '廿五',label: '廿五'
      },{
        value: '廿六',label: '廿六'
      },{
        value: '廿七',label: '廿七'
      },{
        value: '廿八',label: '廿八'
      },{
        value: '廿九',label: '廿九'
      },{
        value: '三十',label: '三十'
      },],
      form:{
        value: '',
        year: '',
        month: '',
        day: '',
        hour: '',
        type:'',
        sex:''
      },
      pan:{

      }

    }
  },
  components: {
    // Gong
  },
  mounted(){
    this.onTurn();
  },
  methods:{
    onTurn(){
      this.$nextTick(()=>{
        $("#flipbook").turn({
          autoCenter: true,
          height:646,
          width:996,
        });
      })

    },
    select(){

      var select = {
        type:this.form.type,
        name:"qyd",
        yangli:this.form.hour,
        nongli:this.form.year+"-"+this.form.month+"-"+this.form.day+"-"+this.form.hour,
        sex:this.form.sex
      }

      // console.log(select,"qyd")
      // axios({
      //   method: 'post',
      //   url:BaseUrl.url+'/test1',
      //   data: select
      //
      // }).then(res => {
      //   console.log(res.data,1234321)
      //   this.pan=res.data.gongs;
      //   this.wuxingju=res.data.wuxingju;
      // })

    }
  }




}
</script>

<style>
/*td, th, table { border: 1px solid #284; }*/
.mt{
  border-collapse: collapse;
}
.bj{
  background-size: 100% 100%;
  background-image:url("./assets/bg1.png") ;
}
.box{
  height: 400px;
  background-color: #42b983;
}
</style>
