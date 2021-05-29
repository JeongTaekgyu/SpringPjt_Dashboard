package kr.co.taek.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.taek.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		// UserBean ��ü�� �ִ� ������ ��ȿ�� �˻縦 �Ұű� ������
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");	// NotEquals�� error_message.properties������ ���Ǵ� �� ����.
			errors.rejectValue("user_pw2", "NotEquals");
		}
	}

}