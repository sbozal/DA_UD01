package TareaEvaluativaUD01;

import java.io.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio04 {
	
	public static void main(String[] args) throws IOException {
		
		// Superheroes
		int [] ids= {1, 2, 3, 4, 5, 6, 7};
		String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesos = {76,84,66,136,78,102,70};
		int[] alturas = {178,183,156,152,177,182,188};
		
		// Fichero donde se guarda la información de los superheroes
		File fichero = new File("./files/Ejercicio04/Marvel.dat");
		
		// Si el fichero existe se elimina
		if(fichero.exists()){
			fichero.delete();
		}
		
		// RandomAccessFile
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		
		/***********************************************************
								EJERCICIO 04 a
		***********************************************************/
		// Buffers
		StringBuffer bufferDNIs = null;
		StringBuffer bufferNombres = null;
		StringBuffer bufferIdentidades = null;
		StringBuffer bufferTipos = null;
		
		// Número de registros
		int n = ids.length;
		
		// Recorrer los arrays e introducir los datos en el fichero
		for (int i = 0; i < n; i++) {
			
			file.writeInt(ids[i]);										// Id
			
			bufferDNIs = new StringBuffer(dnis[i]); 					// DNI
			bufferDNIs.setLength(9); 									// Longitud DNI
			file.writeChars(bufferDNIs.toString());						// Insertar DNI
			
			bufferNombres = new StringBuffer(noms[i]); 					// Nombre
			bufferNombres.setLength(10); 								// Longitud Nombre
			file.writeChars(bufferNombres.toString());					// Insertar Nombre
			
			bufferIdentidades = new StringBuffer(identidades[i]); 		// Identidad
			bufferIdentidades.setLength(20); 							// Longitud Identidad
			file.writeChars(bufferIdentidades.toString());				// Insertar Identidad
			
			bufferTipos = new StringBuffer(tipos[i]); 					// Tipo
			bufferTipos.setLength(10); 									// Longitud Tipo
			file.writeChars(bufferTipos.toString());					// Insertar Tipo
			
			file.writeInt(pesos[i]);									// Peso
			
			file.writeInt(alturas[i]);									// Altura
		}
		
		System.out.println("La carga de los personajes ha terminado correctamente.");

		
		/***********************************************************
								EJERCICIO 04 b
		 ***********************************************************/
		
		// Pedimos el dni del superheroe al que queremos cambiar de peso
		//System.out.println("Introduzca el DNI (con letra) del personaje para control de peso:");
		Scanner entradaEscaner = new Scanner (System.in); 
		//String dniIntroducido = entradaEscaner.nextLine(); // Introducir DNI
		
		char dniChar[] = new char[9];
		char nombreChar[] = new char[10];
		char identidadChar[] = new char[20];
		char tipoChar[] = new char[10];		
		char caracter;
		
		int posicion = 0; // Nos posicionamos al principio
		int indice = -1;/*
		String nombreDNI = "";
		int pesoDNI = -1;
		
		file.seek(posicion);
		
		// Leer Marvel.dat
		while (file.getFilePointer() != file.length()) {
			file.seek(posicion); // posicionamiento
						
			int id = file.readInt(); // obtener id del superheroe
						
			// Recorrer los caracteres del dni del superheroe uno a uno
			for (int j = 0; j < dniChar.length; j++) {
				caracter = file.readChar();
				dniChar[j] = caracter; // se van introduciendo los caracteres en el array del dni
			}
									
			// Convertir el dni a string
			String dni = new String(dniChar);
			
			// Recorrer los caracteres del nombre del superheroe uno a uno
			for (int k = 0; k < nombreChar.length; k++) {
				caracter = file.readChar();
				nombreChar[k] = caracter; // se van introduciendo los caracteres en el array del nombre
			}
						
			// Convertir el nombre a string
			String nombre = new String(nombreChar);
			nombre = nombre.trim();
			
			// Recorrer los caracteres de la identidad del superheroe uno a uno
			for (int l = 0; l < identidadChar.length; l++) {
				caracter = file.readChar();
				identidadChar[l] = caracter; // se van introduciendo los caracteres en el array de la identidad
			}
						
			// Recorrer los caracteres del tipo del superheroe uno a uno
			for (int m = 0; m < tipoChar.length; m++) {
				caracter = file.readChar();
				tipoChar[m] = caracter; // se van introduciendo los caracteres en el array del tipo de superheroe
			}
						
			// Recoger el peso
			int peso = file.readInt();		
			
			// Recoger el altura
			int altura = file.readInt();	
						
			// Comprobar si el dni introducido coincide con el dni leido
			if(dniIntroducido.equals(dni)) {
				indice = id-1;				
				
				nombreDNI = nombre;
				pesoDNI = peso;
				
				break; // salir del while
			}
			
			posicion += 110;	
			
		}
		
		// Si el índice sigue siendo -1 es que el dni introducido no se encuentra dentro de marvel.dat
		if(indice == -1){
			
			System.out.println("No exite ningún Superheroe con ese DNI.");
			
		}else {
			
			// Controlar que el peso se puede parsear a entero
			try {
				
				System.out.println("Introduzca su peso actual:");
				int pesoActual = Integer.parseInt(entradaEscaner.nextLine()); // Introducir peso
			
				// Comparar pesos
				if (pesoDNI == pesoActual) {
					System.out.println(nombreDNI + " se mantiene en su peso anterior.");
				} else if(pesoActual > pesoDNI) {
					int pesoEngordado = pesoActual-pesoDNI;
					System.out.println(nombreDNI + " ha engordado " + pesoEngordado + " kilos.");
				} else {
					int pesoAdelgazado = pesoDNI - pesoActual;
					System.out.println(nombreDNI + " ha adelgazado " + pesoAdelgazado + " kilos.");
				}
			}catch(Exception e) {
				System.out.println("Error: " + e);
			}
			
		}*/
		
		
		/***********************************************************
							EJERCICIO 04 c
		 ***********************************************************/
		
		System.out.println("Introduce un tipo de personaje: ");
		String tipoIntroducido =  entradaEscaner.nextLine(); // Introducir tipo

		List<Superheroe> personajes = new ArrayList<>();
		
		
		// Volvemos a poner la posición a 0
		posicion = 0;
		file.seek(posicion);
		
		// Leer Marvel.dat
		while (file.getFilePointer() != file.length()) {
			file.seek(posicion); // posicionamiento
						
			int id = file.readInt(); // obtener id del superheroe
						
			// Recorrer los caracteres del dni del superheroe uno a uno
			for (int j = 0; j < dniChar.length; j++) {
				caracter = file.readChar();
				dniChar[j] = caracter; // se van introduciendo los caracteres en el array del dni
			}
									
			// Convertir el dni a string
			String dni = new String(dniChar);
			
			// Recorrer los caracteres del nombre del superheroe uno a uno
			for (int k = 0; k < nombreChar.length; k++) {
				caracter = file.readChar();
				nombreChar[k] = caracter; // se van introduciendo los caracteres en el array del nombre
			}
						
			// Convertir el nombre a string
			String nombre = new String(nombreChar);
			
			// Recorrer los caracteres de la identidad del superheroe uno a uno
			for (int l = 0; l < identidadChar.length; l++) {
				caracter = file.readChar();
				identidadChar[l] = caracter; // se van introduciendo los caracteres en el array de la identidad
			}
			
			// Convertir la identidad a string
			String identidad = new String(identidadChar);
						
			// Recorrer los caracteres del dni del superheroe uno a uno
			for (int m = 0; m < tipoChar.length; m++) {
				caracter = file.readChar();
				tipoChar[m] = caracter; // se van introduciendo los caracteres en el array del tipo de superheroe
			}
			
			// Convertir la tipología a string
			String tipo = new String(tipoChar);
						
			// Recoger el peso
			int peso = file.readInt();
						
			// Recoger la altura
			int altura = file.readInt();			
						
			// Comprobar si el tipo introducido coincide con el del superheroe
			if(tipoIntroducido.equals(tipo.trim())) {
				
				// Creamos superheroe
				Superheroe personaje = new Superheroe(id, dni, nombre, identidad, tipo, peso, altura);
				personajes.add(personaje);
								
			}
			
			posicion += 110;			
		}
		
		// Si el tipo existe, mostramos en consola el resultado
		if(personajes.size() == 0) {
			System.out.println("No existe " + tipoIntroducido + " en el fichero");
		}else {
			for(int a = 0; a < personajes.size(); a++) {
				System.out.println(personajes.get(a).toString());
			}
		}		
		
		// Cerrar
		entradaEscaner.close();
		file.close();
		
	}

}
