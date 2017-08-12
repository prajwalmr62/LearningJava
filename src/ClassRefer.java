class New{
	int one,two,three;
	public New(int a, int b, int c){
		this.one = a;
		this.two = b;
		this.three = c;
	};
	public int calc(){
		return (one*two*three);
	};
	protected void finalize(){
		System.out.println("Finalized");
	};
}

public class ClassRefer {
	public static void main(String[] args){
		New clan = new New(1,2,3);
		System.out.println(clan.calc());
		New clan2 = clan;
		clan2.one=2;
		clan2.two = 4;
		System.out.println(clan2.calc());
	}

}
