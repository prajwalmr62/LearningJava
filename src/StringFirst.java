import java.io.PrintWriter;
public class StringFirst {
	public static void main(String args[]){
		PrintWriter pw = new PrintWriter(System.out,true);
		String lit = "This is a test sentence, should replace is by was but should not replace this to thwas";
		String sub = "was";
		String search = "is";
		String result = "";
		String add = lit;
		boolean b;
		int i=0;
		do {
			//a =lit.charAt(i+search.length())==' ';
			i = add.indexOf(search);
			//j = lit.indexOf(search);
			if (i==0){
				b = true;
			} else if(i ==-1){
				b = false;
			}
			else {
				b = (add.charAt(i-1)==' ');
			}
			//pw.println(lit);
			if(i!=-1){
				if (add.charAt(i+search.length())==' ' && b){
					sub = "was";
			} else{
				sub = "is";
				}
			pw.println(i+add);
			result = add.substring(0, i);
			result = sub;
			result = add.substring(i+search.length());
			add = add.substring(i+search.length());
			}
	}while (i != -1);
		pw.println(result);
	}
}
