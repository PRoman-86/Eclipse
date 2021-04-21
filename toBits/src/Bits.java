import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//Version 1.2: excluded incorrect argument input and added file size
//Version 1.3: added input of path and file name via command promt
//Version 1.4: polishing code, eliminating bugs
public class Bits {
	static long fileSize; static String pathText;
	public static void main(String[] args) {
		System.out.println("\n The program reads the file and displays the binary code. "
				+ "\n Enter the path to the file:");
		Scanner path=new Scanner(System.in); pathText=path.nextLine();
		if (pathText=="") { 
			System.out.println("No path specified: the program is stopped");
			System.exit(0);
		}
		FileInputStream file=null; BufferedInputStream buffer=null;
		try {
			file=new FileInputStream(pathText);
			System.out.println("\n Start of file "+pathText+"\n ");
			File fileInBytes=new File(pathText); fileSize=fileInBytes.length();
			buffer=new BufferedInputStream(file);
			while (true) {
				int bytes=buffer.read();
				String bits=toBits(bytes);
				if (bytes==-1) break;
				System.out.print(bits+" ");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
			System.exit(0);
		} catch (IOException e1) {
			System.out.println(e1.toString());
			System.exit(0);
		} finally {
			try {
				buffer.close(); file.close(); path.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("\n\n End of file "+pathText+" (Size: "+fileSize+" bytes). "
				+ "The program is stopped.");
		System.exit(0);
	}
	public static String toBits(final int val) {
		 final StringBuilder result = new StringBuilder(); 
		for (int i=0; i<8; i++) { 
		result.append((int)(val >> (8-(i+1)) & 0x0001)); 
		} 
		return result.toString();
		}
}