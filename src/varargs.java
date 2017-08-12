
public class varargs {
	private static void vararg(int ... v){
		for(int x: v) System.out.println(x+"var1");
	};
	private static void var2(int[] v){
		for(int x: v) System.out.println(x+"var2");
	};

	public static void main(String args[]){
		int[] li = new int[10];
		for (int x=1; x<10; x++) li[x]=x;
		vararg(1);
		var2(li);
		vararg(1,2,3,4);
		vararg(1,2,3);
		vararg();
	};
}
