package kr.co.taek.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.taek.beans.BoardInfoBean;
import kr.co.taek.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	// �ڹ� ������Ʈ������ ���ͼ��Ϳ����� Bean�� ���Թ��� �� ���� ������ �����ڸ� ���ؼ� ��ü �ּҰ��� �޾Ҵµ�
	// XML ������Ʈ������ Bean ������ �����ϴ�
	@Autowired
	private TopMenuService topMenuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		// �����ͺ��̽����� ������ ������ request������ ������ �ϰ� jsp�� �̵��ϴ� ����
		
		return true;
	}
}
