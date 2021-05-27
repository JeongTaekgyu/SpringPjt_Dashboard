package kr.co.taek.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.taek.beans.BoardInfoBean;
import kr.co.taek.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	// 자바 프로젝트에서는 인터셉터에서는 Bean을 주입받을 수 없기 때문에 생성자를 통해서 객체 주소값을 받았는데
	// XML 프로젝트에서는 Bean 주입이 가능하다
	@Autowired
	private TopMenuService topMenuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		// 데이터베이스에서 가져온 내용을 request영역에 저장을 하고 jsp로 이동하는 구조
		
		return true;
	}
}
