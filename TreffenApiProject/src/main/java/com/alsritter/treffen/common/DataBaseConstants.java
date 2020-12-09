package com.alsritter.treffen.common;

/**
 * 这里用来存储数据库里面的内容的 Key，当一个真正的缓存服务器
 *
 * @author alsritter
 * @version 1.0
 **/
public final class DataBaseConstants {
    private DataBaseConstants() {}

    /**
     * 还未结束的会议的过期时间(单位是秒)
     */
    public static final long ALL_START_MEETING_TIME = 60 * 10L;

    /**
     * 还未结束的会议的 Key
     */
    public static final String ALL_START_MEETING = "ALL_START_MEETING";
}
