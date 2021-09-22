package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem vindo");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setForeground(Color.WHITE);
		lblBemVindo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblBemVindo.setBounds(68, 13, 294, 28);
		contentPane.add(lblBemVindo);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro TC = new TelaCadastro();
				TC.setVisible(true);
				dispose();
			}
		});
		btnCadastrar.setForeground(new Color(0, 51, 255));
		btnCadastrar.setBackground(new Color(204, 204, 255));
		btnCadastrar.setBounds(99, 105, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnAcessar = new JButton("acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCRUD TCRUD = new TelaCRUD();
				TCRUD.setVisible(true);
				dispose();
			}
		});
		btnAcessar.setForeground(new Color(0, 51, 255));
		btnAcessar.setBackground(new Color(204, 204, 255));
		btnAcessar.setBounds(231, 105, 97, 25);
		contentPane.add(btnAcessar);
		
		JLabel label = new JLabel("Atividade de software");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label.setBounds(103, 202, 225, 38);
		contentPane.add(label);
	}

}
