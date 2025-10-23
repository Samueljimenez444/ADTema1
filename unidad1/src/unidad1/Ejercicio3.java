package unidad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {

		String rutaFichero = "C:\\Users\\samuel.jimenez\\palabras.txt";
		
		String rutaFicheroNuevo = "C:\\Users\\samuel.jimenez\\palabrasNuevas.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
			
			String linea;
			
			while ((linea = br.readLine()) != null) {
				
				String[] palabras = linea.split("(?=[A-Z])");
				
				
				
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFicheroNuevo))) {
					
					for (String palabra : palabras) {
						
						bw.write(palabra);
						
						bw.newLine();
					}
				} catch (IOException e) {

				}
				System.out.println("TXT Formado Correctamente");
			}
		} catch (IOException e) {

		}

	}

}
