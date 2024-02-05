package com.common.constant;

/**
 * 静态定义
 *
 * @author DELL
 * @version 1.0
 * @date 2020-11-17 16:53
 */
public interface Constants {

    /**
     * 删除
     */
    String STATUS_DEL = "1";

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单树根节点
     */
    Integer MENU_TREE_ROOT_ID = -1;

    /**
     * 菜单
     */
    String MENU = "0";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 请求成功
     */
    String CODE_200 = "200";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

    /**
     * 当前页
     */
    String CURRENT = "current";

    /**
     * size
     */
    String SIZE = "size";

    /**
     * 默认错误代码
     */
    String DEFAULT_ERRORCODE = "000";

    /**
     * 验证码缓存前缀
     */
    String CAPTCHA_PREFIX = "CAPTCHA:";
}
