<template>
    <el-aside width="200px">
        <!-- 侧边栏菜单区域 -->
        <el-menu
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            unique-opened
            :collapse-transition="false"
            router
        >
            <!-- 一级菜单 -->
            <el-submenu
                v-for="item in menus"
                :index="item.name"
                :key="item.name"
            >
                <!-- 一级菜单的模板区域 -->
                <template v-slot:title>
                    <!-- 图标 -->
                    <i :class="item.icon"></i>
                    <!-- 文本 -->
                    <span>{{ item.name }}</span>
                </template>
                <!-- 二级菜单 -->
                <el-menu-item
                    :index="'/' + subItem.path"
                    v-for="subItem in item.subMenus"
                    :key="subItem.path"
                >
                    <template #title>
                        <!-- 文本 -->
                        <span>{{ subItem.name }}</span>
                    </template>
                </el-menu-item>
            </el-submenu>
        </el-menu>
    </el-aside>
</template>
<script lang="ts">
import getHomeAsideMenu from "@/common/getHomeAsideMenu";
import { defineComponent } from "vue";

export default defineComponent({
    setup() {
        const menus = getHomeAsideMenu();
        return {
            menus
        };
    }
});
</script>
<style lang="less" scoped>
.el-aside {
    background-color: #545c64;
    li.el-menu-item {
        background-color: #42484e !important;
    }
}
</style>
