package concPro;

import java.util.concurrent.Exchanger;

public class Exc {
	public static void main(String args[]){
		Exchanger<Integer> ex = new Exchanger<Integer>();
		new Producer(ex);
		new Cons(ex);
	}
}

class Producer implements Runnable{
	Exchanger<Integer> ex;
	int i=0;
	public Producer(Exchanger<Integer> ex){
		this.ex = ex;
		new Thread(this,"Pro").start();
	}
	public void run(){
			try{
				while(i<5){
				//System.out.println("Put: "+i);
				i = ex.exchange(i);
			}
			}catch(Exception e){
				System.out.println(e);
			}
	}
	
}

class Cons implements Runnable{
	Exchanger<Integer> ex;
	int i=0;
	public Cons(Exchanger<Integer> ex){
		this.ex = ex;
		new Thread(this,"Cons").start();
	}
	public void run(){
			try{
				while(i<4){
					i = ex.exchange(i+1);
			System.out.println("Got: "+i);
				}
		} catch(Exception e){
			System.out.println(e);
		}
	}
}