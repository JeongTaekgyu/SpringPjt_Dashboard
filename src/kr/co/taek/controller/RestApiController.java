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
	
	/*	������ �������� �������� ������ �Ǵµ�
		�ش� ��������
		html�̸� Controller ���
		data����ϸ� RestController�� ����ϴ°� �ξ� ���ϴ�
	 */
	// RestAPI ���� ��� Ŭ���̾�Ʈ�� ������ �����͸� ���� �� �Ķ���ͺ��ٴ� pathValue�� �� ���� ������(�ּҿ��� �����͸� ���δ�)
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean chk = userService.checkuserIdExist(user_id);
		
		return chk + "";
	}
}












