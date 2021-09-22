package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.ConexaoProfessor;
import objetos.ProfessorOBJ;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProfessor = new JLabel("Cadastro de Professor");
		lblCadastroDeProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeProfessor.setForeground(Color.WHITE);
		lblCadastroDeProfessor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblCadastroDeProfessor.setBounds(57, 13, 294, 28);
		contentPane.add(lblCadastroDeProfessor);
		
		JLabel label = new JLabel("Usuario:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Black", Font.BOLD, 16));
		label.setBounds(57, 75, 81, 28);
		contentPane.add(label);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblSenha.setBounds(57, 116, 81, 28);
		contentPane.add(lblSenha);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(204, 204, 255));
		txtNome.setBounds(150, 80, 181, 22);
		contentPane.add(txtNome);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(204, 204, 255));
		txtSenha.setBounds(150, 121, 181, 22);
		contentPane.add(txtSenha);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome,s;
				nome = txtNome.getText();
				s = txtSenha.getText();
				
				int senha = Integer.parseInt(s);
				
				ProfessorOBJ PrOBJ = new ProfessorOBJ();
				PrOBJ.setNome(nome);
				PrOBJ.setSenha(senha);
				
				ConexaoProfessor ConPr = new ConexaoProfessor();
				ConPr.salvarProfessor(PrOBJ);
			}
		});
		btnCadastrar.setForeground(new Color(0, 51, 255));
		btnCadastrar.setBackground(new Color(204, 204, 255));
		btnCadastrar.setBounds(182, 175, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicial TInicial = new TelaInicial();
				TInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(new Color(0, 51, 255));
		btnVoltar.setBackground(new Color(204, 204, 255));
		btnVoltar.setBounds(323, 215, 97, 25);
		contentPane.add(btnVoltar);
	}

}
