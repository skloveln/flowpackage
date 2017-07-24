package com.bupt.flowpackage.utils;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.bupt.flowpackage.common.exception.BizException;

/**
* @Description: 校验service层参数
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月18日 下午3:47:06
 */
public class ValidatorUtil {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	/**
	 * 验证bean是否符合规则，不符合则抛出异常
	 * @param tlBean
	 * @throws BizException
	 */
	public static void validReqBean(Object bean) throws BizException {
		if (null == bean) {
			BizException.warn("校验对象不能为空");
		}
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(bean);

		Iterator<ConstraintViolation<Object>> iterator = constraintViolations.iterator();
		StringBuffer desc = new StringBuffer();
		while (iterator.hasNext()) {
			ConstraintViolation<Object> constraintViolation = iterator.next();
			String msg = constraintViolation.getMessage();
			desc.append(msg);
			break;
		}
		if (constraintViolations.size() > 0) {
			BizException.warn(desc.toString());
		}
	}

}
