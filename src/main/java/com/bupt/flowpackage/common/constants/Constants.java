package com.bupt.flowpackage.common.constants;

public interface Constants {
	
	public static final Integer EXPIRE_IN_100M = 60*100;             //过期时间100分钟 (60*100 秒)
    public static final Integer EXPIRE_IN_20H = 60*60*20;            //过期时间20小时 (60*60*20秒)
    public static final Integer EXPIRE_IN_10H = 60*60*20;            //过期时间10小时 (60*60*10秒)
    public static final Integer EXPIRE_IN_30M = 60*30;               //过期时间30分钟 (60*30 秒)
    public static final Integer EXPIRE_IN_20M = 60*20;               //过期时间20分钟 (60*20 秒)
    public static final Integer EXPIRE_IN_10M = 60*10;               //过期时间10分钟 (60*10 秒)
    public static final Integer EXPIRE_IN_7D = 60*60*24*7;           //过期时间7天 (60*60*24*7 秒)
    
    static final String INDEX_PAGE ="home";//首页
	static final String LOGIN_PAGE ="login";//登陆页
	static final String PAGE_404 ="errorpages/error-404";//404页面
	static final String PAGE_500 ="errorpages/error-500";//500页面
	static final String PAGE_NOAUTH ="errorpages/error-noauth";//无权限页面
}
