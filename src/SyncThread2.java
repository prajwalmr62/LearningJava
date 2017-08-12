
class q{
	int n;
	int i=10;
	boolean value = false;
	boolean last = false;
	synchronized int get(){
		try{
			while(!value){
			wait();
			}
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("Got"+n);
		value = false;
		notify();
		return n;
	}
	synchronized void put(int n){
		try{
			while(value){
					wait();
			}
		}catch(InterruptedException e){
					System.out.println(e);
				}
		this.n = n;
		System.out.println("Put"+n);
		value = true;
		notify();
		}
	}
class Producer implements Runnable{
	q q;
	Thread t;
	int i=0;
	Producer(q q){
		this.q = q;
		t = new Thread(this, "Producer");
		t.start();
	}
	public void run(){
		while(i<q.i){
			q.put(i++);
		}
		q.last = true;
		System.out.println("Pro Exit");
	}
}

class Consumer implements Runnable{
	q q;
	Thread t;
	Consumer(q q){
		this.q =q;
		t = new Thread(this, "Consumer");
		t.start();
	}
	public void run(){
		while(q.last != true){
			q.get();
		}
		System.out.println("Con exit");
	}
}
public class SyncThread2 {
	public static void main(String args[]){
		q q = new q();
		q.i=15;
		Producer Pro = new Producer(q);
		Consumer Con = new Consumer(q);
		try{
			Con.t.join();
			Pro.t.join();
	} catch(InterruptedException e){
		System.out.println(e);
	}
		System.out.println("Main Exit");
	}
}
