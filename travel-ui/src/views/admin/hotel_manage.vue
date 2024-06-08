<template>
  <div style="margin: 20px">
    <el-form :model="queryParams" ref="queryForm" label-width="100px" size="small" :inline="true" v-show="showSearch"
             class="top-query">
      <el-form-item label="酒店名称" prop="name">
        <el-input v-model="queryParams.hotelName" placeholder="请输入酒店名称" clearable @keyup.enter.native="query">
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
    </el-row>
    <!--    新增弹窗-->
    <el-dialog  :visible.sync="dialogAdd">
      <el-form ref="form" :model="formData" label-width="80px">
        <el-form-item label="图片">
          <el-upload
              ref="upload"
              :file-list="fileList"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :on-change="handleChange"
              :auto-upload="false"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible2">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <el-form-item label="酒店名称" >
          <el-input v-model="formData.hotelName"></el-input>
        </el-form-item>
        <el-form-item label="介绍" >
          <el-input v-model="formData.hotelContent" type="textarea" :autosize="{ minRows: 4, maxRows: 8}"></el-input>
        </el-form-item>
        <el-form-item  style="text-align: right;">
          <el-button type="primary" @click="handleAdd">确定</el-button>
          <el-button @click="dialogAdd = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>


<!--修改弹窗-->
    <el-dialog :visible.sync="dialogUpdate">
      <el-form ref="form" :model="formData" label-width="80px">
        <el-form-item label="图片">
          <el-upload
              ref="upload"
              :file-list="fileList"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :on-change="handleChange"
              :auto-upload="false"
          >
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible2">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <el-form-item label="酒店名称">
          <el-input v-model="formData.hotelName"></el-input>
        </el-form-item>
        <el-form-item label="介绍">
          <el-input v-model="formData.hotelContent" type="textarea" :autosize="{ minRows: 4, maxRows: 8 }"></el-input>
        </el-form-item>
        <el-form-item style="text-align: right;">
          <el-button type="primary" @click="handeEdit">确定</el-button>
          <el-button @click="dialogUpdate = false">取消</el-button>
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
            <div class="block">
              <el-image :src="scope.row.imageUrl"></el-image>
            </div>
<!--          {{ scope.row.imageUrl || '暂无数据' }}-->
        </template>
      </el-table-column>

      <el-table-column label="酒店名称" align="center" prop="hotelName">
        <template slot-scope="scope">
          {{ scope.row.hotelName || '暂无数据' }}
        </template>
      </el-table-column>

      <el-table-column label="介绍" align="center" prop="hotelContent">
        <template slot-scope="scope">
          <!--          {{ scope.row.startTime || '暂无数据' }}-->
          {{ scope.row.hotelContent || '暂无数据' }}
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
import { addHotel,updateHotel, getAllHotel, uploadImage } from '@/api/hotelmanage';
import axios from 'axios';
export default {
  components: {
    Pagination,
  },
  name: "hotel_manage",
  data(){
    return {
      dataList: [],
      queryParams: {
        currentPage:1,
        pageSize: 10,
      },
      formData:{
      },
      total:0,
      showSearch:true,
      currentPage: 1,
      dialogAdd:false,
      dialogUpdate:false,
      dialogVisible:false,
      dialogVisible2: false,
      totalPages: 0,
      loading: false,
      dialogImageUrl: '',
      fileList: [] // 存储上传的文件列表
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
      getAllHotel(this.queryParams).then((res) => {
        this.dataList = res.data.list.map(item => {
          return {
            ...item,
            imageUrl: `http://localhost:8093/${item.imageUrl}`
          };
        });
        this.total = res.data.total
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
      this.queryParams.pageSize = val;
      this.getList();
    },
    // 换页面
    handleCurrentChange(val) {
      this.queryParams.currentPage = val;
      this.getList();
    },

    // 重置
    resetQuery() {
      this.queryParams.hotelName=null;
      this.getList();
    },
    add(){
      this.dialogAdd=true
    },
    handleChange(file, fileList) {
      this.fileList = fileList;
    },
    handleAdd() {
      console.log(this.fileList);
      if (this.fileList.length === 0) {
        this.$message.error('请选择图片');
        return;
      }
      const formData = new FormData();
      formData.append('file', this.fileList[0].raw);

      axios.post('http://localhost:8093/upload', formData)
          .then(response => {
            if (response.data === '图片上传成功') {
              this.formData.imageUrl = 'img/' + this.fileList[0].raw.name; // 设置图片路径
              this.saveData();
            } else {
              this.$message.error('图片上传失败');
            }
          })
          .catch(error => {
            console.error(error);
            this.$message.error('图片上传失败');
          });
    },
    saveData() {
      // 在这里发送保存数据的请求
      addHotel(this.formData).then(res => {
        if (res.code === 200) {
          this.$message.success('保存成功');
          this.dialogAdd = false;
          this.getList(); // 刷新列表或其他操作
          this.$message.error('保存失败1');
        }
      }).catch(error => {
        this.$message.error('保存失败2');
      });
    },
    edit(row){
      this.formData = {
        id: row.id,
        hotelName:row.hotelName,
        hotelContent:row.hotelContent,
      };
      this.fileList = [{
        name: row.imageUrl.split('/').pop(),  // 从 URL 中提取文件名
        url: row.imageUrl  // 设置图片 URL
      }];
      // this.dialogImageUrl=row.imageUrl,
      this.dialogUpdate = true;
    },
    handeEdit() {
      console.log(this.fileList);
      if (this.fileList.length === 0) {
        this.$message.error('请选择图片');
        return;
      }
      const formData = new FormData();
      formData.append('file', this.fileList[0].raw);
      axios.post('http://localhost:8093/upload', formData)
          .then(response => {
            if (response.data === '图片上传成功') {
              this.formData.imageUrl = 'img/' + this.fileList[0].raw.name; // 设置图片路径
              this.saveEdit();
            } else {
              this.$message.error('图片上传失败');
            }
          })
          .catch(error => {
            console.error(error);
            this.$message.error('图片上传失败');
          });
    },
    saveEdit(){
      this.dialogUpdate = false;
      updateHotel(this.formData).then(res => {
        if (res.code === 200) {
          this.$message.success('修改成功');
          this.dialogUpdate = false;
          this.getList(); // 刷新列表或其他操作
        }
      }).catch(error => {
        this.$message.error('修改失败2');
      });
    },
    delete1(id) {
      this.$confirm('该操作将删除该信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        // type: 'warning'
      }).then(() => {
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible2 = true;
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
