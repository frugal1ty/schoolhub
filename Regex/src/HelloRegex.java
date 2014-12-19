import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloRegex {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("[0-9]{6}(?=[- ]?[A-Z][- ]?[0-9]{5})");
		Matcher m= p.matcher("041083-K-21310 04108A-K-21310 234561-2-BLA12 101268-H-12349 111111-B-54321");
		
		while(m.find()){
			System.out.println(m.group());
		}
		
		Pattern p2 = Pattern.compile("A(B)(C)((D)E)");
		Matcher m2 = p2.matcher("ABCDE");
		
		while(m2.find()){
			for(int i=0; i<=m2.groupCount(); i++)
			System.out.println(m2.group(i));
		}
		
		Pattern p3 = Pattern.compile("(http|ftp|mailto)(?=://)");
		Matcher m3 = p3.matcher("http-header ftp:// mailto:/- http://www.google.de");
				
		while(m3.find()){
			System.out.println(m3.group());
		}
	}
}