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
                :index="item.menuItemGroup.groupId"
                :key="item.menuItemGroup.groupId"
            >
                <!-- 一级菜单的模板区域 -->
                <template v-slot:title>
                    <!-- 图标 -->
                    <i :class="item.menuItemGroup.groupIcon"></i>
                    <!-- 文本 -->
                    <span> sss {{ item.menuItemGroup.groupName }}</span>
                </template>
                <!-- 二级菜单 -->
                <el-menu-item
                    v-for="subItem in item.itemList"
                    :index="'/' + subItem.itemPath"
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
import { defineComponent, reactive } from "vue";

export default defineComponent({
    setup() {
        const menus: any[] = [];

        getHomeAsideMenu().then(res => {
            for (const iterator of res) {
                menus.push(iterator);
            }
            console.log(menus);
        });

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
