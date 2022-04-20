import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgramBufferedReader {

	public static void main(String[] args) {
		
		String path = "c:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			/* FORMA VERBOSA DE FAZER
			  fr = new FileReader(path);
			  br = new BufferedReader(fr);//deixa leitura mais rápida . 
		      br = new BufferedReader(FileReader(path)); -- instânciando em uma variável
		    */
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
