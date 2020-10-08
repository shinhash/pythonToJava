package day09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tetris01 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl;
	
	private int gameWidth = 265;
	private int gameHeight = 540;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tetris01 frame = new Tetris01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	public Tetris01() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				
				// ╩С
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					int x = lbl.getX();
					int y = lbl.getY();
					lbl.setBounds(x, y-25, 25, 25);
				}
				
				// го
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					int x = lbl.getX();
					int y = lbl.getY();
					lbl.setBounds(x, y+25, 25, 25);
				}
				
				// аб
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					int x = lbl.getX();
					int y = lbl.getY();
					lbl.setBounds(x-25, y, 25, 25);
				}
				
				// ©Л
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					int x = lbl.getX();
					int y = lbl.getY();
					lbl.setBounds(x+25, y, 25, 25);
				}
				
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, gameWidth, gameHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl = new JLabel("");
		lbl.setForeground(Color.BLACK);
		lbl.setBackground(Color.RED);
		lbl.setBounds(0, 0, 25, 25);
		lbl.setOpaque(true);
		contentPane.add(lbl);
	}
}
