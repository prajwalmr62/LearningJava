package concPro;

import java.util.concurrent.*;

public class CallableDemo {
	public static void main(String args[]){
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> n;
		Future<String> s;
		n = es.submit(new Num(30));
		s = es.submit(new Str("Prajwal"));
		try{
			System.out.println(n.get(1, TimeUnit.MICROSECONDS));
			System.out.println(s.get(300, TimeUnit.NANOSECONDS));
		} catch(InterruptedException e){
			System.out.println(e);
		}catch(ExecutionException e){
			System.out.println(e);
		}catch(TimeoutException e){
			System.out.println("Timeout!");
		}
		es.shutdown();
	}
}

class Num implements Callable<Integer>{
	Integer n;
	Num(Integer n){
		this.n = n;
	}
	public Integer call(){
		for(int i =0; i<n;i++){
			n = n*n +i*i;
		}
		return (n);
	}
}

class Str implements Callable<String>{
	String s;
	Str(String s){
		this.s = s;
	}
	public String call(){
		s = s.substring(1);
		return(s);
	}
}