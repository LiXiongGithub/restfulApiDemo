package com.lx.eclipse.contorller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lx.eclipse.service.EclipseMavenTestService;
import com.lx.eclipse.vo.EclipseMavenTest;

@Controller
@RequestMapping("/user")
public class EclipseController {
	private static Logger logger = Logger.getLogger(EclipseController.class);
	@Autowired EclipseMavenTestService eclipseMavenTestService;
	
	@RequestMapping("/insertUser")
	public String insert(HttpServletRequest request,Model model){
		logger.info("用户注册controller");
		String userName = request.getParameter("userName");
		String password  = request.getParameter("password");
		String name = request.getParameter("name");
		String flag = null;
		EclipseMavenTest eclipseMavenTest = new EclipseMavenTest();
		eclipseMavenTest.setName(name);
		eclipseMavenTest.setPassword(password);
		eclipseMavenTest.setUsername(userName);
		
		if(StringUtils.isEmpty(userName)){
			flag ="用户名为空！";
			model.addAttribute("insertFlag", flag);
			return "login";
		}
		if(StringUtils.isEmpty(password)){
			flag ="密码为空！";
			model.addAttribute("insertFlag", flag);
			return "login";
		}
		
		
		int insertFlag = eclipseMavenTestService.insert(eclipseMavenTest);
		
		if(insertFlag == 1){
			flag="注册成功！";
			model.addAttribute("insertFlag", flag);
		}else{
			flag="注册失败！";
			model.addAttribute("insertFlag", flag);
		}
		return "login";
		
	}
}
