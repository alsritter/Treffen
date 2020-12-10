<template>
    <el-container>
        <el-header>
            <el-tooltip
                class="item"
                effect="dark"
                content="退出登陆"
                placement="bottom"
            >
                <el-button
                    type="danger"
                    icon="el-icon-close"
                    circle
                    class="logout"
                    @click="logout"
                ></el-button>
            </el-tooltip>
        </el-header>
        <el-container>
            <TheHomeAside @add-tag="addTag" />
            <el-main>
                <el-tabs
                    v-model="editableTabsValue"
                    type="card"
                    closable
                    @tab-remove="removeTab"
                    @tab-click="routerToUrl"
                    ref="formRef"
                >
                    <el-tab-pane
                        :key="item.name"
                        v-for="item in editableTabs"
                        :label="item.title"
                        :name="item.path"
                    >
                    </el-tab-pane>
                    <router-view></router-view>
                </el-tabs>
                <!-- 路由占位符 -->
            </el-main>
        </el-container>
    </el-container>
</template>
<script lang="ts">
import { defineComponent, ref, reactive } from "vue";
import TheHomeAside from "@/components/TheHomeAside.vue";
import logout from "@/common/logout";
import { ElTabs } from "element-plus";
import { useRouter } from "vue-router";

export default defineComponent({
    name: "Home",
    components: {
        TheHomeAside
    },
    setup() {
        const formRef = ref<InstanceType<typeof ElTabs>>();
        const router = useRouter();

        const editableTabsValue = ref("2");

        const editableTabs = reactive([
            {
                title: "Home",
                path: "/myStat"
            }
        ]);

        function removeTab(targetName: string) {
            editableTabs.forEach((item, index, arr) => {
                if (item.path === targetName) {
                    arr.splice(index, 1);
                    // 再跳转到 List 的上一个页面上去
                    if (editableTabs[index - 1]) {
                        editableTabsValue.value = editableTabs[index - 1].path;
                        router.push(editableTabs[index - 1].path);
                    }
                }
            });
        }

        function addTag(targetName: string, path: string) {
            editableTabsValue.value = path;
            for (const iterator of editableTabs) {
                if (iterator.path === path) {
                    router.push(path);
                    return;
                }
            }
            editableTabs.push({
                title: targetName,
                path: path
            });
        }

        function routerToUrl(e: any) {
            router.push(e.props.name);
        }

        return {
            logout,
            editableTabsValue,
            editableTabs,
            removeTab,
            routerToUrl,
            formRef,
            addTag
        };
    }
});
</script>
<style lang="less" scoped>
.el-container {
    height: 100%;
    width: 100%;
}
.el-header {
    background-color: #3e4246;
    .logout {
        position: relative;
        left: 95%;
        transform: translate(-50%, 20%);
    }
}
</style>
