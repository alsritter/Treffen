<template>
    <el-container>
        <el-header>Header</el-header>
        <el-container>
            <TheHomeAside />
            <el-main>
                <!-- 路由占位符 -->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>
<script lang="ts">
import { defineComponent } from "vue";
import TheHomeAside from "@/components/TheHomeAside.vue";

export default defineComponent({
    name: "Home",
    components: {
        TheHomeAside
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
}
</style>
