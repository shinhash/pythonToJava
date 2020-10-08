package day11;

public class ThreadTest03 {
	public static void main(String[] args) {
		
		
		printNumber();
		printChar();
		
	}
	
	public static void printNumber() {
		new Thread() {
			@Override
			public void run() {
				super.run();
				
				
				for(int i=0; i<100000; i++) {
					System.out.println(i + " ");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) { }
				}
			}
		}.start();
	}
	
	
	
	public static void printChar() {
		
		new Thread() {
			@Override
			public void run() {
				super.run();
				
				for(int i=0; i<100000; i++) {
					System.out.println((char)i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) { }
				}
			}
		}.start();
	} 
}
