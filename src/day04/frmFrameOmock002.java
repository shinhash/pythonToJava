package day04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmFrameOmock002 extends JFrame {

	private JLabel[][] arr2d = new JLabel[10][10];
	private JLabel lbl = new JLabel();
	private int[][] int2d = new int[10][10];
	
	private boolean chk;
	private boolean flaging = true;
	
	private ImageIcon imgIconEmptyLine = new ImageIcon(frmFrameOmock002.class.getResource("/day04/0.jpg"));
	private ImageIcon imgIconWhite = new ImageIcon(frmFrameOmock002.class.getResource("/day04/1.jpg"));
	private ImageIcon imgIconBlack = new ImageIcon(frmFrameOmock002.class.getResource("/day04/2.jpg"));
	
//	private int playableCount = 1;
	private boolean playableTurn = true;
	
	private JPanel contentPane;


	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFrameOmock002 frame = new frmFrameOmock002();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	
	/**
	 * location setting
	 */
	public void showInt2d() {
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				
				System.out.print(int2d[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	/**
	 * draw image
	 */
	public void myrender() {
		for(int col=0; col<int2d.length; col++) {
			for(int row=0; row<int2d.length; row++) {
				
				if(int2d[col][row] == 0) {
					arr2d[col][row].setIcon(imgIconEmptyLine);					
				}
				if(int2d[col][row] == 1) {
					arr2d[col][row].setIcon(imgIconWhite);
				}
				if(int2d[col][row] == 2) {
					arr2d[col][row].setIcon(imgIconBlack);
				}
				
			}
		}
	}
	
	
	
	
	/**
	 * is Allreay Check
	 * @param newCol
	 * @param newRow
	 * @return
	 */
	public boolean isAllreayCheck(int newCol, int newRow) {
		
		boolean chk = false;

		if(int2d[newCol][newRow] != 0) {
			chk = true;
		}else{
			chk = false;
		}
		return chk;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Game Result
	 * @param newCol
	 * @param newRow
	 * @param playableTurn
	 * @return
	 */
	public String gameResult(int newCol, int newRow, boolean playableTurn) {
		
		
		String gameResult = "";
		int player = 1;
		
		if(playableTurn == true) {
			player = 1;
		}else {
			player = 2;			
		}
		
		// 세로 라인
		int upcount = getUp(newCol, newRow, player);
		int downcount = getDown(newCol, newRow, player);
		int collinecount = (upcount + downcount) + 1;
		
		// 가로 라인
		int leftcount = getLeft(newCol, newRow, player);
		int rightcount = getRight(newCol, newRow, player);
		int rowlinecount = (leftcount + rightcount) + 1;
		
		// 좌측 대각선 라인
		int leftupcount = getLeftUp(newCol, newRow, player);
		int rightdowncount = getRightDown(newCol, newRow, player);
		int leftdiagonalcount = (leftupcount + rightdowncount) + 1;
		
		// 우측 대각선 라인
		int rightupcount = getRightUp(newCol, newRow, player);
		int leftdowncount = getLeftDown(newCol, newRow, player);
		int rightdiagonalcount = (rightupcount + leftdowncount) + 1;
		
		
//		System.out.println("upcount : " + upcount);
//		System.out.println("downcount : " + downcount);
//		
//		System.out.println("leftcount : " + leftcount);
//		System.out.println("rightcount : " + rightcount);
//		
//		System.out.println("leftupcount : " + leftupcount);
//		System.out.println("rightdowncount : " + rightdowncount);
//
//		System.out.println("rightupcount : " + rightupcount);
//		System.out.println("leftdowncount : " + leftdowncount);

		
		
		
//		System.out.println("collinecount : " + collinecount);
//		System.out.println("rowlinecount : " + rowlinecount);
//		System.out.println("rightdiagonalcount : " + rightdiagonalcount);
//		System.out.println("leftdiagonalcount : " + leftdiagonalcount);
		
		
		// lineInfo Array
		int[] cntSp = new int[4];
		cntSp[0] = collinecount;
		cntSp[1] = rowlinecount;
		cntSp[2] = leftdiagonalcount;
		cntSp[3] = rightdiagonalcount;
		
		for(int cnt : cntSp) {
			
			if(cnt == 5) {
				
				String playStone = "검은돌";
				if(player == 1) {
					playStone = "흰돌";
				}
				JOptionPane.showMessageDialog(null, playStone + " 이 이겼습니다.");
				gameResult = "end";
//				System.exit(0);
			}
		}
		
		
		
		
		
//		int rowChk = rowLineCheck(newCol, newRow, player);
//		int colChk = colLineCheck(newCol, newRow, player);
//		int leftDiagonalChk = leftDiagonalLineCheck(newCol, newRow, player);
//		int rightDiagonalChk = rightDiagonalLineCheck(newCol, newRow, player);
//		
//		
//		
//		if(rowChk == 5 || colChk == 5 || leftDiagonalChk == 5 || rightDiagonalChk == 5) {
//			if(player == 1) {
//				System.out.println("흰색 돌 승리!!");
//			}
//			else if(player == 2) {
//				System.out.println("검은색 돌 승리!!");				
//			}
//		}
		
		return gameResult;
	}
	
	
	//=================================================semTest================================================//
	/**
	 * getUpCount
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getUp(int ii, int jj, int player) {
		
		int cnt = 0;
		try {
			while(true) {
				
				ii--;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else{
					break;
				}
				
			}
			
		}catch(Exception e) {
			return cnt;
		}
		
		return cnt;
	}
	
	
	
	
	
	/**
	 * getDownCount
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getDown(int ii, int jj, int player) {
		int cnt = 0;
		
		try {
			while(true) {
				ii++;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		
		return cnt;
	}
	
	
	
	
	
	
	/**
	 * getLeftCount
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getLeft(int ii, int jj, int player) {
		int cnt = 0;
		
		try {
			while(true) {
				jj--;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		return cnt;
	}
	
	
	
	
	
	
	/**
	 * getRightCount
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getRight(int ii, int jj, int player) {
		int cnt = 0;
		
		try {
			while(true) {
				jj++;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		return cnt;
	}
	
	
	
	
	
	
	
	/**
	 * getLeftUp
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getLeftUp(int ii, int jj, int player) {
		int cnt = 0;
		
		try {
			while(true) {
				ii--;
				jj--;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		
		return cnt;
	}
	
	
	
	
	
	/**
	 * getRightDown
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getRightDown(int ii, int jj, int player) {
		int cnt = 0;
		try {
			while(true) {
				ii++;
				jj++;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		return cnt;
	}

	
	
	
	
	
	
	/**
	 * getRightUp
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getRightUp(int ii, int jj, int player) {
		int cnt = 0;
		try {
			while(true) {
				ii--;
				jj++;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		return cnt;
	}
	
	
	
	
	/**
	 * getLeftDown
	 * @param ii
	 * @param jj
	 * @param player
	 * @return
	 */
	public int getLeftDown(int ii, int jj, int player) {
		int cnt = 0;
		try {
			while(true) {
				ii++;
				jj--;
				if(int2d[ii][jj] == player) {
					cnt++;
				}else {
					break;
				}
			}
			
		}catch(Exception e) {
			return cnt;
		}
		return cnt;
	}
	
	//=====================================================================================================//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//====================================================myTest=============================================//
	/**
	 * row Line Checker
	 * @param newCol
	 * @param newRow
	 * @param player
	 * @return
	 */
	public int rowLineCheck(int newCol, int newRow, int player) {
		
		int rowLChk = 0;
		while(true) {
			for(int i=0; i<int2d.length; i++) {
				if(int2d[newCol][i] == 0) {
					continue;
				}else {
					
					if(int2d[newCol][i] == player) {
						rowLChk++;
						if(rowLChk == 5) {
							break;
						}
					}else {
						rowLChk = 0;
					}
				}
			}
			break;
		}
		System.out.println("row line check : " + player + " = " + rowLChk);
		return rowLChk;
	}
	
	
	
	
	/**
	 * col Line Checker
	 * @param newCol
	 * @param newRow
	 * @param player
	 * @return
	 */
	public int colLineCheck(int newCol, int newRow, int player) {
		
		
		int colLChk = 0;
		while(true) {
			for(int i=0; i<int2d.length; i++) {
				if(int2d[i][newRow] == 0) {
					continue;
				}else {
					
					if(int2d[i][newRow] == player) {
						colLChk++;
						if(colLChk == 5) {
							break;
						}
					}else {
						colLChk = 0;
					}
				}
			}
			break;
		}
		System.out.println("col line check : " + player + " = " + colLChk);
		return colLChk;
	}
	
	
	
	
	
	/**
	 * left Diagonal Line Checker
	 * @param newCol
	 * @param newRow
	 * @param player
	 * @return
	 */
	public int leftDiagonalLineCheck(int newCol, int newRow, int player) {
		
		
		int colNum = newCol;
		int rowNum = newRow;
		
		while(true) {
			if(colNum <= 0 || rowNum <= 0) {
				break;
			}
			colNum--;
			rowNum--;
		}
		System.out.println(colNum+","+rowNum);
		
		int leftDiLChk = 0;
		if(rowNum == 0) {
			for(int i=0; i<(int2d.length)-colNum; i++) {
				
				if(int2d[colNum+i][rowNum+i] == 0) {
					continue;
				}else {
					
					if(int2d[colNum+i][rowNum+i] == player) {
						leftDiLChk++;
						if(leftDiLChk == 5) {
							break;
						}
					}else {
						leftDiLChk = 0;
					}
				}
			}
		}else {
			for(int i=0; i<(int2d.length)-rowNum; i++) {
				
				if(int2d[colNum+i][rowNum+i] == 0) {
					continue;
				}else {
					
					if(int2d[colNum+i][rowNum+i] == player) {
						leftDiLChk++;
						if(leftDiLChk == 5) {
							break;
						}
					}else {
						leftDiLChk = 0;
					}
				}
			}
		}
		System.out.println("left Diagonal line check : " + player + " = " + leftDiLChk);
		return leftDiLChk;
	}
	
	
	
	
	
	
	
	/**
	 * right Diagonal Line Check
	 * @param newCol
	 * @param newRow
	 * @param player
	 * @return
	 */
	public int rightDiagonalLineCheck(int newCol, int newRow, int player) {
		
		int colNum = newCol;
		int rowNum = newRow;
		
		while(true) {
			if(colNum <= 0 || rowNum >= (int2d.length-1)) {
				break;
			}
			colNum--;
			rowNum++;
		}
		System.out.println(colNum+","+rowNum);
		
		
		int rightDiLChk = 0;
		if(rowNum == (int2d.length-1)) {
			
			for(int i=(int2d.length-1)-colNum; i>0; i--) {
				
				if(int2d[colNum+i][rowNum-i] == 0) {
					continue;
				}else {
					
					if(int2d[colNum+i][rowNum-i] == player) {
						rightDiLChk++;
						if(rightDiLChk == 5) {
							break;
						}
					}else {
						rightDiLChk = 0;
					}
				}
			}
		}else {
			for(int i=rowNum; i>=0; i--) {
				
				if(int2d[colNum+i][rowNum-i] == 0) {
					continue;
				}else {
					
					if(int2d[colNum+i][rowNum-i] == player) {
						rightDiLChk++;
						if(rightDiLChk == 5) {
							break;
						}
					}else {
						rightDiLChk = 0;
					}
				}
			}
			
		}
		System.out.println("right Diagonal line check : " + player + " = " + rightDiLChk);
		return rightDiLChk;
	}
	//=====================================================================================================//
	

	
	
	
	/**
	 * Create the frame.
	 */
	public frmFrameOmock002() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 790);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// 초기 셋팅
		for(int col=0; col<10; col++) {
			
			for(int row=0; row<10; row++) {
				
				lbl = new JLabel("");
				
				lbl = new JLabel();
				lbl.setIcon(imgIconEmptyLine);
				lbl.setBounds(75*row, 75*col, 75, 75);
				lbl.setText(col+","+row);
				
				// 위치좌표 값
//				int incol = col;
//				int inrow = row;
				
				lbl.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						myClick(e);
					}
				});
				contentPane.add(lbl);
				arr2d[col][row] = lbl;
			}
		}
		showInt2d();
	}
	
	
	
	
	
	
	
	/**
	 * click action method
	 * main logic
	 * @param e
	 */
	public void myClick(MouseEvent e) {
		
		if(!flaging) {
			return;
		}
		
		JLabel temp = (JLabel)e.getComponent();
		System.out.println();
		System.out.println();
		System.out.println();
		
		String[] locText = temp.getText().split(",");
		int newCol = Integer.parseInt(locText[0]);
		int newRow = Integer.parseInt(locText[1]);
		
		System.out.println(newCol+","+newRow);
		
		chk = isAllreayCheck(newCol, newRow);
		if(chk == false) {
			if(playableTurn) { // 백
				
				int2d[newCol][newRow] = 2;
				playableTurn = false;
				String gameResult = gameResult(newCol, newRow, playableTurn);
				if(gameResult == "end") {
					flaging = false;
				}
			}else { // 흑
				
				int2d[newCol][newRow] = 1;
				playableTurn = true;
				String gameResult = gameResult(newCol, newRow, playableTurn);
				if(gameResult == "end") {
					flaging = false;
				}
			}
		}
		showInt2d();
		myrender();
		
	}
	
	
	
	
	
	
	
	
	
}
