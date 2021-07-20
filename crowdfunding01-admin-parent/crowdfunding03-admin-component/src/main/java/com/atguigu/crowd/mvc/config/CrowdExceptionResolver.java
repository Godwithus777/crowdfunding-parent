package com.atguigu.crowd.mvc.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crowd.exception.AccessForbiddenException;
import com.atguigu.crowd.exception.LoginFailedException;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import com.google.gson.Gson;

@ControllerAdvice
public class CrowdExceptionResolver {

	
	@ExceptionHandler(value=LoginFailedException.class)
	public ModelAndView resolveLoginFailedException(
				LoginFailedException exception,
				HttpServletRequest request,
				HttpServletResponse response
			
			) throws IOException{
		String viewName = "admin-login";
		return commonResolve(viewName, exception, request, response);
	}
	// 表示用户没有登录就访问受保护资源时抛出的异常
	@ExceptionHandler(value = AccessForbiddenException.class)
	public ModelAndView resolveAccessForbiddenException(
			AccessForbiddenException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException{
		String viewName = "admin-login";
		return commonResolve(viewName, exception, request, response);
	}
	
	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView resolveMathException(

	ArithmeticException exception, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String viewName = "system-error";
		return commonResolve(viewName, exception, request, response);
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView resolveNullPointerException(
			NullPointerException exception,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException{
		String viewName = "system-error";
		
		return commonResolve(viewName, exception, request, response);
	}

	private ModelAndView commonResolve(
	// 异常处理完成后要去的页面
			String viewName,

			// 实际捕获到的异常类型
			Exception exception,

			// 当前请求对象
			HttpServletRequest request,

			// 当前响应对象
			HttpServletResponse response) throws IOException {

		boolean judgeResult = CrowdUtil.judegeRequestType(request);

		// 2.如果是Ajax请求
		if (judgeResult) {

			// 3.创建ResultEntity对象
			ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
			// 4.创建Gson对象
			Gson gson = new Gson();

			// 5.将ResultEntity对象转换为JSON字符串
			String json = gson.toJson(resultEntity);
			// 6.将JSON字符串作为响应体返回给浏览器
			response.getWriter().write(json);

			// 7.由于上面已经通过原生的response对象返回了响应，所以不提供ModelAndView对象
			return null;
		}
		// 8.如果不是Ajax请求创建ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		
		// 9.将Exception对象存入模型
		modelAndView.addObject("exception",exception);
		
		// 10.设置对应的视图名称
		modelAndView.setViewName(viewName);
		
		// 11.返回modelAndView对象
		return modelAndView;
	}

}
