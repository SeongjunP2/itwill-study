package com.itwill.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

	private JFrame frame;
	private JButton btnMsgDlg;
	private JButton btnConfirmDlg;
	private JButton btnInputDlg;
	private JButton btnCustomDlg;
	private JButton btnCustomFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnMsgDlg = new JButton("Message Dialog");
		btnMsgDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메시지 다이얼로그 보여주기
//				JOptionPane.showMessageDialog(frame, "안녕하세요."); // 컴포넌트 값에 null 값을 주면 모니터 한가운데 안녕하세요 화면 출력
				JOptionPane.showMessageDialog(
						frame,						// 부모 컴포넌트
						"안녕하세요, Swing!",		// 다이얼로그 메시지
						"메시지",					// 다이얼로그 타이틀(제목)
						JOptionPane.PLAIN_MESSAGE); // 메시지 타입 -> 메시지 아이콘(JOptionPane에서 기본으로 제공되는 아이콘)
			}
		});
		btnMsgDlg.setFont(new Font("굴림", Font.BOLD, 15));
		btnMsgDlg.setBounds(12, 10, 410, 90);
		frame.getContentPane().add(btnMsgDlg);
		
		btnConfirmDlg = new JButton("Confirm Dialog");
		btnConfirmDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Confirm(확인) 다이얼로그 보여주기
//				int result = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?");
				int result = JOptionPane.showConfirmDialog(
						frame,							// 부모 컴포넌트
						"정말 삭제할까요?",				// 메시지
						"삭제 확인",					// 타이틀
						JOptionPane.YES_NO_OPTION,		// 옵션 타입(버튼 종류, 개수)
						JOptionPane.QUESTION_MESSAGE);	// 메시지 타입
				
				btnConfirmDlg.setText("confirm=" + result);
			}
		});
		btnConfirmDlg.setFont(new Font("굴림", Font.BOLD, 15));
		btnConfirmDlg.setBounds(12, 110, 410, 90);
		frame.getContentPane().add(btnConfirmDlg);
		
		btnInputDlg = new JButton("Input Dialog");
		btnInputDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] selections = {"인*", "얼굴장부", "X", "너튜브"};
				Object select = JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트
						"SNS를 선택해주세요.", // 메시지
						"SNS 선택", // 타이틀
						JOptionPane.WARNING_MESSAGE, // 메시지 타입 - 메시지 기본 아이콘
						null, // 아이콘
						selections, // 선택할 값들(배열로 생성필요)
						selections[1] // 초기 선택값
						);
				
				String result = JOptionPane.showInputDialog(
						// 입력 다이얼로그 보여주기
						frame,
						"값을 입력해주세요.",
						"확인",
				JOptionPane.QUESTION_MESSAGE);
				
				JOptionPane.showInputDialog(
						frame, // 부모 컴포넌트
						"입력 값을 다시 확인해주세요!(입력값 받아오기)", // 메시지
						"재확인!", // 타이틀
						JOptionPane.WARNING_MESSAGE, // 메시지 타입 - 메시지 기본 아이콘
						null, // 아이콘
						null, // 선택할 값들(배열로 생성필요)
						select + " " + result // 초기 선택값
						);
			}
		});
		btnInputDlg.setFont(new Font("굴림", Font.BOLD, 15));
		btnInputDlg.setBounds(12, 210, 410, 90);
		frame.getContentPane().add(btnInputDlg);
		
		btnCustomDlg = new JButton("Custom Dialog");
		btnCustomDlg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 내가 만든 다이얼로그 보여주기
				MyDialog.showMyDialog(frame);
				
			}
		});
		btnCustomDlg.setFont(new Font("굴림", Font.BOLD, 15));
		btnCustomDlg.setBounds(12, 313, 410, 90);
		frame.getContentPane().add(btnCustomDlg);
		
		btnCustomFrame = new JButton("Custom Frame");
		btnCustomFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFrame.showMyFrame(frame);
			}
		});
		btnCustomFrame.setFont(new Font("굴림", Font.BOLD, 15));
		btnCustomFrame.setBounds(12, 413, 410, 90);
		frame.getContentPane().add(btnCustomFrame);
	}

}
