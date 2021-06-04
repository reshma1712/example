

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class candidatePage
 */
@WebServlet("/candidatePage")
public class candidatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public candidatePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roll = userClass.user;
		String v = request.getParameter("s");
		if(roll.equals("")){
			request.setAttribute("error","please login");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		else{
			logingDao o = new logingDao();
			String c = o.candidateCheck(roll);
			//response.getWriter().println(roll);
			if(!c.equals("yes")){
				request.setAttribute("error","you have already registered for"+c);
				RequestDispatcher rd = request.getRequestDispatcher("/candidte.jsp");
				rd.forward(request, response);
			}
			else{
				logingDao oo = new logingDao();
				String x = oo.addcandidate(roll,v);
				if(!c.equals(roll)){
					request.setAttribute("error",x);
					RequestDispatcher rd = request.getRequestDispatcher("/candidte.jsp");
					rd.forward(request, response);
				}
				
			}
		}
		
	}

}
