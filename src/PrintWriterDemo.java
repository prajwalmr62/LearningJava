import java.io.PrintWriter;
public class PrintWriterDemo {
	public static void main(String args[]){
		PrintWriter pw = new PrintWriter(System.out, true);
		int i =10;
		int[] ia = new int[100];
		while(i>0){
			ia[i]=i;
			i--;
			pw.print(i);
		}
		pw.println("\nfinal value "+i);
	}

}
