package kr.co.taek.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.taek.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		// UserBean 객체에 있는 값들을 유효성 검사를 할거기 때문에
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean)target;
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");	// NotEquals는 error_message.properties에서도 사용되는 것 같다.
			errors.rejectValue("user_pw2", "NotEquals");
		}
	}

}
