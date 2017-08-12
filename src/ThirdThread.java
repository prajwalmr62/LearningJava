class NewThread2 extends Thread{
	NewThread2(){
		super("demo Thread");
		System.out.println(this);
		start();
	}
	public void run(){
		try{
			for(int i =0; i<5;i++){
				System.out.print("child"+i);
				Thread.sleep(500);
			}
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("child exited");
	}
}
public class ThirdThread {
	public static void main(String args[]){
		new NewThread2();
		try{
			for(int i=0;i<5;i++){
				System.out.println("main"+i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("Main Exit");
	}
}
