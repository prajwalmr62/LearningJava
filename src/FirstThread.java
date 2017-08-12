
public class FirstThread {
	public static void main(String args[]){
		Thread t = Thread.currentThread();
		System.out.println("ThreadName ="+t);
		t.setName("MyThread");
		System.out.println("Now Thread is "+t);
		try{
			for(int i=0;i<10;i++){
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException e){
			System.out.println("Interrupted");
		}
	}

}
