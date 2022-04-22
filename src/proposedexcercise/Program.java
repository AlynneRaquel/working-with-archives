package proposedexcercise;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

		public static void main(String[] args) {
		
				Locale.setDefault(Locale.US);
				Scanner sc = new Scanner(System.in);
				
				List<Product> list = new ArrayList<>();
				
				System.out.println("Enter a path folder");
				String sourceFileStr = sc.nextLine();
				
				File sourceFile = new File(sourceFileStr);
				String sourceFolderStr = sourceFile.getParent();
				
				System.out.println("-----------------------------------");
				boolean sucess = new File(sourceFolderStr +"\\out").mkdir();
				System.out.println("Directory created sucessfully: " + sucess);
				
				String targetFileStr = sourceFolderStr + "\\out\\summary.csv"; 
				
				try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
						
						String itemCsv = br.readLine();
						while(itemCsv != null) {
								
								String[] fields = itemCsv.split(",");
								String name = fields[0];
								double price = Double.parseDouble(fields[1]);
								int quantity = Integer.parseInt(fields[2]);
								
								list.add(new Product(name, price, quantity));
								
								itemCsv = br.readLine();
						} 
				
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr, true))) {
								
								for(Product item : list) {
										bw.write(item.getName() + "," + String.format("%.2f", item.total()));
										bw.newLine();
								}
								
						} catch (IOException e) {
							e.printStackTrace();
						}
				
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				sc.close();		
				
			}

}
