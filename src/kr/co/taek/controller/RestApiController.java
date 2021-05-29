package kr.co.taek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.taek.service.UserService;

@RestController
public class RestApiController {
	
	@Autowired
	private UserService userService;
	
	/*	서버는 응답결과를 브라우저로 보내게 되는데
		해당 응답결과가
		html이면 Controller 사용
		data라고하면 RestController를 사용하는게 훨씬 편하다
	 */
	// RestAPI 같은 경우 클라이언트가 서버로 데이터를 보낼 때 파라미터보다는 pathValue로 더 많이 보낸다(주소에다 데이터를 붙인다)
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean chk = userService.checkuserIdExist(user_id);
		
		return chk + "";
	}
}












