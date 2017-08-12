package network;

import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class HURLCon {
	public static void main(String args[]) throws Exception {
		URL site = new URL("http://localhost:80/opencart");
		HttpURLConnection hucsite = (HttpURLConnection) site.openConnection();
		PrintWriter pw = new PrintWriter(System.out,true);
		pw.println("Request type: "+hucsite.getRequestMethod());
		pw.println("Response Code: "+hucsite.getResponseCode());
		pw.println("Response Message: "+hucsite.getResponseMessage());
		Map<String, List<String>> HdrMap = hucsite.getHeaderFields();
		Set<String> field = HdrMap.keySet();
		for(String K: field){
			pw.println("Key: "+K+", Value: "+HdrMap.get(K));
		}
	}

	
}
