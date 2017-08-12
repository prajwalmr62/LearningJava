package concPro;

import java.util.concurrent.*;

public class Excecute {
	public static void main(String args[]){
		ExecutorService es = Executors.newFixedThreadPool(3);
		SyncedAsset s = new SyncedAsset();
		for(int i =0; i<5; i++){
			es.execute(new PoolThread(i, s));
		}
		es.shutdown();
		
	}
}

class PoolThread implements Runnable{
	int i;
	Thread t;
	SyncedAsset s;
	public PoolThread(int i, SyncedAsset s){
		this.i =i;
		this.s = s;
		t = new Thread(this, "Thread: "+i);
	}
	public void run(){
		s.func(t.getName());
		}
}

class SyncedAsset{
	synchronized public void func(String name){
		for(int j =0; j<5; j++){
			System.out.println(name+" & "+j);
		}
	}
}