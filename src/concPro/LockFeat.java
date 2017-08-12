package concPro;

import java.util.concurrent.locks.*;

public class LockFeat {
	public static void main(String args[]){
		ReentrantLock RL = new ReentrantLock();
		new LockThread(RL, "A1");
		new LockThread(RL,"B2");
	}
}

class LockThread implements Runnable{
	ReentrantLock rl;
	String s;
	public LockThread(ReentrantLock rl, String s){
		this.rl = rl;
		this.s = s;
		new Thread(this).start();
	}
	public void run(){
		try{
			System.out.println("Locked "+s);
			rl.lock();
			Shared.a++;
			Thread.sleep(1000);
			System.out.println("Unlocking "+s+" "+Shared.a);
		} catch(InterruptedException e){
			System.out.println(e);
		} finally{
			rl.unlock();
		}
	}
}