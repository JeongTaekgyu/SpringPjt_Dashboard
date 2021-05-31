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
	
	// UserService�� ���Թ���
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	// UserBean�� ModelAttribute�� ���Թ޴´�
	// ModelAttribute��  https://developer-joe.tistory.com/197 ���� ����
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		// 1. UserBean Ŭ������ ��ü joinUserBean�� �ڵ����� �����Ѵ�.(BeanŬ������ ����, getter�� setter�� ��� ��Ģ�� �°� ������� �־����)
		// 2. ������ Object�� HTTP�� �Ѿ�� ������ �ڵ����� ���ε��Ѵ�.
		// 3. @@ModelAttribute ������̼ǿ� ���� ��ü(���⼭�� UserBean)�� �ڵ����� Model�� �߰� �ǰ� ���� UserBean��ü�� .jsp ��ܱ��� ���޵ȴ�.
		// 4. join.jsp ����  modelAttribute="joinUserBean" �̷������� ��밡��
		return "user/join";
	}
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		if(result.hasErrors()) {	// ��ȿ�� �˻翡 ������ �ִٸ� joinȭ������
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
	
	// ���δ��� ����������
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
	
}
