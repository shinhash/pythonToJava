package day11;

public class Block {
	
	
	public Block() {
		this.kind = kind;
		int rand = (int) (Math.random()*7+1);
		this.kind = rand;
//		this.kind = 2;
	}
	
	
	public void init() {
		int rand = (int) (Math.random()*7+1);
		this.kind = rand;
//		this.kind = 2;
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
