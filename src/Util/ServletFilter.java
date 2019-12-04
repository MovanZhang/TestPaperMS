package Util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/ServletFilter")
public class ServletFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		//System.out.println("���ǵ�һ����������------���Խ��Servlet��������");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response); // ������һ��filter�ִ࣬�������е�filter��ȥִ��ҳ�档
	}

	public void init(FilterConfig config) {
	}

	public void destroy() {
	}
}
