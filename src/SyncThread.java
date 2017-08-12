class Callme{
	synchronized public void call(String s){
		System.out.print('['+s);
		try{
			Thread.sleep(100);
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println(']');
	}
}

class Caller implements Runnable{
	String s;
	Callme target;
	Thread t;
	public Caller(Callme targ, String msg){
	target =targ;
	s=msg;
	t = new Thread(this);
	t.start();
	}
	public void run(){
		target.call(s);
	}
	
}

public class SyncThread {
	public static void main(String args[]){
		Callme me = new Callme();
		Caller ob1 = new Caller(me,"string-o-one");
		Caller ob2 = new Caller(me,"string-o-two");
		Caller ob3 = new Caller(me,"string-o-three");
		
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch(InterruptedException e){
			System.out.println(e);
		}
		System.out.println("main Exit");
	}

}
