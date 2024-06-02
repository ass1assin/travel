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


    <el-row>
      <el-col :span="1" style="margin-right: 10px">
        <el-button type="success" plain @click="add()" size="mini" style="margin: 0px 0px 10px 10px">新增</el-button>
      </el-col>
      <!--      <el-col :span="3">-->
      <!--        <div>-->
      <!--          <input type="file" ref="fileInput" style="display: none" @change="handleFileChange">-->
      <!--          <el-button type="warning" plain size="mini"-->
      <!--                     class="button border-main icon-cloud-upload dialogs"-->
      <!--                     data-toggle="click"-->
      <!--                     data-target="#excelDialog"-->
      <!--                     data-mask="1"-->
      <!--                     @click="dialogVisible=true"-->
      <!--                     data-width="50%">-->
      <!--            批量导入</el-button>-->
      <!--        </div>-->
      <!--      </el-col>-->
    </el-row>
    <!--    新增弹窗-->
    <el-dialog  :visible.sync="dialogadd">
      <el-form ref="form" :model="formData" label-width="80px">
        <el-form-item label="学号">
          <el-input v-model="formData.id"></el-input>
        </el-form-item>
        <!--        <el-form-item label="姓名">-->
        <!--          <el-input v-model="formData.stuName"></el-input>-->
        <!--        </el-form-item>-->
        <!--        &lt;!&ndash;        <el-form-item label="性别" >&ndash;&gt;-->
        <!--        &lt;!&ndash;          <el-input v-model="formData.sex"></el-input>&ndash;&gt;-->
        <!--        &lt;!&ndash;        </el-form-item>&ndash;&gt;-->
        <!--        <el-form-item label="性别">-->
        <!--          <el-radio-group v-model="formData.sex">-->
        <!--            <el-radio label="男"></el-radio>-->
        <!--            <el-radio label="女"></el-radio>-->
        <!--          </el-radio-group>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="密码" >-->
        <!--          <el-input v-model="formData.password"></el-input>-->
        <!--        </el-form-item>-->
        <el-form-item  style="text-align: right;">
          <el-button type="primary" @click="handadd">确定</el-button>
          <el-button @click="dialogadd = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--删除弹窗-->


    <el-dialog  :visible.sync="dialogFormVisible">
      <el-form ref="form" :model="formData" label-width="80px">
        <el-form-item label="琴房编号">
          <el-input v-model="formData.proomId" readonly></el-input>
        </el-form-item>
        <el-form-item label="琴房地址">
          <el-input v-model="formData.address"></el-input>
        </el-form-item>
        <el-form-item label="琴房类型">
          <el-input v-model="formData.type"></el-input>
        </el-form-item>

        <el-form-item  style="text-align: right;">
          <el-button type="primary" @click="handedit">确定</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!--表格展示内容-->
    <el-table
        :data="dataList"
        style="width: 100%;" :row-class-name="setClassName">
      <!--收缩行-->
      <!--展示行-->
      <el-table-column label="编号" align="center" prop="id">
        <template slot-scope="scope">
          {{ scope.row.id || '暂无数据' }}
        </template>
      </el-table-column>

      <el-table-column label="图片" align="center" prop="imageUrl">
        <template slot-scope="scope">
          {{ scope.row.imageUrl || '暂无数据' }}
        </template>
      </el-table-column>

      <el-table-column label="酒店名称" align="center" prop="noticeTitle">
        <template slot-scope="scope">
          {{ scope.row.noticeTitle || '暂无数据' }}
        </template>
      </el-table-column>

      <el-table-column label="介绍" align="center" prop="noticeContent">
        <template slot-scope="scope">
          <!--          {{ scope.row.startTime || '暂无数据' }}-->
          {{ scope.row.noticeContent || '暂无数据' }}
        </template>
      </el-table-column>


      <el-table-column label="操作" align="center" min-width="160">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="edit(scope.row)">编辑</el-button>
          <el-button type="danger" size="mini" @click="delete1(scope.row.id)" style="margin-right: 5px" >删除</el-button>
        </template>
      </el-table-column>

    </el-table>
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
import { getAllNotice } from '@/api/noticemanage';

export default {
  components: {
    Pagination,
  },
  name: "notice_manage",
  data(){
    return {
      dataList: [],
      queryParams: {
        currentPage:1,
        pageSize: 10,
      },
      total:0,
      showSearch:true,
      formData:{
      },
      dialogadd:false,
      dialogVisible:false,
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
    getList() {
      this.loading = true
      getAllNotice(this.queryParams).then((res) => {
        console.log("%o",res);
        this.dataList = res.data.list;
        this.total = res.data.total
      });
    },
    add(){
      this.dialogadd=true
    },
    handadd(){
      this.dialogadd = false;
      this.formData.classId=this.queryParams.classId
      // addStu(this.formData).then((res)=>{
      //   if (res.data.code === 200) {
      //     this.dialogFormVisible = false;
      //     this.$message({
      //       message: res.data.msg,
      //       type: "success",
      //       duration: 2000, // 提示消息显示时间，单位毫秒
      //     });
      //     // 操作成功，执行其他逻辑
      //     this.getList();
      //   } else {
      //     // 操作失败，提示用户错误信息
      //     this.$message({
      //       message: res.data.msg,
      //       type: "error",
      //       duration: 2000,
      //     });
      //   }
      // });
    },
    edit(row){
      this.formData = {
        // proomId: row.id,
      };
      this.dialogFormVisible = true;
    },
    handedit(){
      this.dialogFormVisible = false;
      // updateProom(this.formData).then((res)=>{
      //   if (res.data.code === 200) {
      //     this.dialogFormVisible = false;
      //     this.$message({
      //       message: res.data.msg,
      //       type: "success",
      //       duration: 2000, // 提示消息显示时间，单位毫秒
      //     });
      //     // 操作成功，执行其他逻辑
      //     this.getList();
      //   } else {
      //     // 操作失败，提示用户错误信息
      //     this.$message({
      //       message: res.data.msg,
      //       type: "error",
      //       duration: 2000,
      //     });
      //   }
      // });
    },
    delete1(id) {
      this.$confirm('该操作将删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        // type: 'warning'
      }).then(() => {
        // deleteStu(stuId).then((res) =>{
        //   this.getList();
        //   this.$message({
        //     type: 'success',
        //     message: '删除成功!'
        //   });
        // }
        // )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

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

