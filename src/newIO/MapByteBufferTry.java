package newIO;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;

public class MapByteBufferTry {
	public static void main(String args[]){
		String name = "D:/mypy/contact.py";
		FileInputStream fin;
		FileChannel fc;
		long fs;
		MappedByteBuffer mbb;
		try{
			fin = new FileInputStream(name);
			fc = fin.getChannel();
			fs = fc.size();
			mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fs);
			for(int i =0; i< fs; i++){
				System.out.print((char)mbb.get());
			}
			fin.close();
			fc.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}

}
