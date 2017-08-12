class NewThread implements Runnable {
	Thread t;
	NewThread(){
		t= new Thread(this, "Demo Thread");
		System.out.println("Child Thread"+t);
		t.start();
		}
	public void run(){
		try {
			for(int i =0; i<10;i++){
				System.out.println("child "+i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e){
			System.out.println("ChildThread Inturruped");
		}
		System.out.println("Exiting ChildThread");
	}
	}
public class SecondThread {
	public static void main(String args[]){
		new NewThread();
		try{
			for(int i=5;i>0;i--){
				System.out.println("Main "+i);
				Thread.sleep(1000);
			}
	} catch( InterruptedException e){
		System.out.println("Main inturrupted"+e);
	}
		System.out.println("Main Exited");
	}
}
