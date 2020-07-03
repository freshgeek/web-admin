package com.demo.webadmin.config;

import com.demo.webadmin.common.ResponseResult;
import com.demo.webadmin.common.ResultCodeMsg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * 统一异常处理类
 *
 * @author lvxc
 * 2018年7月4日 下午7:32:48
 */
@ControllerAdvice(basePackages = "com")
public class ExceptionHandle {

	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	public ResponseResult<Object> handler(HttpServletRequest request, Exception e) {
		return ResponseResult.error(-1,e.getMessage());
	}

}

