package day09;


public class Block {
	
	
	public Block(int kind) {
		this.kind = kind;
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
