

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Map<String, Controller> map;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
        map = new HashMap<>();
     // 요청 PATH 문자열과 Controller 인스턴스를 수동으로 맵에 등록
        map.put("/index.do", new IndexController());
    }
    
    
    private String getUri(HttpServletRequest request) {
//    	URI path 중 context path를 제외한 나머지 경로를 추출
    	String Uri = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String path = Uri.substring(ctxPath.length());
    	return path;
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String uri = getUri(req);
    	
    	Controller controller = map.get(uri);
    	if(controller != null) {
//    	컨트롤러가 있는 경우
    		String target;
    		if(req.getMethod().equalsIgnoreCase("GET")) {
//    		요청 메서드 분석
    			target = controller.doGet(req, resp);	
    		}else {
    			target = controller.doPost(req, resp);
    		}
    		move(req, resp, target);
//    		페이지 이동
    	}else {
    		resp.sendError(404, uri + " 경로 없음");
    	}
    }
    
    protected void move(HttpServletRequest request, HttpServletResponse response, String target)
    		throws ServletException, IOException{
    	
    	if (target.startsWith("redirect:")) { // redirect인 경우
    		target = target.substring("redirect:".length());
    		if (target.startsWith("/")) { // 절대 경로인경우
    			target = request.getContextPath() + target;
    		}
    		
    		response.sendRedirect(target);
    		
    	} else { // forwarding인 경우
    		target += ".jsp";
    		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
    		dispatcher.forward(request, response);
    	}
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
