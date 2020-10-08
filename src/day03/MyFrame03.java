package day03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame03 extends JFrame {

	private JPanel contentPane;
	private JTextField firstNum;
	private JTextField secondNum;
	private JTextField resultNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame03 frame = new MyFrame03();
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
	public MyFrame03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstNum = new JTextField();
		firstNum.setBounds(20, 100, 79, 21);
		contentPane.add(firstNum);
		firstNum.setColumns(10);
		
		secondNum = new JTextField();
		secondNum.setBounds(133, 100, 79, 21);
		contentPane.add(secondNum);
		secondNum.setColumns(10);
		
		resultNum = new JTextField();
		resultNum.setBounds(302, 100, 79, 21);
		contentPane.add(resultNum);
		resultNum.setColumns(10);
		
		JLabel label = new JLabel("+");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label.setBounds(111, 100, 22, 18);
		contentPane.add(label);
		
		JButton equaleBtn = new JButton("=");
		equaleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int first = 0;
				try {
					first = Integer.parseInt(firstNum.getText());
				}catch(NumberFormatException ex1) {
				
				}
				
				int second = 0;
				try {
					second = Integer.parseInt(secondNum.getText());
				}catch(NumberFormatException ex2) {
					
				}
				
				int result = first + second;
				resultNum.setText(result + "");
				
				
			}
		});
		equaleBtn.setBounds(236, 98, 43, 23);
		contentPane.add(equaleBtn);
	}
}
