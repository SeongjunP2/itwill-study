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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
	
	public interface UpdateNotify {
		public void notifyContactUpdated();
	}

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
	private Component parentComponent; // 부모 컴포넌트를 저장하기 위해서
	private UpdateNotify app;
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(int index, Component parentComponent, UpdateNotify app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "목록에서 업데이트할 연락처를 선택해주세요!",
							"경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(index, parentComponent, app);
					frame.setVisible(true);
//					System.out.println(index); // 인덱스값 확인 테스트
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUpdateFrame(int index, Component parentComponent, UpdateNotify app) {
		this.index = index;
		this.parentComponent = parentComponent;
		this.app = app;
		initialize();
	}
	
	public void initialize() {
		String name = dao.read(index).getName();
		String phone = dao.read(index).getPhone();
		String email = dao.read(index).getEmail();
		
		setTitle("연락처 업데이트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 0;
		int y = 0;
		if (parentComponent != null) {
			x = parentComponent.getX();
			y = parentComponent.getY();
		}
		setBounds(x, y, 450, 300);
		
		if (parentComponent == null) {
			setLocationRelativeTo(null);
		}
		
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
		
		btnSave = new JButton("업데이트");
		btnSave.addActionListener(new ActionListener() { // 람다 사용 x
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnSave.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnSave);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener((e) -> dispose()); // 람다 사용 o
		btnCancel.setFont(new Font("굴림", Font.BOLD, 15));
		buttonPanel.add(btnCancel);
	}
	
	private void updateContact() {
		// 1. JTextField에서 업데이트할 이름, 전화번호, 이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// 2. Contact 타입 객체 생성
		Contact contact = new Contact(0, name, phone, email);
		
		// 3. DAO를 사용해서 파일에 저장
		int result = dao.update(index, contact);
		if (result == 1) { // 연락처 업데이트 성공
			// TODO ContactMain에게 연락처 업데이트가 성공됐음을 알려줌.
			app.notifyContactUpdated();
			dispose(); // 현재 창 닫기
		} else { // 연락처 업데이트 실패
			// TODO 사용자에게 업데이트 실패 메시지 보여주기
			JOptionPane.showMessageDialog(null, "업데이트 실패!", "경고", JOptionPane.WARNING_MESSAGE);
		}
	}

}
