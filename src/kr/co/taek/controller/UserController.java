package kr.co.taek.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.taek.beans.UserBean;
import kr.co.taek.service.UserService;
import kr.co.taek.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// UserService를 주입받음
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	// UserBean을 ModelAttribute로 주입받는다
	// ModelAttribute는  https://developer-joe.tistory.com/197 여기 참고
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		// 1. UserBean 클래스의 객체 joinUserBean을 자동으로 생성한다.(Bean클래스만 가능, getter와 setter가 명명 규칙에 맞게 만들어져 있어야함)
		// 2. 생성된 Object에 HTTP로 넘어온 값들을 자동으로 바인딩한다.
		// 3. @@ModelAttribute 어노테이션에 붙은 객체(여기서는 UserBean)가 자동으로 Model에 추가 되고 따라서 UserBean객체가 .jsp 뷰단까지 전달된다.
		// 4. join.jsp 에서  modelAttribute="joinUserBean" 이런식으로 사용가능
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		if(result.hasErrors()) {	// 유효성 검사에 문제가 있다면 join화면으로
			return "user/join";
		}
		System.out.println("~~~");
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	// 바인더와 벨리데이터
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
	
}
