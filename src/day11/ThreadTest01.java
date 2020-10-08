package day11;

public class ThreadTest01 {
	public static void main(String[] args) {
		
		
		new Thread() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println("hello");					
				}
			}
		}.start();
		
	}
}
