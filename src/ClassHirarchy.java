
public class ClassHirarchy {
	
	public static void main(String args[]){
		top topClass = new top("Prajwal");
		topClass.print();
		topClass.a();
	}

}

class base1{
	//properties
	String name;
	public base1(String name){
		this.name = name;
	}
	public String get_name(){
		return name;
	}
}

interface let{
	public static final int con = 2323;
	//public static long VariableDeclaratorId =1;
	public void a();
}

class base2 extends base1{
	String name2;
	public base2(String name){
		super(name+" : Sent from base 2");
		this.name2 = name;
	}
}

class top extends base2 implements let{
	top(String name){
		super(name);
	}
	public void print(){
		System.out.println(name+"\n"+name2);
	}
	public void a(){
		System.out.println(con);
	}
	
}