package day04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmFrameOmock001 extends JFrame {

	private JLabel[][] arr2d = new JLabel[10][10];
	private JLabel lbl = new JLabel();
	
	
	private ImageIcon imgIconEmptyLine = new ImageIcon(frmFrameOmock001.class.getResource("/day04/0.jpg"));
	private ImageIcon imgIconWhite = new ImageIcon(frmFrameOmock001.class.getResource("/day04/1.jpg"));
	private ImageIcon imgIconBlack = new ImageIcon(frmFrameOmock001.class.getResource("/day04/2.jpg"));
	
	private int playableCount = 0;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFrameOmock001 frame = new frmFrameOmock001();
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
	public frmFrameOmock001() {
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
				
				arr2d[col][row] = new JLabel();
				arr2d[col][row].setIcon(imgIconEmptyLine);
				arr2d[col][row].setBounds(75*row, 75*col, 75, 75);
				contentPane.add(arr2d[col][row]);
			}
		}
		
		
		
		// 클릭 액션 => 게임 시작
		for(int col=0; col<10; col++) {
			
			for(int row=0; row<10; row++) {
				
				// 위치좌표 값
				int incol = col;
				int inrow = row;
				
				arr2d[col][row].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						int x = e.getX();
						int y = e.getY();
						
						JLabel temp = (JLabel)e.getComponent();
						
						System.out.println(incol + "," + inrow);
						if(playableCount == 0) {
							arr2d[incol][inrow].setIcon(imgIconBlack);
							contentPane.add(lbl);
							playableCount = 1;
						}else {
							arr2d[incol][inrow].setIcon(imgIconWhite);
							contentPane.add(lbl);
							playableCount = 0;
						}
					}
				});
				
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
