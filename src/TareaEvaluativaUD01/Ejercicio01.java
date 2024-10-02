package TareaEvaluativaUD01;
import java.io.*;

public class Ejercicio01 {
	
	public static void main(String[] args) {
		
		// Controlar excepciones
		try {
			
			// Leer el fichero con FileReader
			FileReader reader = new FileReader("./files/Ejercicio01/FicheroLectura.txt");
			
			// Leer los carácteres del fichero
			String lectura = "";
			int i = reader.read();
			while(i!=-1) {
				lectura += (char)i;				
				i=reader.read();
			}
			
			reader.close();
			
			// Invertir el orden del texto
			String escritura = "";
			String linea[] = lectura.split(" ");
			
			for(int j=0; j<=linea.length-1; j++) {
				for(int k=linea[j].length()-1; k>=0; k--) {
					escritura += linea[j].charAt(k);
				}
				escritura += " ";
			}
			
			// Escribir fichero con FileWriter
			FileWriter writer = new FileWriter("./files/Ejercicio01/FicheroEscritura.txt");
			writer.write(escritura);
			writer.close();
			
		}catch(IOException e) {
			System.out.println("Error: "+e);
		}
		
	}

}
