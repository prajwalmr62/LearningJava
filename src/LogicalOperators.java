import java.io.PrintWriter;
public class LogicalOperators {
	public static void main(String args[]){
		boolean a = true, b = false;
		String lit = "This is a test sentence isisis isisis please work", search = "is";
		int i =0;
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println(a && b & true); //Shortcut AND AND
		pw.println(a & b && true); // Shortcut AND AND
		pw.println(a | b); //OR
		pw.println(false | a || b);//Shortcut OR
		pw.println(a == b); //Equals
		pw.println(a !=b); //NOT Equals
		i=5;
		pw.println(lit.charAt(i+search.length())==' '&& lit.charAt(i-1)==' ');
	}

}
