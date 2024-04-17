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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AppMain05 {

	private JFrame frame;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textName;
	private JButton btnNewButton;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	
	String name;
	String phone;
	String email;
	private JScrollPane scrollPane;

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
		
		lblNewLabel = new JLabel("이름");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 41, 124, 48);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(44, 118, 124, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("이메일");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(44, 186, 124, 48);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(180, 41, 305, 48);
		frame.getContentPane().add(textName);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(180, 118, 305, 48);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(180, 186, 305, 48);
		frame.getContentPane().add(textEmail);
		
		btnNewButton = new JButton("입력");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleInputButtonClick();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(526, 186, 145, 48);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 268, 629, 130);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
	}
	
	private void handleInputButtonClick() {
		// JTextField(이름, 전화번호, 이메일)에 입력된 문자열을 읽음.
		name = "이름: " + textName.getText() + "\n";
		phone = "번호: " + textPhone.getText() + "\n";
		email = "이메일: " + textEmail.getText() + "\n";
		
		String result = name + phone + email;
		
		// 이름, 전화번호, 이메일을 JTextArea에 씀.
		textArea.append(result); // 내용 추가시 기존에 작성된 내용 끝에 추가.
//		textArea.setText(result); // 기존에 작성된 내용은 삭제.
		
		// 모든 JTextField의 입력된 내용을 지움.
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
		
	}
}
