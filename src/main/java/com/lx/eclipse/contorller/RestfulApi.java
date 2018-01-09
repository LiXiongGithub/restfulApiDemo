package com.lx.eclipse.contorller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.eclipse.service.EclipseMavenTestService;
import com.lx.eclipse.util.ResponseStatus;
import com.lx.eclipse.util.ResponseStatus.ResponseStatusBuilder;

@Controller
@RequestMapping("/User")
public class RestfulApi {

	private static Logger logger = LoggerFactory.getLogger(EclipseController.class);
	@Autowired
	EclipseMavenTestService eclipseMavenTestService;

	/**
	 * get接口
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/helloRestful", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String hello(HttpServletRequest request, HttpServletResponse response, Model model) {
		ResponseStatusBuilder builder = ResponseStatus.create();
		builder.status("20000");
		builder.msg("hello restful");
		builder.code("200");
		logger.info("hello restful");
		return builder.build().toString();
		
	}
	/**
	 * post接口,带有路径参数、请求参数、请求体的接口required = false
	 * @param request
	 * @param response
	 * @param pathP
	 * @param taskKey
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{pathP}/hellopost", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String hellopost(HttpServletRequest request, HttpServletResponse response,
			@PathVariable(value = "pathP") String pathP,
			@RequestParam(value = "taskKey", required = false) String taskKey, @RequestBody String data) {
		logger.info("data = " + data + "taskKey = " + taskKey);
		ResponseStatusBuilder builder = ResponseStatus.create();
		builder.status("20000");
		builder.msg("hello restfulpost = " + "data = " + data + "taskKey = " + taskKey+ "pathP = " + pathP);
		builder.code("200");
		return builder.build().toString();
	}

	//
	// public String insert(HttpServletRequest request, Model model,@RequestBody
	// String data) {
	// logger.info("用户注册controller");
	// String userName = request.getParameter("userName");
	// String password = request.getParameter("password");
	// String name = request.getParameter("name");
	// String flag = null;
	// EclipseMavenTest eclipseMavenTest = new EclipseMavenTest();
	// eclipseMavenTest.setName(name);
	// eclipseMavenTest.setPassword(password);
	// eclipseMavenTest.setUsername(userName);
	//
	// if (StringUtils.isEmpty(userName)) {
	// flag = "用户名为空！";
	// model.addAttribute("insertFlag", flag);
	// return "login";
	// }
	// if (StringUtils.isEmpty(password)) {
	// flag = "密码为空！";
	// model.addAttribute("insertFlag", flag);
	// return "login";
	// }
	//
	// int insertFlag = eclipseMavenTestService.insert(eclipseMavenTest);
	//
	// if (insertFlag == 1) {
	// flag = "注册成功！";
	// model.addAttribute("insertFlag", flag);
	// } else {
	// flag = "注册失败！";
	// model.addAttribute("insertFlag", flag);
	// }
	// return "login";
	// }
}
