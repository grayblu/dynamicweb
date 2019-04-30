

import java.io.IOException;

import unit04.domain.Member;
import unit04.domain.PageInfo;
import unit04.service.MemberService;
import unit04.service.MemberServiceImpl;
import unit04.util.ParseUtil;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/list")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
        service = MemberServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page = ParseUtil.parseInt(request.getParameter("page"));

		PageInfo<Member> pi = service.getPage(page);
		request.setAttribute("pi", pi);

		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
		
		
/*		int page = 1;
		String strPage = request.getParameter("page");
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		
		
		
		List<Member> memberList = new ArrayList<>();
		memberList.add(new Member("hong", "1234", "홍1", "hong1@abc.com","00" ,"M"));
		memberList.add(new Member("hong", "1234", "홍2", "hong2@abc.com","00", "M"));
		memberList.add(new Member("hong", "1234", "홍3", "hong3@abc.com","00", "M"));
		memberList.add(new Member("hong", "1234", "홍4", "hong4@abc.com","00", "M"));
		memberList.add(new Member("hong", "1234", "홍5", "hong5@abc.com","00", "M"));
*/		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
