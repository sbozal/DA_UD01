package TareaEvaluativaUD01;
import java.io.*;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		String ficheroLectura = "./files/Ejercicio02/Nombres.txt";
		String ficheroEscritura = "./files/Ejercicio02/NombresFinal.txt";
		String resultado = "";
		
		// Controlar excepciones
		try{
			
			// Objeto de la clase BufferedReader
			BufferedReader fbr = new BufferedReader(new FileReader(ficheroLectura));
			
			// Leer líneas del fichero
			String linea = fbr.readLine();
			
			while(linea != null) {
				
				// Creamos un array para tener por separado el nombre y el apellido
		    	String nombreCompleto[] = linea.split(" ");
		    	
		    	String nombre = nombreCompleto[0];
		    	
		    	// Comprobar si el nombre tiene 5 letras, si las tiene, se guarda en resultado
		    	if(nombre.length()==5) {
		    		resultado += nombre + "\n";
		    	}
				
				// Siguiente línea
		        linea = fbr.readLine();
				
			}
			
			// Cerrar BufferReader
			fbr.close();
			
			// Crear BufferWriter
			BufferedWriter fbw = new BufferedWriter(new FileWriter(ficheroEscritura));
			
			// Escribir fichero
			fbw.write(resultado);
			
			// Cerrar BufferedWriter
			fbw.close();
			
		}catch(IOException e) {
			System.out.println("Error: "+e);
		}
		
	}
	
}
