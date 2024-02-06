<template>
  <div>
    <el-menu
        :default-active="this.$router.path"
        text-color="#409eff"
        class="el-menu-vertical-demo"
        unique-opened
        router
        @open="handleOpen"
        @close="handleClose"
        :collapse="isCollapse"
    >
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-setting"></i>
          <span slot="title">系统设置</span>
        </template>
        <el-menu-item index="/system/role">
          <i class="el-icon-user"></i>
          <span slot="title">角色管理</span>
        </el-menu-item>
        <el-menu-item index="/system/authority">
          <i class="el-icon-key"></i>
          <span slot="title">权限管理</span>
        </el-menu-item>
        <el-menu-item index="/system/user">
          <i class="el-icon-user-solid"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>
<script>
export default {
  name: "mainLeft",

  data() {
    return {
      isCollapse: false,
    };
  },

};
</script>

