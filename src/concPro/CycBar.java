package concPro;

import java.util.concurrent.*;

public class CycBar {
	public  static void main(String args[]){
		CyclicBarrier cbar = new CyclicBarrier(1, new BarrierAction());
		new mythread(cbar, "one");
		new mythread(cbar,"two");
		new mythread(cbar,"three");
	}
}

class BarrierAction implements Runnable{
	public void run(){
		System.out.println("Cyclic Execution happened.");
	}
}

class mythread extends Thread{
	CyclicBarrier cb;
	String name;
	public mythread(CyclicBarrier cb, String name){
		this.cb = cb;
		this.name = name;
		new Thread(this, this.name).start();
	}
	public void run(){
		System.out.println(this.name+" Completed.");
		try{
			cb.await();
		}catch (Exception e){
			System.out.println(e);
		}
	}
}