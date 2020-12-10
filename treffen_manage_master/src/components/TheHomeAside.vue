<template>
    <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="isCollapse" @click="isCollapse = !isCollapse">
            <div>{{ isCollapse ? "展开" : "折叠" }}</div>
        </div>
        <!-- 侧边栏菜单区域 
        开启 router 表示以 index 作为 path 进行路由跳转-->
        <el-menu
            class="el-menu-vertical"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            unique-opened
            :router="true"
            :collapse-transition="false"
            :collapse="isCollapse"
        >
            <!-- 加一个  v-if="menus" 当为空时不刷新 -->
            <div v-if="menus">
                <!-- 一级菜单 -->
                <el-submenu
                    v-for="item in menus"
                    :index="item.menuItemGroup.groupId + ''"
                    :key="item.menuItemGroup.groupId"
                >
                    <!-- 一级菜单的模板区域 -->
                    <template #title>
                        <!-- 图标 -->
                        <i :class="item.menuItemGroup.groupIcon"></i>
                        <!-- 文本 -->
                        <span>{{ item.menuItemGroup.groupName }}</span>
                    </template>
                    <!-- 二级菜单 -->
                    <el-menu-item
                        v-for="subItem in item.itemList"
                        :index="subItem.itemName"
                        :key="subItem.itemPath"
                        :route="{ path: '/' + subItem.itemPath }"
                        @click="handleSelect(subItem)"
                    >
                        <template #title>
                            <!-- 文本 -->
                            <span>{{ subItem.itemName }}</span>
                        </template>
                    </el-menu-item>
                </el-submenu>
            </div>
        </el-menu>
    </el-aside>
</template>
<script lang="ts">
import getHomeAsideMenu from "@/common/getHomeAsideMenu";
import { defineComponent, reactive, ref } from "vue";

interface MenuItemGroup {
    groupId: number;
    groupName: string;
    groupIcon: string;
}

interface Item {
    itemId: number;
    itemName: string;
    isDeleted: number;
    itemDesc: void /* 未知类型 */;
    itemPath: string;
    itemGroup: number;
}

interface Menus {
    menuItemGroup: MenuItemGroup;
    itemList: Item[];
}

export default defineComponent({
    setup(props, { emit }) {
        const menus = reactive<Menus[]>([]);
        const isCollapse = ref(false);

        getHomeAsideMenu()
            .then(res => {
                for (const iterator of res) {
                    menus.push(iterator);
                }
            })
            .catch(error => {
                console.error(error);
            });

        function handleSelect(item: Item) {
            emit("add-tag", item.itemName, item.itemPath);
        }

        return {
            handleSelect,
            menus,
            isCollapse
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

    .el-menu-vertical:not(.el-menu--collapse) {
        // width: 500px;
        // min-height: 1000px;
    }

    /*隐藏文字*/
    .el-menu--collapse .el-submenu__title span {
        display: none;
    }
    /*隐藏 > */
    .el-menu--collapse .el-submenu__title .el-submenu__icon-arrow {
        display: none;
    }

    .isCollapse {
        width: 100%;
        height: 50px;
        color: #909399;
        text-align: center;
        font-weight: bold;
        div {
            display: block;
            position: relative;
            top: 50%;
            transform: translate(0, -50%);
        }
    }
    .isCollapse:hover {
        background-color: #42484e !important;
        cursor: pointer;
    }
}
</style>
