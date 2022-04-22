import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramBufferedWriter {

	public static void main(String[] args) {

		/* cria/recria arquivo : new FileWriter(path)
		 * acrescenta ao arquivo existente : new fileWriter(path,true) 
		 * fileWriter x BufferedWriter(mais rápido)
		 * */
		
		String[] lines = new String[] {"Good Morning", "Good afternoon", "Good Nigth"};
		
		String path = "c:\\temp\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
