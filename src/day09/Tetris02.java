package day09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class Tetris02 extends JFrame {

	public Block block = new Block(6);
	
	private JPanel contentPane;
	private JLabel lbl;
	private BevelBorder border = new BevelBorder(BevelBorder.RAISED);
	
	private int gameWidth = 266;
	private int gameHeight = 540;
	private int blockWH = 24;
	
	
	private JLabel[][] lbl2D = new JLabel[20][10];

	public int[][] block2D = new int[20][10];
	public int[][] stack2D = new int[20][10];
	public int[][] scrin2D = new int[20][10];
	
	
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tetris02 frame = new Tetris02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * block setting method
	 */
	public void setBlock2DWithBlock() {
		
		// init commend
		for(int y=0; y<block2D.length; y++) {
			for(int x=0; x<block2D[y].length; x++) {
				block2D[y][x] = 0;
				scrin2D[y][x] = block2D[y][x] + stack2D[y][x];
			}
		}
		
		
		
		if(block.kind == 1) {
			block2D[block.y][block.x] = block.kind;
			block2D[block.y][block.x+1] = block.kind;
			block2D[block.y+1][block.x] = block.kind;
			block2D[block.y+1][block.x+1] = block.kind;		
		}
		
		
		
		
		if(block.kind == 2) {
			if(block.status == 1) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;
				block2D[block.y+2][block.x] = block.kind;		
			}
			if(block.status == 2) {
				block2D[block.y][block.x-2] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;		
			}
		}
		
		
		if(block.kind == 3) {
			if(block.status == 1) {
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;
				block2D[block.y+1][block.x+1] = block.kind;		
			}
			if(block.status == 2) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y+1][block.x-1] = block.kind;		
			}
		}
		
		
		if(block.kind == 4) {
			if(block.status == 1) {
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;
				block2D[block.y+1][block.x-1] = block.kind;
				block2D[block.y+1][block.x] = block.kind;		
			}
			if(block.status == 2) {
				block2D[block.y-1][block.x-1] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;		
			}
		}
		
		
		
		
		
		
		
		
		if(block.kind == 5) {
			if(block.status == 1) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;				
			}
			if(block.status == 2) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;
				block2D[block.y+1][block.x] = block.kind;				
			}
			if(block.status == 3) {
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;
				block2D[block.y-1][block.x] = block.kind;				
			}
			if(block.status == 4) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;				
			}
		}
		
		
		if(block.kind == 6) {
			if(block.status == 1) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;
				block2D[block.y+1][block.x+1] = block.kind;				
			}
			if(block.status == 2) {
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;
				block2D[block.y+1][block.x-1] = block.kind;				
			}
			if(block.status == 3) {
				block2D[block.y-1][block.x-1] = block.kind;
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;				
			}
			if(block.status == 4) {
				block2D[block.y-1][block.x+1] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;				
			}
		}
		
		
		if(block.kind == 7) {
			if(block.status == 1) {
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;
				block2D[block.y+1][block.x-1] = block.kind;				
			}
			if(block.status == 2) {
				block2D[block.y-1][block.x-1] = block.kind;
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;				
			}
			if(block.status == 3) {
				block2D[block.y-1][block.x+1] = block.kind;
				block2D[block.y-1][block.x] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y+1][block.x] = block.kind;				
			}
			if(block.status == 4) {
				block2D[block.y][block.x-1] = block.kind;
				block2D[block.y][block.x] = block.kind;
				block2D[block.y][block.x+1] = block.kind;
				block2D[block.y+1][block.x+1] = block.kind;				
			}
		}
		
		
	}
	
	
	public void blockStatusSetting() {
		
	}
	
	
	
	
	
	
	public void changeBlockStatus() {
		
		if(block.kind == 1) {
			
		}
		if(block.kind == 2 || block.kind == 3 || block.kind == 4) {
			
			if(block.status == 1) {
				block.status = 2;
			}else if(block.status == 2) {
				block.status = 1;				
			}
			
		}
		if(block.kind == 5 || block.kind == 6 || block.kind == 7) {
			
			if(block.status == 1) {
				block.status = 2;
			}else if(block.status == 2) {
				block.status = 3;				
			}else if(block.status == 3) {
				block.status = 4;				
			}else if(block.status == 4) {
				block.status = 1;				
			}
		}
	}
	
	
	
	
	
	
	
	/**
	 * block2D plus stack2D to scrin2D
	 */
	public void moveStackBlock2Scrin() {
		
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				scrin2D[y][x] = block2D[y][x] + stack2D[y][x];
			}
		}
	}
	
	
	
	
	/**
	 * panel remove and repaint method
	 */
	public void myRender() {
		
//		contentPane.removeAll();
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				
				
				// classRoom action
				if(scrin2D[y][x] == 0) {
					lbl2D[y][x].setBackground(new Color(51, 51, 51));
				}
				if(scrin2D[y][x] == 1) {
					lbl2D[y][x].setBackground(new Color(255, 0, 0));
				}
				if(scrin2D[y][x] == 2) {
					lbl2D[y][x].setBackground(new Color(255, 102, 0));
				}
				if(scrin2D[y][x] == 3) {
					lbl2D[y][x].setBackground(new Color(255, 204, 0));
				}
				if(scrin2D[y][x] == 4) {
					lbl2D[y][x].setBackground(new Color(0, 153, 0));
				}
				if(scrin2D[y][x] == 5) {
					lbl2D[y][x].setBackground(new Color(0, 0, 255));
				}
				if(scrin2D[y][x] == 6) {
					lbl2D[y][x].setBackground(new Color(153, 153, 153));
				}
				if(scrin2D[y][x] == 7) {
					lbl2D[y][x].setBackground(new Color(255, 0, 255));
				}
				if(scrin2D[y][x] == 11) {
					lbl2D[y][x].setBackground(new Color(255, 255, 255));
				}
				
				
				
				
				// my action
//				if(block2D[y][x] == block.kind) {
//					lbl = new JLabel();
//					lbl.setForeground(Color.BLACK);
//					lbl.setBackground(new Color(255, 0, 0));
//					lbl.setOpaque(true);
//					lbl.setBorder(border);
//					lbl.setBounds(x*25, y*25, blockWH, blockWH);
//					contentPane.add(lbl);
//					lbl2D[y][x] = lbl;
//				}
//				if(stack2D[y][x] != 0) {
//					lbl = new JLabel();
//					lbl.setForeground(Color.BLACK);
//					lbl.setBackground(Color.GRAY);
//					lbl.setOpaque(true);
//					lbl.setBorder(border);
//					lbl.setBounds(x*25, y*25, blockWH, blockWH);
//					contentPane.add(lbl);
//					lbl2D[y][x] = lbl;
//				}
			}
		}
