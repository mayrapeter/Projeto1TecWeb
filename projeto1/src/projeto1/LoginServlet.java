package projeto1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		String usuario = request.getParameter("usuariologin");
		String senha = request.getParameter("senhalogin");
		
		
		try {
			Pessoas usuarioLogin = dao.login(usuario, senha);
			
			
			PrintWriter out = response.getWriter();
			
			if (usuarioLogin == null) {
				PrintWriter out2 = response.getWriter();
				out2.print("<body>");
				out2.print("<h3>Você não está cadastrado ou senha incorreta!</h3>");
				out2.print("<a href='/NotasLegais/'>Voltar</a>");
				out2.print("</body>");
			} else {
			int id = 0;
			id = dao.getID(usuario, senha);
			request.setAttribute("id", id);
			request.setAttribute("nome", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/notas.jsp");  
	        rd.forward(request, response);
			
			}
		} catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.print("<body>");
			out.print("<h3>Você não está cadastrado!</h3>");
			out.print("<a href='/NotasLegais'>Voltar</a>");
			out.print("</body>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
