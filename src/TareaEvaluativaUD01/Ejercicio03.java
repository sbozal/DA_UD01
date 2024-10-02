package TareaEvaluativaUD01;

import java.io.*;
import java.util.Arrays;

public class Ejercicio03 {
	
	public static void main(String[] args) {
		
		//File fichero = new File("./files/Ejercicio03/fichero.pdf");
		File fichero = new File("./files/Ejercicio03/fichero.odt");
		
		try (
	            InputStream inputStream = new FileInputStream(fichero);
		){
			// Cabecera de un fichero pdf
			byte[] cabeceraPdf = {37, 80, 68, 70};
			
			// Cabecera del fichero a comprobar
			byte[] cabeceraFichero = new byte[4];
			inputStream.read(cabeceraFichero);
			
			// Comprobar si son iguales
			if (!Arrays.equals(cabeceraPdf, cabeceraFichero)) {
                System.out.println("El fichero NO es un PDF");
            }else {
            	System.out.println("El fichero SI es un PDF");
			}
			
			
			
		}catch(IOException e) {
			System.out.println("Error: "+e);
		}
		
	}

}
