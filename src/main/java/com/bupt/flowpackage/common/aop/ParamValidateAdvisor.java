package com.bupt.flowpackage.common.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bupt.flowpackage.common.domain.BaseRequest;
import com.bupt.flowpackage.utils.ValidatorUtil;
/**
* @Description:参数校验拦截器
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月18日 下午5:26:52
 */
public class ParamValidateAdvisor {
	public static Logger logger = LoggerFactory.getLogger(ParamValidateAdvisor.class);
	
	public Object validate(ProceedingJoinPoint pjp) throws Throwable{
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		String clsAndMethodName = pjp.getTarget().getClass().getSimpleName() + "." + method.getName();
		Object[] objs = pjp.getArgs();  
		for(Object arg : objs){
			if(arg instanceof BaseRequest){
				String requestNo = ((BaseRequest) arg).getRequestNo();
				try{
					ValidatorUtil.validReqBean(arg);
					logger.info("\n requestNo={} method={}校验参数通过!", requestNo,  clsAndMethodName);
				}catch(Exception e) {
					logger.error("\n requestNo={} method={}校验参数失败! errorMsg={}", requestNo, clsAndMethodName, e.getMessage());
					throw e;
				}
			}
		}
		return pjp.proceed(objs);  
	}
}
