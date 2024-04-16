package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AppMain05 {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textName;
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 41, 124, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 118, 124, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("이메일");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(44, 186, 124, 48);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textName = new JTextField();
		name();
		textName.setColumns(10);
		textName.setBounds(180, 41, 305, 48);
		frame.getContentPane().add(textName);
		
		textPhone = new JTextField();
		phone();
		textPhone.setColumns(10);
		textPhone.setBounds(180, 118, 305, 48);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		email();
		textEmail.setColumns(10);
		textEmail.setBounds(180, 186, 305, 48);
		frame.getContentPane().add(textEmail);
		
		btnNewButton = new JButton("입력");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(526, 186, 145, 48);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea.setText("이름:\r\n" + "전화번호:\r\n" + "이메일:");
		textArea.setBounds(44, 268, 627, 130);
		frame.getContentPane().add(textArea);
	}
	
	private void name() {
		String name = textName.getText();
		textArea.setText(name);
	}
	
	private void phone() {
		String phone = textPhone.getText();
		textArea.setText(phone);
	}
	
	private void email() {
		String email = textPhone.getText();
		textArea.setText(email);
	}

}
