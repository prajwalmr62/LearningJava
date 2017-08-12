class MThread implements Runnable{
	String name;
	Thread t;
	MThread(String tname){
		name = tname;
		t = new Thread(this,name);
		System.out.println(t);
		t.start();
	}
	public void run(){
		try{
			for(int i=0;i<5;i++){
				System.out.println(name+' '+i);
				Thread.sleep(100);
			}
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println(name+" Exiting");
	}
}
public class MultiThread {
	public static void main(String args[]){
		for(int i=0;i<5;i++){
			new MThread("new"+i);
		}
		try{
			System.out.println("main Thread");
			Thread.sleep(1000);
		} catch(InterruptedException e){
			System.out.println(e);
		}System.out.println("Main Exited");
	}

}
