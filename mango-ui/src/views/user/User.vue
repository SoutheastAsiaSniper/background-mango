<template>
  <div class="container">
    <div class="from-div">
      <el-form :model="queryForm" :inline="true">
        <el-form-item label="用户名">
          <el-input v-model="queryForm.name" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
          <el-button type="primary" @click="addUser">新增</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="table-div">
      <el-table :data="userInfoTable" border stripe style="width: 100%">
        <el-table-column prop="name" label="用户名"></el-table-column>
        <el-table-column prop="nickName" label="姓名"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="mobile" label="手机号"></el-table-column>
        <el-table-column prop="status" label="状态">
          <template slot-scope="scope">
            {{statusOp[scope.row.status]}}
          </template>
        </el-table-column>
        <el-table-column prop="deptId" label="部门号"></el-table-column>
        <el-table-column prop="createBy" label="创建人"></el-table-column>
        <el-table-column prop="createTime" label="创建时间"></el-table-column>
        <el-table-column prop="lastUpdateBy" label="更新人"></el-table-column>
        <el-table-column prop="lastUpdateTime" label="更新时间"></el-table-column>
        <el-table-column fixed="right" label="操作" width="150">
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="updateUser(scope.row)">修改</el-button>
            <el-button type="text" size="small" @click="deleteUser(scope.row)">删除</el-button>
            <el-button type="text" size="small" @click="detail(scope.row)">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="page-div">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
    <div class="dialog-div">
      <!--      status-icon属性为输入框添加了表示校验结果的反馈图标-->
      <el-dialog :title="title" :visible.sync="dialogFormVisible">
        <el-form :model="dialogForm" :rules="rules" ref="dialogForm" status-icon :label-width="formLabelWidth"
                 label-position="right">
          <el-form-item label="用户名" prop="name">
            <el-input v-model="dialogForm.name" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="nickName">
            <el-input v-model="dialogForm.nickName" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="dialogForm.email" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="dialogForm.mobile" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="部门">
            <el-input v-model="dialogForm.deptId" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="角色">
            <el-input v-model="dialogForm.role" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="状态" v-show="flag == 'detail'">
            <el-input v-model="dialogForm.status" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="创建人" v-show="flag == 'detail'">
            <el-input v-model="dialogForm.createBy" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="创建时间" v-show="flag == 'detail'">
            <el-input v-model="dialogForm.createTime" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="更新人" v-show="flag == 'detail'">
            <el-input v-model="dialogForm.lastUpdateBy" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
          <el-form-item label="更新时间" v-show="flag == 'detail'">
            <el-input v-model="dialogForm.lastUpdateTime" class="input" :readonly="readOnly"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancel('dialogForm')">取 消</el-button>
          <el-button type="primary" @click="confirm('dialogForm')">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
    name: "User",
    data() {
      //自定义的表单校验
      var checkName = (rule, value, callback) => {
        if (!value) {
          return callback(new Error("请输入用户名"));
        }
        if (!/^[a-zA-Z\s]+$/.test(value)) {
          return callback(new Error("用户名只能为英文"));
        } else {
          callback();
        }
      };
      return {
        currentPage: 1,
        pageSize: 10,
        total: 35,
        userInfoTable: [
          {
            name: "admin",
            nickName: "admin",
            email: "2342@qq.com",
            mobile: "15711111111",
            status: "1",
            deptId: "4",
            createBy: null,
            createTime: "2020-07-12",
            lastUpdateBy: null,
            lastUpdateTime: null
          }
        ],
        queryForm: {},
        title: "新增用户",
        dialogFormVisible: false,
        dialogForm: {},
        formLabelWidth: '120px',
        readOnly: false,
        flag: "",
        statusOp: {
          "1": "正常",
          "0": "禁用"
        },
        rules: {
          nickName: [
            {required: true, message: "请输入姓名", trigger: 'blur'},
            {min: 2, max: 8, message: "长度在3到8个字符", trigger: 'blur'}
          ],
          name: [
            {required: true, validator: checkName, trigger: 'blur'},
            {min: 5, max: 12, message: "长度在5到12个字符", trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      onSubmit() {
        console.log("onSubmit")
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      addUser() {
        this.flag = 'add';
        this.dialogFormVisible = true;
      },
      updateUser(row) {
        this.flag = "update"
        this.title = '修改用户';
        this.dialogForm = row;
        this.dialogFormVisible = true;
      },
      deleteUser(row) {
        this.flag = "delete"
        this.title = '删除用户';
        this.dialogForm = row;
        this.readOnly = true;
        this.dialogFormVisible = true;
      },
      detail(row) {
        this.flag = "detail"
        this.title = "用户信息";
        this.dialogForm = row;
        this.readOnly = true;
        this.dialogFormVisible = true;
      },
      confirm(dialogForm) {
        this.$refs[dialogForm].validate((valid) => {
          if (valid) {
            this.confirmToUser();
          } else {
            return false;
          }
        })
      },
      confirmToUser() {
        if (this.flag == "add") {
          this.addToUser();
        } else if (this.flag == "update") {
          this.updateToUser();
        } else if (this.flag == "delete") {
          this.deleteToUser();
        } else if (this.flag == "detail") {
          this.dialogFormVisible = false;
        }
      },
      cancel(dialogForm) {
        this.flag = "";
        this.dialogFormVisible = false;
        this.readOnly = false;
        this.dialogForm = {};
        //重置表单校验
        this.$refs[dialogForm].resetFields();
      },
      addToUser() {
        console.log("add")
      },
      updateToUser() {
        console.log("update")
      },
      deleteToUser() {
        console.log("delete")
      }
    }
  }
</script>

<style scoped lang="scss">
  .container {
    width: 80%;
    margin: 50px auto;

    .from-div {

    }

    .table-div {
      margin-top: 20px;
    }

    .page-div {
      text-align: left;
      margin-top: 10px;
    }

    .dialog-div {
      text-align: left;

      .input {
        width: 300px;
      }
    }
  }
</style>
