import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Encrypt{
	public static char[] mix(char[] c) {
		for(int i=0;i<c.length/2;i+=3) {
			char temp = c[i];
			c[i] = c[c.length-1-i];
			c[c.length-1-i] = temp;
		}
		return c;
	}

	public static void main(String[] args) throws IOException {
		try {
			String theString = "";
			PrintStream out = new PrintStream(new FileOutputStream("Output.txt", true));
			System.setOut(out);
			File file = new File("zing.txt");
			Scanner scanner = new Scanner(file);

			theString = scanner.nextLine();
			while (scanner.hasNextLine()) {
				theString = theString + "\n" + scanner.nextLine();
			}
			scanner.close();
			char[] charArray = theString.toCharArray();
			charArray = mix(charArray);
			//charArray = fix(charArray);
			for(int i=0;i<charArray.length;i++) {
				//if(charArray[i]=='\t') System.out.print("\n");
				System.out.print(charArray[i]);
			}
		}
		catch(Exception e){
			System.err.println("Error: "+e.getMessage());
		}
	}
}