package Test;

public class Block {
	
	int[] kindArr = new int[2];
	
	public Block() {
		this.kind = kind;
		int rand = (int) (Math.random()*7+1);
		this.kind = rand;
	}
	
	
	public void init() {
		
//		kindArr[0] = (int) (Math.random()*7+1);
//		kindArr[1] = kindArr[0];
		
//		int rand = (int) (Math.random()*7+1);
//		this.kind = rand;
		this.status = 1; 
		this.x = 5;      
		this.y = 1;
	}
	

	public int kind = 7;
	public int status = 1;
	public int x = 5;
	public int y = 1;
	
	
	
	
	@Override
	public String toString() {
		return "Block [kind=" + kind + ", status=" + status + ", x=" + x + ", y=" + y + "]";
	}
}
