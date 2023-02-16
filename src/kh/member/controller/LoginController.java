package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		
		// 2.
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("로그인 성공"); 
			request.getSession().setAttribute("lgnss", result);
		} else {
			System.out.println("로그인 실패");
		}
		
		// 3. 페이지 이동 및 데이터 전달 (셋 중 하나는 꼭 필요)
		// 3-1 response.sendRedirect(request.getContextPath + "url"); 페이지 이동만
		// 3-2 request.setAttribute("name", "value");
		// 3-2 request.getRequestDispatcher("xxx.jsp").forward(request, response); 값과 함께 이동
		// 3-3 out.println(값); out.flush(); out.close(); ajax, 페이지 이동 없이 값만 전달
		response.sendRedirect(request.getContextPath() + "/");
	}

}
