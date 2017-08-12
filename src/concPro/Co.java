package concPro;

import java.util.concurrent.*;

public class Co {
	public static void main(String args[]){
		CountDownLatch cd = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		ImplSync l = new ImplSync();
		new myTh(cd,"1",l);
		new myTh(cd2,"2",l);
		try{
			cd.await();
			cd2.await();
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("Done!");
		System.exit(0);
	}
}
class myTh implements Runnable{
	CountDownLatch cd;
	Thread t;
	String name;
	ImplSync l;
	myTh(CountDownLatch cd,String name, ImplSync l){
		this.cd = cd;
		this.name = name;
		this.l = l;
		Thread t = new Thread(this, "my Thread");
		t.start();
	}
	public void run(){
		l.Call(this.cd, this.name);
		}
	}

class ImplSync{
	synchronized void Call(CountDownLatch cd,String name){
		for(int i =0; i<=5; i++){
			System.out.println(i+" "+name);
			cd.countDown();
		}
	}
}
