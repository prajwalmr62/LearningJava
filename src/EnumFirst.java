enum Cars{
	Desire("Suzuki"),Alto("Suzuki"),Xcent("Hyundai"),Omni("Suzuki"),A6("Audi"),
	D320("BMW"),X1("BMW"), S60("Volvo");
	
	private String cname;
	
	Cars(String name){
		this.cname = name;
	}
	public String company(){
		return this.cname;
	}
}

public class EnumFirst {
	public static void main(String args[]){
		for(Cars c: Cars.values()){
			System.out.print("the car "+c+"'s manufacturer is ");
			System.out.println(c.company());
			System.out.println("and of Ordinal Number "+c.ordinal());
		}
		Cars c = Cars.Desire;
		System.out.println(c);
	}
}
