package kh.home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/", "/main", "/home", "/index"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aaa = request.getParameter("aaa");
		// Paging 처리
		// 1 총 글 개수 알아오기
		int cnt = service.getCountBoard();
		System.out.println(cnt);
		// 2 한 페이지에 나타낼 글 개수 정하기
		int cntPerPage = 3;
		// 3 페이지 수 정하기
		int pageBlock = 4;
		// 4 현재페이지
		int currentPage = 1; // default 1, 페이지 클릭시 변경
		try {
			currentPage = Integer.parseInt(aaa);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 5 row num 범위 정하기
		int startRnum = 0;
		int endRnum = 0;
		
		startRnum = (currentPage - 1) * cntPerPage + 1;
		endRnum = (startRnum + cntPerPage - 1 > cnt) ? cnt : startRnum + cntPerPage - 1;
		request.setAttribute("boardList", service.getBoardList(startRnum, endRnum));
//		request.setAttribute("boardList", service.getBoardList());
		
		// 6 페이지 범위 정하기
		int startPageNum = 0;
		int endPageNum = 0;
		startPageNum = (currentPage % pageBlock == 0)
				 ? ((currentPage / pageBlock - 1) * pageBlock) + 1
				 : ((currentPage / pageBlock) * pageBlock + 1);
		int pageCnt = cnt / cntPerPage + (cnt % cntPerPage == 0 ? 0 : 1);
		endPageNum = (startPageNum + pageBlock - 1 > pageCnt) ? pageCnt : startPageNum + pageBlock - 1 ;
		
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
