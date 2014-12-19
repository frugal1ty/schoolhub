import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class Testprogramm {

	public static void main(String[] args) {
		Scanner line = new Scanner(System.in);
		System.out.print("Enter regex: ");
		boolean abord=true;
		while(abord){
			try {
				Pattern p = Pattern.compile(line.nextLine());
				System.out.print("Enter searchtext: ");
				Matcher m = p.matcher(line.nextLine());
				while (m.find()) {
					System.out.println("Treffer: " + m.group() + " zwischen "
						+ m.start() + " und " + m.end());
				}
			} 
			catch (PatternSyntaxException e) {
				System.err.println(e.getMessage());
			}
			System.out.print("Again? y/n");
			String answer=line.next();
			if(answer.equalsIgnoreCase("no") || answer.equals("n")){
				abord=false;
			}
		}
		line.close();
	}
}