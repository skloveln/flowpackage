package com.bupt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
	public static Logger logger = LoggerFactory.getLogger(Hello.class);
	

    public boolean hello() {
    	logger.trace("entry");
        logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
        logger.info("我是info信息");    //info级别的信息
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
        logger.trace("exit");
        return false;
    }
    
    public static void main(String[] args) {
		Hello hel = new Hello();
		hel.hello();
	}
}
