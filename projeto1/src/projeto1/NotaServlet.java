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
 * Servlet implementation class NotasServlet
 */
@WebServlet("/NotaServlet")
public class NotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotaServlet() {
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
		DAO dao = new DAO();


		String id_string = request.getParameter("id");
		Integer id = Integer.valueOf(id_string);
		String nome = request.getParameter("nome");
		String nota = request.getParameter("nota");
		
		
		try {
			dao.postNote(id, nome, nota);
			request.setAttribute("id", id);
			request.setAttribute("nome", nome);
			RequestDispatcher rd = request.getRequestDispatcher("/notas.jsp");  
	        rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<body>");
			out.print("<h3>Não adicionada com sucesso.</h3>");
			out.print("</body>");
		}

		
	}
}


