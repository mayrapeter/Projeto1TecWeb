package projeto1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarServlet
 */
@WebServlet("/AlterarServlet")
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id_autor_string = request.getParameter("id_autor");
		Integer id_autor = Integer.valueOf(id_autor_string);
		String id_string = request.getParameter("id");
		Integer id = Integer.valueOf(id_string);
		String nome_autor = request.getParameter("nome_autor");
		String nome = request.getParameter("nome");
		String nota = request.getParameter("nota");
		
		request.setAttribute("id_autor", id_autor);
		request.setAttribute("id", id);
		request.setAttribute("nome", nome);
		request.setAttribute("nome_autor", nome_autor);
		request.setAttribute("nota", nota);
		RequestDispatcher rd = request.getRequestDispatcher("/alterar.jsp");  
        rd.forward(request, response);
	}

}
