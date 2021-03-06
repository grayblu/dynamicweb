

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit04.domain.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/00_joinForm.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member member = map(request);
		System.out.println(member);
		
//		회원 가입을 위한 유효성 검사 실패로 가정
		request.setAttribute("member", member);	// EL에서 ${member, userId}
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/00_joinForm.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private Member map(HttpServletRequest request) {
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPassword(request.getParameter("passowrd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTel(request.getParameter("tel"));
		member.setGender(request.getParameter("gender"));
		
		return member;
	}

}
