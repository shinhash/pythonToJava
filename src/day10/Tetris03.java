package day10;

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

public class Tetris03 extends JFrame{

	public Block block = new Block();
	
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
					Tetris03 frame = new Tetris03();
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
				block2D[block.y+1][block.x] = block.kind;				
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
	 * @param flagCollision 
	 */
	public void myRender() {
	
		
//		contentPane.removeAll();
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				
				
				// classRoom action
				if(scrin2D[y][x] == 0) {
					lbl2D[y][x].setBackground(new Color(255, 255, 255));
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
					lbl2D[y][x].setBackground(new Color(102, 102, 204));
				}
				if(scrin2D[y][x] == 6) {
					lbl2D[y][x].setBackground(new Color(153, 153, 153));
				}
				if(scrin2D[y][x] == 7) {
					lbl2D[y][x].setBackground(new Color(255, 0, 255));
				}
				
				
				
				
				
				if(scrin2D[y][x] == 11) {
					lbl2D[y][x].setBackground(new Color(255-(30), 0, 0));
				}
				if(scrin2D[y][x] == 12) {
					lbl2D[y][x].setBackground(new Color(255-(30), 102-(30), 0));
				}
				if(scrin2D[y][x] == 13) {
					lbl2D[y][x].setBackground(new Color(255-(30), 204-(30), 0));
				}
				if(scrin2D[y][x] == 14) {
					lbl2D[y][x].setBackground(new Color(0, 153-(30), 0));
				}
				if(scrin2D[y][x] == 15) {
					lbl2D[y][x].setBackground(new Color(102-(30), 102-(30), 204-(30)));
				}
				if(scrin2D[y][x] == 16) {
					lbl2D[y][x].setBackground(new Color(153-(30), 153-(30), 153-(30)));
				}
				if(scrin2D[y][x] == 17) {
					lbl2D[y][x].setBackground(new Color(255-(30), 0, 255-(30)));
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
	public boolean isCollision() {
		
		boolean flag = false;
		
		for(int y=0; y<scrin2D.length; y++) {
			for(int x=0; x<scrin2D[y].length; x++) {
				
				int blockloc = block2D[y][x];
				int stackloc = stack2D[y][x];
				
				if(blockloc != 0 && stackloc != 0) {
					System.out.println("is crashed!!!!!!");
					flag = true;
					return flag;
				}
			}
		}
		return flag;
	}
	
	
	
	
	
	
	public void moveBlock2Stack() {
		
		
		for(int y=0; y<block2D.length; y++) {
			for(int x=0; x<block2D[y].length; x++) {
				if(block2D[y][x] > 0) {
					stack2D[y][x] = block2D[y][x]+10;

				}
			}
		}
	}
	
	
	
	 
	
	
	
	/**
	 * block2d view method
	 * @param flagCollision 
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
		
		int preStatus = block.status;
		int preX = block.x;
		int preY = block.y;
		
		boolean flagColBound = false;
		boolean flagDown = false;
		
		
		// ��
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			changeBlockStatus();
		}
		
		// ��
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			block.y++;
			flagDown = true;
		}
		
		// ��
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			block.x--;
		}
		
		// ��
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			block.x++;
		}
		
		
		try {
			setBlock2DWithBlock();
			moveStackBlock2Scrin();
		}catch(Exception ex) {
			flagColBound = true;
		}
		
		boolean flagCollision = isCollision();
		
		if(flagCollision == true || flagColBound == true) {
			
			block.status = preStatus;
			block.x = preX;
			block.y = preY;
			
			setBlock2DWithBlock();
			moveStackBlock2Scrin();
			if(flagDown == true) {
				moveBlock2Stack();
				block.init();
				setBlock2DWithBlock();
				moveStackBlock2Scrin();
			}
		}
		
		// view line
		myRender();
		print2d(scrin2D);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void realTimeShow() {
		
			
			int preStatus = block.status;
			int preX = block.x;
			int preY = block.y;
			block.y++;
			
			boolean flagColBound = false;
			boolean flagDown = false;
			
			
			try {
				setBlock2DWithBlock();
				moveStackBlock2Scrin();
			}catch(Exception ex) {
				flagColBound = true;
				flagDown = true;
			}
			
			boolean flagCollision = isCollision();
			
			if(flagCollision == true || flagColBound == true) {
				
				block.status = preStatus;
				block.x = preX;
				block.y = preY;
				
				flagDown = true;
				
				setBlock2DWithBlock();
				moveStackBlock2Scrin();
				if(flagDown == true) {
					moveBlock2Stack();
					block.init();
					setBlock2DWithBlock();
					moveStackBlock2Scrin();
				}
			}
			
			
			// view line
			myRender();
			print2d(scrin2D);
	}

	
	
	
	
	public Tetris03() {
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
		
		setBlock2DWithBlock();
		moveStackBlock2Scrin();
		myRender();
		print2d(scrin2D);
		

		
	}
	
	class downBlock extends Thread{
		
		
		@Override
		public void run() {
			super.run();
			
			try {
				while(true) {
					block.y++;
					setBlock2DWithBlock();
					moveStackBlock2Scrin();
					myRender();
					print2d(scrin2D);
					Thread.sleep(1000);
				}
			}catch(InterruptedException ex) {
				
			}
		}
	}



}