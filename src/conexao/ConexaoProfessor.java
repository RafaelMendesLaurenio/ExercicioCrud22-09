package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import objetos.ProfessorOBJ;

public class ConexaoProfessor {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<ProfessorOBJ> lista = new ArrayList<>();
	
	public void salvarProfessor(ProfessorOBJ objProfessorOBJ) {
		
		
		String sql = "INSERT INTO professor (nome, senha) VALUES (?,?)";
		
		conn = new Conexao().conectaDB();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objProfessorOBJ.getNome());
			pstm.setInt(2, objProfessorOBJ.getSenha());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ConexaoProfessor cadastrar" + erro);
		}
	}
	public ArrayList<ProfessorOBJ> PesquisarProfessor(){
		String sql = "select * from Professor";
		conn = new Conexao().conectaDB();
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ProfessorOBJ objProfessorOBJ= new ProfessorOBJ();
				objProfessorOBJ.setId(rs.getInt("id"));
				objProfessorOBJ.setNome(rs.getString("nome"));
				objProfessorOBJ.setSenha(rs.getInt("senha"));
				
				lista.add(objProfessorOBJ);
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "ConexaoProfessor Pesquisar" + erro);
		}
		return lista;
	}	
}
