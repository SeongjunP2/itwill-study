package com.itwill.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itwill.ver05.controller.ContactDao;
import com.itwill.ver05.controller.ContactDaoImpl;
import com.itwill.ver05.model.Contact;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ContactSearchFrame extends JFrame {

	private static final String[] COLUMN_NAMES = { "이름", "전화번호", "이메일" };
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Component parentComponent;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	
	private ContactDao dao = ContactDaoImpl.getInstance();
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JPanel headerPanel;

	/**
	 * Launch the application.
	 */
	public static void showContactSearchFrame(Component parentComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactSearchFrame frame = new ContactSearchFrame(parentComponent);
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
	public ContactSearchFrame(Component parentComponent) {
		this.parentComponent = parentComponent;
		initialize();
	}
	
	public void initialize() {
		setTitle("연락처 검색");
		
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerPanel = new JPanel();
		contentPane.add(headerPanel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		headerPanel.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener((e) -> searchByKeyword());
		btnSearch.setFont(new Font("굴림", Font.BOLD, 20));
		headerPanel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		// 테이블 컬럼 이름의 폰트 설정
		table.getTableHeader().setFont(new Font("굴림", Font.PLAIN, 15));
		// 테이블 데이터 행의 폰트 설정
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		// 테이블 행 높이(세로) 설정
		table.setRowHeight(35);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	
	private void searchByKeyword() {
		// 검색어 읽음
		String keyword = textField.getText();
		
		// DAO를 사용해서 검색어로 검색 결과를 가져옴.
		List<Contact> list = dao.search(keyword);
		
		// 검색 결과를 테이블에 씀.
		model = new DefaultTableModel(null, COLUMN_NAMES); // 데이터 지움
		
		// 비워진 테이블모델에 검색결과만 행으로 추가
		for (Contact c : list) {
			Object[] row = { c.getName(), c.getPhone(), c.getEmail() };
			model.addRow(row);
		}
		
		table.setModel(model); // 테이블에 테이블모델을 다시 세팅
		
	}

}
