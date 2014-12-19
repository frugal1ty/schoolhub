import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RegexTransliteration {

	public static void main(String[] args) {
		
	}
	
	public void copyFile(String fileLocation, String fileDestination){
		
		try(BufferedReader in=new BufferedReader(new FileReader(fileLocation)); BufferedWriter out=new BufferedWriter(new FileWriter("tr_"+fileLocation))){
			String read="";
			while((read=in.readLine()) != null){
				out.write(read.replaceAll("�", "Ae"));
				out.write(read.replaceAll("�", "ae"));
				out.write(read.replaceAll("�", "Oe"));
				out.write(read.replaceAll("�", "oe"));
				out.write(read.replaceAll("�", "Ue"));
				out.write(read.replaceAll("u", "ue"));
				out.write(read.replaceAll("�", "ss"));
			}
		}
		catch(IOException e){
			e.getMessage();
		}
	}
}