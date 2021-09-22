package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
	public Connection conectaDB() {
    Connection conn = null;
    try {
    	String url = "jdbc:mysql://localhost:3306/cadastrodeprofessor?user=root&password=";
    	conn = DriverManager.getConnection(url);
		
	} catch (SQLException erro) {
		JOptionPane.showMessageDialog(null, "conexao_conexao" + erro.getMessage());
	}
    return conn;
	}
}
