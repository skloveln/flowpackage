package com.bupt.flowpackage.common.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bupt.flowpackage.common.domain.BaseRequest;
import com.bupt.flowpackage.common.domain.BaseResponse;

/**
* @Description: 控制器日志拦截器
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年7月25日 下午5:34:05
 */
public class LogAdvisor {
	public static Logger logger = LoggerFactory.getLogger(LogAdvisor.class);
	
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		String clsAndMethodName = pjp.getTarget().getClass().getSimpleName() + "." + method.getName();
		Object[] objs = pjp.getArgs();  
		for(Object arg : objs){
			if(arg instanceof BaseRequest){
				logger.info("\n访问method={} 请求req={}", clsAndMethodName, arg);
			}
		}
		Object retObj = pjp.proceed();
		if(retObj instanceof BaseResponse) {
			logger.info("\n访问method={} 返回resp={}", clsAndMethodName, retObj);
		}
		return retObj;
	}
}
