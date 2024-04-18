package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ContactUpdateFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanel;
	private JButton btnSave;
	private JPanel buttonPanel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JButton btnCancel;
	
	private int index;
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(int index) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "목록에서 업데이트할 연락처를 선택해주세요!",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(index);
					frame.setVisible(true);
					System.out.println(index); // 인덱스값 확인 테스트
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUpdateFrame(int index) {
		this.index = index;
		initialize();
	}
	
	public void initialize() {
		String name = dao.read(index).getName();
		String phone = dao.read(index).getPhone();
		String email = dao.read(index).getEmail();
		
		setTitle("연락처 업데이트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD, 19));
		lblName.setBounds(12, 10, 72, 43);
		contentPanel.add(lblName);
		
		textName = new JTextField(name);
		textName.setFont(new Font("굴림", Font.PLAIN, 15));
		textName.setBounds(96, 10, 316, 43);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 19));
		lblPhone.setBounds(12, 72, 83, 43);
		contentPanel.add(lblPhone);
		
		textPhone = new JTextField(phone);
		textPhone.setFont(new Font("굴림", Font.PLAIN, 15));
		textPhone.setColumns(10);
		textPhone.setBounds(96, 72, 316, 43);
		contentPanel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 19));
		lblEmail.setBounds(12, 134, 72, 43);
		contentPanel.add(lblEmail);
		
		textEmail = new JTextField(email);
		textEmail.setFont(new Font("굴림", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(96, 134, 316, 43);
		contentPanel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnSave = new JButton("저장");
		btnSave.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnCancel);
	}
	
	private void updateContact() {
//		// 1. JTextField에서 저장할 이름, 전화번호, 이메일을 읽음.
//		textName.getText().indexOf(index);
//		
//		String name = textName.getText();
//		String phone = textPhone.getText();
//		String email = textEmail.getText();
//		
//		// 2. Contact 타입 객체 생성
//		Contact contact = new Contact(index, name, phone, email);
//		
//		// 3. DAO를 사용해서 파일에 저장
//		int result = dao.create(contact);
//		if (result == 1) { // 연락처 저장 성공
//			// TODO ContactMain에게 연락처 저장이 성공됐음을 알려줌.
//			app.notifyContactCreated();
//			dispose(); // 현재 창 닫기
//		} else { // 연락처 저장 실패
//			// TODO 사용자에게 저장 실패 메시지 보여주기
//		}
	}

}