//		contentPane.repaint();
	}
	
	
	
	
	
	
	/**
	 * crash check method
	 */
	public void crashCheck() {
		
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				
				int blockloc = block2D[y][x];
				int stackloc = stack2D[y][x];
				
				if(blockloc != 0 && stackloc != 0) {
					System.out.println("is crashed!!!!!!");
					return;
				}
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * block2d view method
	 */
	public void print2d(int[][] arr2D) {
		System.out.println();
		System.out.println("======================================");
		for(int y=0; y<arr2D.length; y++) {
			for(int x=0; x<arr2D[y].length; x++) {
				System.out.print(arr2D[y][x] + "  ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	/**
	 * stack2d view method
	 */
//	public void printStack2D() {
//		System.out.println();
//		System.out.println("======================================stack2d");
//		for(int y=0; y<block2D.length; y++) {
//			for(int x=0; x<block2D[y].length; x++) {
//				System.out.print(stack2D[y][x] + "  ");
//			}
//			System.out.println();
//		}
//	}
	
	
	
	
	/**
	 * presskey action method
	 * @param e
	 */
	public void myPress(KeyEvent e) {
		// ╩С
		if(e.getKeyCode() == KeyEvent.VK_UP) {
//			block.y--;
			changeBlockStatus();
		}
		
		// го
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			block.y++;
		}
		
		// аб
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			block.x--;
		}
		
		// ©Л
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			block.x++;
		}
		
		setBlock2DWithBlock();
		moveStackBlock2Scrin();
		print2d(scrin2D);
		crashCheck();
		myRender();
	}
	
	
	

	
	
	
	
	public Tetris02() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				myPress(e);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, gameWidth, gameHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				lbl = new JLabel();
				lbl.setForeground(Color.BLACK);
				lbl.setOpaque(true);
				lbl.setBorder(border);
				lbl.setBounds(x*25, y*25, blockWH, blockWH);
				contentPane.add(lbl);
				lbl2D[y][x] = lbl;
			}
		}
		
		
		
		stack2D[19][0] = 11;
		stack2D[19][1] = 11;
		stack2D[19][2] = 11;
		stack2D[19][3] = 11;
		
		
		setBlock2DWithBlock();
		moveStackBlock2Scrin();
		print2d(scrin2D);
//		crashCheck();
		myRender();
	}

}
