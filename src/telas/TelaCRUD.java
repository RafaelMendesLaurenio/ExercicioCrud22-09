package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexao.ConexaoProfessor;
import objetos.ProfessorOBJ;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaCRUD extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JTable tabelaProfessor;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUD frame = new TelaCRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCRUD() {
		setBackground(new Color(51, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAcessoAoSistema = new JLabel("Acesso ao sistema de biblioteca");
		lblAcessoAoSistema.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblAcessoAoSistema.setForeground(new Color(255, 255, 255));
		lblAcessoAoSistema.setBounds(116, 13, 294, 28);
		contentPane.add(lblAcessoAoSistema);
		
		JLabel lblNome = new JLabel("Usuario:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNome.setBounds(68, 102, 81, 28);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblSenha.setBounds(68, 143, 81, 28);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(204, 204, 255));
		txtUsuario.setBounds(161, 107, 181, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBackground(new Color(204, 204, 255));
		txtSenha.setColumns(10);
		txtSenha.setBounds(161, 148, 181, 22);
		contentPane.add(txtSenha);
		
		tabelaProfessor = new JTable();
		tabelaProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		tabelaProfessor.setBounds(386, 74, 209, 118);
		contentPane.add(tabelaProfessor);
		
		JButton btnConfirmar = new JButton("carrregar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int setar = tabelaProfessor.getSelectedRow();
				
				txtId.setText(tabelaProfessor.getModel().getValueAt(setar,0).toString());
				txtUsuario.setText(tabelaProfessor.getModel().getValueAt(setar,1).toString());
				txtSenha.setText(tabelaProfessor.getModel().getValueAt(setar,2).toString());
				
			}
		});
		btnConfirmar.setForeground(new Color(0, 51, 255));
		btnConfirmar.setBackground(new Color(204, 204, 255));
		btnConfirmar.setBounds(128, 218, 97, 25);
		contentPane.add(btnConfirmar);
		
		JButton btnLimpar = new JButton("limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtUsuario.setText("");
				txtSenha.setText("");
			
			}
		});
		btnLimpar.setForeground(new Color(0, 51, 255));
		btnLimpar.setBackground(new Color(204, 204, 255));
		btnLimpar.setBounds(264, 218, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnListar = new JButton("listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 ConexaoProfessor objPr = new ConexaoProfessor();
					
					DefaultTableModel model = (DefaultTableModel) tabelaProfessor.getModel();
					model.setNumRows(0);
					
					ArrayList<ProfessorOBJ> lista = objPr.PesquisarProfessor();
					
					for (int num = 0; num < lista.size(); num++) {
						model.addRow(new Object[] {
								lista.get(num).getId(),
								lista.get(num).getNome(),
								lista.get(num).getSenha()
						});
					}
					
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "ListarValores TelaCrud" + erro);
				}
				
			}
		});
		btnListar.setForeground(new Color(0, 51, 255));
		btnListar.setBackground(new Color(204, 204, 255));
		btnListar.setBounds(445, 218, 97, 25);
		contentPane.add(btnListar);
		
		JLabel lblAtividadeDeSoftware = new JLabel("Atividade de software");
		lblAtividadeDeSoftware.setForeground(Color.WHITE);
		lblAtividadeDeSoftware.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblAtividadeDeSoftware.setBounds(68, 305, 225, 38);
		contentPane.add(lblAtividadeDeSoftware);
		
		JLabel lblRafaelMendes = new JLabel("Rafael Mendes");
		lblRafaelMendes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRafaelMendes.setForeground(Color.WHITE);
		lblRafaelMendes.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblRafaelMendes.setBounds(291, 305, 225, 38);
		contentPane.add(lblRafaelMendes);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblId.setBounds(68, 67, 81, 28);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBackground(new Color(204, 204, 255));
		txtId.setBounds(161, 72, 28, 22);
		contentPane.add(txtId);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial TInicial = new TelaInicial();
				TInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(new Color(0, 51, 255));
		btnVoltar.setBackground(new Color(204, 204, 255));
		btnVoltar.setBounds(519, 314, 97, 25);
		contentPane.add(btnVoltar);
	}
}
