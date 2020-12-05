module.exports = {
    /** 区分打包环境与开发环境
     * process.env.NODE_ENV==='production'  (打包环境)
     * process.env.NODE_ENV==='development' (开发环境)
     */
    // 输出文件目录
    outputDir: "dist",
    // webpack-dev-server 相关配置
    // 参考资料 https://cli.vuejs.org/zh/config/#devserver
    devServer: {
        open: process.platform === "darwin",
        host: "127.0.0.1",
        port: 5500,
        https: false,
        hotOnly: false,
        proxy: {
            "/api": {
                target: "http://localhost:7758/"
            }
        } // 设置代理:在开发环境下将 API 请求代理到 API 服务器。
    },
    // 第三方插件配置
    pluginOptions: {
        // ...
    }
};
