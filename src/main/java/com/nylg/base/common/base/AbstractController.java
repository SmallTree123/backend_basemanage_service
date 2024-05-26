package com.nylg.base.common.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nylg.base.authentication.detail.CustomUserDetailsUser;
import com.nylg.base.common.utils.UserUtil;
import com.nylg.base.common.utils.MPPageConvert;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller公共组件
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2016年11月9日 下午9:42:26
 */

public abstract class AbstractController {

	@Autowired
	protected MPPageConvert mpPageConvert;

	@Autowired
	public ObjectMapper objectMapper;

	protected CustomUserDetailsUser getUser() {
		return UserUtil.getUser();
	}

	@SneakyThrows
	protected String getUserId() {
		return UserUtil.getUserId();
	}
}
