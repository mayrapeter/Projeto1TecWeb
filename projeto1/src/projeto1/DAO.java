package projeto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto1", "root", "gioiaGGR1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void register(String usuario, String senha) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO pessoa (nome, senha) VALUES (?,?)");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ps.execute();
		ps.close();
	}
	
	public void postNote(int id, String nome, String nota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO notas (id, nome, nota) VALUES (?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setString(3, nota);
		ps.execute();
		ps.close();
	}
	
	public void apagarNota (int id, String nome, String nota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM notas WHERE id=? AND nome=? AND nota=?;");
		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setString(3, nota);
		ps.execute();
		ps.close();
	}
	
	public void alterarNota (int id, String nome, String nota, String novaNota) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE notas SET " + " nota=? WHERE id=? AND nome=? AND nota=?;");
		ps.setString(1, novaNota);
		ps.setInt(2, id);
		ps.setString(3, nome);
		ps.setString(4, nota);
		ps.execute();
		ps.close();
	}
	public List<Notas> getLista() throws SQLException {
		List<Notas> notas = new ArrayList<Notas>();
		 PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM notas");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Notas nota = new Notas();
			nota.setIdAutor(rs.getInt("id"));
			nota.setAutor(rs.getString("nome"));
			nota.setNota(rs.getString("nota"));
			notas.add(nota);
		}
		rs.close();
		stmt.close();
		return notas;
		}

	public int getID(String usuario, String senha) throws SQLException {
		int id = 0;
		PreparedStatement ps = connection.prepareStatement("SELECT id FROM pessoa WHERE nome = ? AND senha = ?");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		   id = rs.getInt("id");
		System.out.println(id);
		return id;
		
		
	}

	public Pessoas login(String usuario, String senha) throws SQLException {

		PreparedStatement ps = connection.prepareStatement("SELECT * FROM pessoa WHERE nome = ? AND senha = ?");
		ps.setString(1, usuario);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Pessoas pessoa = new Pessoas();
			pessoa.setUsuario(rs.getString("nome"));
			pessoa.setSenha(rs.getString("senha"));
			return pessoa;
		}
		return null;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
