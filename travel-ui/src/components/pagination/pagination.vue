<template>
  <div class="block">
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :page-sizes="[5, 10, 20]"
        :current-page="currentPage"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalPages">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "pagination",
  props: {
    currentPage: Number,
    totalPages: Number,
    pagesize: Number,
  },
  methods: {
    handleSizeChange(val) {
      this.$emit("size-change", val);
    },
    handleCurrentChange(val) {
      this.$emit("current-change", val);
    }
  },
}

</script>

<style scoped>
.el-pagination {
  text-align: right;
}
</style>