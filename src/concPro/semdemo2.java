package concPro;

import java.util.concurrent.*;

public class semdemo2 {
	public static void main(String args[]){
		q Q = new q();
		new consumer(Q);
		new Pro(Q);
	}
}

class q{ 
	int n=0;
	Semaphore semCon = new Semaphore(0);
	Semaphore semPro = new Semaphore(1);
	Semaphore semChe = new Semaphore(0);
 void get(){
		check();
	try{
		semCon.acquire();
		System.out.println("Got: "+n);
		} catch(InterruptedException e){
			System.out.println(e);
		}
	semPro.release();

 	}

 void put(int n){
	try{
		semPro.acquire();
		this.n = n;
		System.out.println("Put: "+this.n);
		} catch(InterruptedException e){
			System.out.println(e);
		}
	semChe.release();
	}
 void check(){
	 try{
		 semChe.acquire();
		 System.out.println("Check :"+n);
	 } catch(InterruptedException e){
		 System.out.println(e);
	 }
	 semCon.release();
 }
}

class Pro implements Runnable{
	q Q;
	public Pro(q Q){
		this.Q = Q;
		new Thread(this, "Pro").start();
	}
	public void run(){
		for(int i=0;i<5;i++){
			Q.put(i);
		}
	}
}

class consumer implements Runnable{
	q Q;
	CountDownLatch cd = new CountDownLatch(5);
	public consumer(q Q){
		this.Q = Q;
		new Thread(this,"Con").start();
	}
	public void run(){
		for(int i =0; i<5;i++){
			Q.get();
		}
	}
}

