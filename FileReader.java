package demo;
import java.io.*;
import java.util.*;

public class FileReader {
	//private ConjuntoDados dados;
	
	public static List<Tuplo> getConjuntoDados(String args) {
		
//		ConjuntoDados dados = new ConjuntoDados();
		List<Tuplo> tuplos=new ArrayList<>();
		
		try {
		//	System.out.print("nome do ficheiro: ");
			Scanner fileLocation = new Scanner (args);
//			Scanner fileLocation = new Scanner ("POO-Notas.csv");
			File file = new File(fileLocation.nextLine());
			fileLocation = new Scanner (file);
			
			

			while (fileLocation.hasNextLine()) {
				String line = fileLocation.nextLine();
				tuplos.add(new Tuplo(line));
				
//				dados.addTuplo1(new Tuplo(line));
			}
			
			
		
			fileLocation.close();

		}

		catch (FileNotFoundException e) {
			System.err.println("nao encontrado");
		}
		return tuplos;
	}
	
//	public void setFiltro(FiltroDados filtro) {
//		this.dados.setFiltro(filtro);
//	}

	
}//}