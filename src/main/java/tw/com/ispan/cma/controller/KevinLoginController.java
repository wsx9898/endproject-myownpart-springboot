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
	public String login(Locale locale, Model model, String username, String password, HttpSession session) {
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
		MembersBean bean = membersService.login(username, password);

//根據model執行結果，導向view
		if(bean==null) {
			System.out.println("可能我改寫memberDAO/Service/Hibernate其中有問題才拿不到bean");
			errors.put("password", messageSource.getMessage("login.failed", null, locale));
			return "私服器回應：查不到此帳號或密碼有錯誤";
		} else {
			System.out.println("有成功驗證比對帳號密碼！！");
			System.out.println("session.getId() = "+session.getId());
			session.removeAttribute("user");
			session.setAttribute("user", bean);
			return "私服器回應：有成功驗證比對帳號密碼！！，session.setAttribute";
		}
	}

	//不確定登入的session在這個方法是否能拿到
	@GetMapping(path = {"/dashboardGetMemberId"})
	public String dashboardGetMemberId(Model model, HttpSession session){
		System.out.println("session.getId() = "+session.getId());
		MembersBean bean = (MembersBean)session.getAttribute("user");
		System.out.println("bean.getMemberId() = " + bean.getMemberId());
		return bean.getMemberAccouunt();
	}

	@GetMapping(path = {"/getMemberAllInfo"})
	public String getMemberAllInfo(HttpSession session){
		MembersBean bean = (MembersBean)session.getAttribute("user");

		//先去看老師的影片學怎麼自動轉成JSON
		return bean.toString();
	}

}
