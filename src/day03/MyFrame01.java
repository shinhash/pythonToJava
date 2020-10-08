package day03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame01 frame = new MyFrame01();
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
	public MyFrame01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Hello");
		lbl.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		lbl.setBounds(170, 90, 79, 51);
		contentPane.add(lbl);
		
		JButton clickbtn = new JButton("click");
		clickbtn.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		clickbtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				lbl.setText("good morning");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbl.setText("hello");
			}
		});
		
		clickbtn.setBounds(157, 151, 97, 23);
		contentPane.add(clickbtn);
	}
	
	
	
	
	
	
	
	
	class Human{
		
	}
	
	
	
	
	
	
	
}





