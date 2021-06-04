

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
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
		String v = request.getParameter("v");
		if(v.equals("voteForDeptPresedent")){
			logingDao o = new logingDao();
			String s = o.deptCheck(roll);
			if(s.equals(roll)){
				s = o.VoteDept(roll);
				if(!roll.equals(s)){
					s = request.getParameter("id");
					String x =o.deptInsert(roll,s);
					request.setAttribute("error",x);
					RequestDispatcher rd = request.getRequestDispatcher("/dept.jsp");
					rd.forward(request, response);
					System.out.println("fi");				}
			else{
				request.setAttribute("error","you already voted");
				RequestDispatcher rd = request.getRequestDispatcher("/dept.jsp");
				rd.forward(request, response);
			}
			}
			else{
				request.setAttribute("error","only IT dept students can vote");
				RequestDispatcher rd = request.getRequestDispatcher("/dept.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(v.equals("voteForIT-4Presedent")){
			logingDao o = new logingDao();
			String s = o.deptCheck(roll);
			String ss =o.yearCheck(roll);
			if(s.equals(roll) && ss.equals(roll)){
				s = o.VoteYear(roll);
				if(!roll.equals(s)){
					s = request.getParameter("id");
					String x =o.yearInsert(roll,s);
					request.setAttribute("error",x);
					RequestDispatcher rd = request.getRequestDispatcher("/year.jsp");
					rd.forward(request, response);
					System.out.println("fi");
				}
			else{
				request.setAttribute("error","you already voted");
				RequestDispatcher rd = request.getRequestDispatcher("/year.jsp");
				rd.forward(request, response);
			}
			}
			else{
				request.setAttribute("error","only IT dept 4th year students can vote");
				RequestDispatcher rd = request.getRequestDispatcher("/year.jsp");
				rd.forward(request, response);
			}
			
		}
		else{
			logingDao o = new logingDao();
			String s = o.VoteCollege(roll);
			if(!roll.equals(s)){
				s = request.getParameter("id");
				String x = o.collegeInsert(roll,s);
				request.setAttribute("error",x);
				RequestDispatcher rd = request.getRequestDispatcher("/college.jsp");
				rd.forward(request, response);
				System.out.println("fi");
			}
		else{
			request.setAttribute("error","you already voted");
			RequestDispatcher rd = request.getRequestDispatcher("/college.jsp");
			rd.forward(request, response);
		}
		}
		
				
		
	}

}
