package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class AppMain04custom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiple;
	private JButton btnDivide;
	private JTextArea textArea;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04custom window = new AppMain04custom();
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
	public AppMain04custom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 10, 320, 78);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 98, 320, 78);
		frame.getContentPane().add(textField_1);
		
		lblNewLabel = new JLabel("num1");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 138, 78);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("num2");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 98, 138, 78);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		plus();
            	} catch (NumberFormatException ex) {
            		textArea.setText("정수 입력 필요!");
            	}
            }
        });
		btnPlus.setFont(new Font("굴림", Font.BOLD, 20));
		btnPlus.setBounds(12, 188, 97, 78);
		frame.getContentPane().add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	try {
            		minus();
            	} catch (NumberFormatException ex) {
            		textArea.setText("정수 입력 필요!");
            	}
            }
		});
		btnMinus.setFont(new Font("굴림", Font.BOLD, 20));
		btnMinus.setBounds(137, 188, 97, 78);
		frame.getContentPane().add(btnMinus);
		
		btnMultiple = new JButton("X");
		btnMultiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	try {
            		multiple();
            	} catch (NumberFormatException ex) {
            		textArea.setText("정수 입력 필요!");
            	}
			}
		});
		btnMultiple.setFont(new Font("굴림", Font.BOLD, 20));
		btnMultiple.setBounds(261, 188, 97, 78);
		frame.getContentPane().add(btnMultiple);
		
		btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	try {
            		divide();
            	} catch (NumberFormatException ex) {
            		textArea.setText("정수 입력 필요!");
            	}
			}
		});
		btnDivide.setFont(new Font("굴림", Font.BOLD, 20));
		btnDivide.setBounds(370, 188, 97, 78);
		frame.getContentPane().add(btnDivide);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea.setBounds(12, 289, 470, 217);
		frame.getContentPane().add(textArea);
	}
	
	private void plus() {
		double num1 = Double.parseDouble(textField.getText());
		double num2 = Double.parseDouble(textField_1.getText());
		double value = num1 + num2;
		String result = Double.toString(value);
		textArea.setText(result);
		
	}
	
	private void minus() {
		double num1 = Double.parseDouble(textField.getText());
		double num2 = Double.parseDouble(textField_1.getText());
		double value = num1 - num2;
		String result = Double.toString(value);
		textArea.setText(result);
		
	}
	
	private void multiple() {
		double num1 = Double.parseDouble(textField.getText());
		double num2 = Double.parseDouble(textField_1.getText());
		double value = num1 * num2;
		String result = Double.toString(value);
		textArea.setText(result);
		
	}
	
	private void divide() {
		double num1 = Double.parseDouble(textField.getText());
		double num2 = Double.parseDouble(textField_1.getText());
		double value = num1 / num2;
//		double value2 = num1 % num2;
		String result = Double.toString(value);
//		String result2 = Double.toString(value2);
		textArea.setText(result);
//		textArea.setText(result2);
		
	}
}
