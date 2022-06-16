package tw.com.ispan.cma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.ispan.cma.domain.CustomerBean;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.service.CustomerService;
import tw.com.ispan.cma.service.MembersService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
public class KevinLoginController {

	@Autowired
	private MembersService membersService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = {"/kevinLogin"})
	public String handlerMethod(Locale locale, Model model, String username, String password, HttpSession session) {
		System.out.println("KevinLoginController有被呼叫到");
//接收資料
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);

		if(username==null || username.length()==0) {
			System.out.println("需要輸入帳號");
			errors.put("username", messageSource.getMessage("login.username.required", null, locale));
		}
		if(password==null || password.length()==0) {
			System.out.println("需要輸入密碼");
			errors.put("password", messageSource.getMessage("login.password.required", null, locale));
		}

		if(errors!=null && !errors.isEmpty()) {
			System.out.println("有錯誤");
			return "私服器回應：有錯誤";
		}
		
//呼叫model
		//自己有改寫memberDAO/Service/Hibernate了
		System.out.println("再來要執行MembersBean bean = membersService.login(username, password);");
		MembersBean bean = membersService.login(username, password);//這行有問題
		System.out.println("MembersBean bean有錯誤，應該不會印出這行");

//根據model執行結果，導向view
		if(bean==null) {
			System.out.println("可能我改寫memberDAO/Service/Hibernate其中有問題才拿不到bean");
			errors.put("password", messageSource.getMessage("login.failed", null, locale));
			return "私服器回應：可能我改寫memberDAO/Service/Hibernate其中有問題才拿不到bean";
		} else {
			System.out.println("有成功驗證比對帳號密碼！！");
			session.setAttribute("user", bean);
			return "私服器回應：有成功驗證比對帳號密碼！！";
		}
		
	}
}
