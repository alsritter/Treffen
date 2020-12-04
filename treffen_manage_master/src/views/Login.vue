<template>
    <div class="login">
        <LoginBox class="loginBox" />
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import LoginBox from "@/components/LoginBox.vue";

export default defineComponent({
    components: {
        LoginBox
    },
    setup() {
        return {};
    }
});
</script>

<style lang="less" scoped>
.login {
    background-color: rgb(218, 224, 228);
    height: 100%;
    .loginBox {
        position: relative;
        left: 60%;
        top: 15%;
    }
}
</style>
