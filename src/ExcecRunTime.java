//Never Closes the note pad
public class ExcecRunTime {
	public static void main(String args[]){
		Runtime r = Runtime.getRuntime();
		Process p = null;
		int a = 0;
		try{
			while(a ==0){
			p = r.exec("notepad");
			a = p.waitFor();
			}
		} catch(Exception e){
			System.out.println(e);
		}
		System.out.println(a+"Explorer got closed");
	}

}
