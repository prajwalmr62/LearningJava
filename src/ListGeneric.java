import java.util.*;

public class ListGeneric {
	public static void main(String args[]){
		ArrayList<Integer> li = new ArrayList<Integer>();
		//ArrayList<Integer> bi = new ArrayList<Integer>();
		li.add(100);
		int i = 0;
		try{
		for(int j: li){
			System.out.println(li.get(i++));
			li.add(j);
		}
		}catch (ConcurrentModificationException e){
			System.out.println("Wont work bro!");
	}
	}

}
