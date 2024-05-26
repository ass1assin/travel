<template>
  <div style="margin: 20px">
    <el-form :model="queryParams" ref="queryForm" label-width="100px" size="small" :inline="true" v-show="showSearch"
             class="top-query">
      <el-form-item label="学生证编号" prop="name">
        <el-input v-model="queryParams.stucardId" placeholder="请输入琴房地址" clearable @keyup.enter.native="query">
        </el-input>
      </el-form-item>

      <el-form-item style="margin-left: 40px; min-width: 160px;">
        <el-button type="primary" icon="el-icon-search" size="mini" @click="query">查询</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!--表格展示内容-->
    <el-table
        :data="dataList"
        style="width: 100%;" :row-class-name="setClassName">
      <!--收缩行-->
      <!--展示行-->
      <el-table-column label="预约编号" align="center" prop="proomId">
        <template slot-scope="scope">
          {{ scope.row.resId || '暂无数据' }}
        </template>
      </el-table-column>

<!--      <el-table-column label="预约时间" align="center" prop="address">-->
<!--        <template slot-scope="scope">-->
<!--          {{ formatTime(scope.row.resTime) || '暂无数据' }}-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="开始时间" align="center" prop="type">-->
<!--        <template slot-scope="scope">-->
<!--          &lt;!&ndash;          {{ scope.row.startTime || '暂无数据' }}&ndash;&gt;-->
<!--          {{ formatTime(scope.row.startTime) || '暂无数据' }}-->
<!--        </template>-->
<!--      </el-table-column>-->

<!--      <el-table-column label="结束时间" align="center" prop="openTime">-->
<!--        <template slot-scope="scope">-->
<!--          {{ formatTime(scope.row.endTime) || '暂无数据' }}-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column label="学生学号" align="center" prop="closeTime">
        <template slot-scope="scope">
          {{ scope.row.stuId || '暂无数据' }}
        </template>
      </el-table-column>

      <el-table-column label="琴房地址" align="center" prop="type">
        <template slot-scope="scope">
          {{ scope.row.address || '暂无数据' }}
        </template>
      </el-table-column>
      <el-table-column label="学生证编号" align="center" prop="type">
        <template slot-scope="scope">
          {{ scope.row.stucardId || '暂无数据' }}

        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="160">
        <template slot-scope="scope">
          <el-button v-if="parseInt(scope.row.signStatus) === 0" type="primary" size="mini" @click="edit(scope.row.resId)">签到</el-button>
          <span v-else style="color: tomato">已签到</span>
        </template>
      </el-table-column>

    </el-table>
    <!--    分页-->
    <!--    <pagination :current-page.sync="currentPage" :total-pages.sync="totalPages"/>-->
    <pagination
        :pagesize="queryParams.pageSize"
        :current-page.sync="queryParams.currentPage"
        :total-pages.sync="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"/>
  </div>
</template>

<script>
import Pagination from "@/components/pagination/pagination.vue";
import { getAllSpot, test } from '@/api';

export default {
  components: {
    Pagination,
  },
  name: "index_manage",
  data(){
    return {
      dataList: [],
      queryParams: {
        currentPage:1,
        pageSize: 10,
      },
      total:0,
      showSearch:true,
      currentPage: 1,
      totalPages: 0,
      loading: false,
      dialogFormVisible: false,
    }
  },
  created() {
    this.getList();
  },
  methods:{
    query(){
      this.getList();
    },
    // formatTime(timestamp) {
    //   const date = new Date(timestamp);
    //   // 使用你喜欢的日期格式化库或手动格式化日期
    //   const formattedTime = `${date.getFullYear()}-${this.padZero(date.getMonth() + 1)}-${this.padZero(date.getDate())} ${this.padZero(date.getHours())}:${this.padZero(date.getMinutes())}`;
    //   return formattedTime;
    // },
    // padZero(value) {
    //   return value < 10 ? '0' + value : value;
    // },
    getList() {
      this.loading = true
      test().then((res) => {
        console.log(res);
      });
      // getAllSpot(this.queryParams).then((res) => {
      //   console.log(res);
      //   // console.log(res, "结果");
      //   // this.dataList = res.data.data.list;
      //   // this.total = res.data.data.total
      // });
    },

    // edit(resId){
    //   updateSignStatus(resId).then((res)=>{
    //     this.getList();
    //   })
    // },


    // 表格下拉展示
    setClassName({ row, index }) {
      if (row.hasChild) {
        return 'show-expand'; // 添加一个类名来显示小箭头
      } else {
        return 'hide-expand'; // 添加一个类名来隐藏小箭头
      }
    },
    handleSizeChange(val) {
      // 处理页面大小变化逻辑，你可以在这里重新加载数据
      this.queryParams.pageSize = val;
      this.getList();
    },
    // 换页面
    handleCurrentChange(val) {
      // 处理页码变化逻辑，你可以在这里重新加载数据
      this.queryParams.currentPage = val;
      this.getList();
    },

    // 重置
    resetQuery() {
      this.queryParams.stucardId=null;
      this.getList();
    },
  }
}
</script>

<style scoped>
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-left: 10%;
  width: 23%;
}
/*深度选择器*/
.el-table ::v-deep thead th {
  background-color: #f0f0f0; /* 灰色背景 */
}
::v-deep .el-dialog {
  width: 30%
}

</style>
