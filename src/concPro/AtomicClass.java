package concPro;

/*  You don't have to import the java.util.automic if you don't declare
 * the atomic variable within the executing class. But it should be
 * imported to the shared class.  
 */

public class AtomicClass {
	public static void main(String args[]){
		for(int i =0; i<2; i++){
			new AtomicThread(i);
		}
	}
}

class AtomicThread implements Runnable{
	Thread t;
	AtomicThread(int i){
		t = new Thread(this,"Thread: "+i);
		t.start();
		}
	public void run(){
		for(int i =0; i<2; i++){
		System.out.println("Thread: "+t+" "+Shared.ai.getAndSet(i));
		}
	}
}