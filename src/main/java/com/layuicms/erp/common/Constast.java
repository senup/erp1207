package com.layuicms.erp.common;

public interface Constast {
    //状态码
    public static final Integer OK = 200;
    public static final Integer ERROR = -1;

    //菜单权限类型
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_PERMISSION = "permission";

    //可以状态
    public static final Object TYPE_AVAILABLE_TRUE = 1;
    public static final Object TYPE_AVAILABLE_FALSE = 0;

    //用户类型
    public static final Integer UERR_TYPE_SUPER = 0;
    public static final Integer UERR_TYPE_NORMAL = 1;

    //是否展开
    public static final Integer OPEN_TURE = 1;
    public static final Integer OPEN_FALSE = 0;
}
