package com.utils;

public class CommonConst {

    /**
     * 超级管理员的用户Id
     */
    public static final int ADMIN_USER_ID = 1;

    /**
     * IP历史记录缓存
     */
    public static final String IP_HISTORY = "ip_history";
    public static final String IP_HISTORY_STATISTICS = "ip_history_statistics";
    public static final String IP_HISTORY_PROVINCE = "ip_history_province";
    public static final String IP_HISTORY_IP = "ip_history_ip";
    public static final String IP_HISTORY_HOUR = "ip_history_hour";
    public static final String IP_HISTORY_COUNT = "ip_history_count";


    /**
     * 默认缓存过期时间
     */
    public static final long EXPIRE = 1800;


    /**
     * 顶层评论ID
     */
    public static final int FIRST_COMMENT = 0;

    /**
     * 文章摘要默认字数
     */
    public static final int SUMMARY = 80;

    /**
     * 留言的源
     */
    public static final int TREE_HOLE_COMMENT_SOURCE = 0;

    /**
     * 根据酒店ID获取评论数量
     */
    public static final String COMMENT_COUNT_CACHE = "comment_count_";
}
