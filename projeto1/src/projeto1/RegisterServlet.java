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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String confirmarsenha = request.getParameter("confirmarsenha");
		
		if (senha.contentEquals(confirmarsenha)) {
			try {
				System.out.println("Entrou");
				dao.register(usuario, senha);
				int id = 0;
				id = dao.getID(usuario, senha);
				request.setAttribute("id", id);
				request.setAttribute("nome", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("/notas.jsp");  
		        rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
							}	
		} else {
			PrintWriter out = response.getWriter();
			out.print("<body>");
			out.print("<h3>Senhas não batem.</h3>");
			out.print("<a href='/NotasLegais/'>Voltar</a>");
			out.print("</body>");
		}
		
	}

}
