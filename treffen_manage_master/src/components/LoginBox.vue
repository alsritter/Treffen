<template>
    <el-card class="box-card" :body-style="{ height: '400px' }">
        <template #header>
            <div class="clearfix">
                <span>登陆</span>
            </div>
        </template>
        <el-form label-width="70px" :rules="rules" :model="state">
            <el-form-item label="用户名" prop="username">
                <el-input
                    v-model="state.username"
                    placeholder="请输入用户名"
                    :maxlength="15"
                ></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input
                    type="password"
                    v-model="state.password"
                    placeholder="请输入密码"
                    autocomplete="off"
                    :maxlength="20"
                ></el-input>
            </el-form-item>
            <el-form-item label="验证码" prop="code">
                <el-input
                    style="width: 180px"
                    v-model="state.code"
                    placeholder="请输入验证码"
                    autocomplete="off"
                    :maxlength="5"
                ></el-input>
                <el-image :src="imageURL" class="login-code-img"></el-image>
            </el-form-item>
            <el-form-item label="">
                <el-checkbox v-model="state.remember">记住密码</el-checkbox>
            </el-form-item>
            <el-form-item class="login_button">
                <el-button
                    type="primary"
                    @click="submitForm(state)"
                    style="width: 200px; height: 50px"
                >
                    登陆
                </el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script lang="ts">
import { defineComponent, reactive } from "vue";

interface LoginState {
    username: string;
    password: string;
    code: string;
    remember: boolean;
}

export default defineComponent({
    setup() {
        const rules = {
            username: [
                { required: true, message: "请输入用户名", trigger: "blur" },
                {
                    required: true,
                    pattern: /^[\u4e00-\u9fa5_a-zA-Z0-9.·-]+$/,
                    message: "用户名不支持特殊字符",
                    trigger: "blur"
                }
            ],
            password: [
                { required: true, message: "请输入密码", trigger: "blur" }
            ],
            code: [{ required: true, message: "请输入验证码", trigger: "blur" }]
        };
        const imageURL = "";
        const state = reactive({
            username: "",
            password: "",
            code: "",
            remember: false
        }) as LoginState;

        function submitForm(formName: LoginState) {
            console.log(formName);
        }

        return { state, imageURL, rules, submitForm };
    }
});
</script>

<style lang="less" scoped>
.box-card {
    width: 500px;
    .login-code-img {
        position: absolute;
        margin-left: 10px;
        width: 180px;
        border-radius: 5px;
    }
    .login_button {
        /deep/ .el-form-item__content {
            margin-left: 0px !important;
            button.el-button.el-button--primary {
                transform: translate(-50%, 30%);
                position: relative;
                left: 50%;
            }
        }
    }
}
</style>
