package com.alsritter.treffen.common;

/**
 * 这里在这里自定响应码枚举，方便排错
 * 这几个状态码的含意
 * 400：Bad Request 客户端请求报文中存在语法错误，服务器无法理解。浏览器会像 200 OK一样对待该状态码
 * 401：Unauthorized 请求要求用户的身份认证，通过 HTTP认证（BASIC认证，DIGEST认证）的认证信息，若之前已进行过一次请求，则表示用户认证失败
 * 403：Forbidden 服务器理解请求客户端的请求，但是拒绝执行此请求
 * 404：Not Found  服务器无法根据客户端的请求找到资源（网页）。通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面。也可以在服务器拒绝请求且不想说明理由时使用
 * 500：Internal Server Error 服务器内部错误，无法完成请求，也可能是web应用存在bug或某些临时故障
 * 501：Not Implemented 服务器不支持请求的功能，无法完成请求
 * 503：Service Unavailable 由于超载或系统维护，服务器暂时的无法处理客户端的请求。延时的长度可包含在服务器的 Retry-After 头信息中
 */
public enum ServiceErrorResultEnum {
    PARAMETER_ERROR(400,"请求的数据格式不符!"),
    MISSING_PARAMETER_ERROR(400,"丢失参数"),
    PARAMETER_NOT_READABLE(500,"请求的数据不可读"),
    REQUEST_METHOD_NOT_EXIST(404,"请求类型不符合!"),
    SAME_LOGIN_NAME_EXIST(400,"用户名已存在!"),
    UNAUTHORIZED(401,"请求的数字签名不匹配!"),
    LOGIN_NAME_NULL(400,"请输入登录名！"),
    LOGIN_NAME_IS_NOT_PHONE(400,"请输入正确的手机号！"),
    LOGIN_PASSWORD_NULL(400,"请输入密码！"),
    VERIFY_CODE_NULL(400,"请输入验证码！"),
    VERIFY_CODE_TIMEOUT_OR_NOT_EXIST(400,"验证码不存在或超时！"),
    VERIFY_CODE_ERROR(401,"验证码错误！"),
    FORBIDDEN(403,"被禁止访问!"),
    NOT_ENOUGH_PERMISSIONS(403, "权限不足!"),
    NOT_FOUND(404, "请求的资源不存在!"),
    SHOPPING_CART_ITEM_EXIST_ERROR(403,"已存在！无需重复添加！"),
    LOGIN_ERROR(401,"登录失败！"),
    NOT_LOGIN_ERROR(401,"未登录！"),
    TOKEN_EXPIRE_ERROR(401,"无效认证！请重新登录！"),
    USER_NULL_ERROR(401,"无效用户！请重新登录！"),
    LOGIN_USER_LOCKED_ERROR(403,"用户已被禁止登录！"),
    OPERATE_ERROR(500,"操作失败！"),
    REQUEST_FORBIDEN_ERROR(403,"禁止该操作！"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    VERIFY_CODE_CREATE_ERROR(500, "验证码生成错误"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    /** 响应码 */
    private final Integer resultCode;

    /** 响应描述 */
    private final String resultMsg;

    ServiceErrorResultEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }
}