<template>
    <el-card class="box-card" :body-style="{ height: '400px' }">
        <template #header>
            <div class="clearfix">
                <span>登陆</span>
            </div>
        </template>
        <el-form label-width="70px" :rules="rules" :model="state" ref="formRef">
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
            <el-form-item label="验证码" prop="verify">
                <el-input
                    style="width: 180px"
                    v-model="state.verify"
                    placeholder="请输入验证码"
                    autocomplete="off"
                    :maxlength="5"
                ></el-input>
                <el-image
                    :src="imageURL"
                    class="login-code-img"
                    @click="getImageCode"
                ></el-image>
            </el-form-item>
            <el-form-item label="">
                <el-checkbox v-model="state.rememberMe">记住密码</el-checkbox>
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
import { defineComponent, reactive, ref, getCurrentInstance } from "vue";
import { ElForm } from "element-plus";
import axios from "axios";
import router from "@/router";

interface LoginState {
    username: string;
    password: string;
    uuid: string;
    rememberMe: boolean;
    verify: string;
}

export default defineComponent({
    setup() {
        const message = getCurrentInstance()?.appContext.config.globalProperties
            .$message;
        // 取得这个 ref 对象
        const formRef = ref<InstanceType<typeof ElForm>>();

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
            verify: [
                { required: true, message: "请输入验证码", trigger: "blur" }
            ]
        };

        // 先取得验证码
        const imageURL = ref("");
        const getImageCode = () => {
            const uuid: string = new String(new Date().getTime()).toString();
            sessionStorage.setItem("uuid", uuid);
            axios
                .get("/api/utils/imagecode", {
                    params: {
                        //请求参数
                        uuid: uuid
                    },
                    responseType: "blob"
                })
                .then(result => {
                    imageURL.value = window.webkitURL.createObjectURL(
                        result.data
                    );
                })
                .catch(error => {
                    console.error(error);
                });
        };

        getImageCode();

        const state = reactive({
            username: "",
            password: "",
            verify: "",
            rememberMe: false,
            uuid: ""
        }) as LoginState;

        async function submitForm(formName: LoginState) {
            formName.uuid = sessionStorage.getItem("uuid") as string;
            formRef.value?.validate(async valid => {
                if (!valid) {
                    return message.error("登陆失败");
                }
                axios
                    .post("/api/auth/login", formName)
                    .then(res => {
                        localStorage.setItem(
                            "token",
                            res.headers.authorization
                        );
                        message.success("登陆成功");
                        setTimeout(() => {
                            router.push("/");
                        }, 500);
                    })
                    .catch(error => {
                        console.error(error);
                    });
            });
        }

        return { state, imageURL, rules, submitForm, getImageCode, formRef };
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
        height: 40px;
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
