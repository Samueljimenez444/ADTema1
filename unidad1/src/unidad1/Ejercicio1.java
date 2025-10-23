package unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {

		// Ruta donde crearemos las carpetas
		String rutaCarpetas = "C:\\Users\\samuel.jimenez";

		// Ruta donde tenemos el fichero a leer
		String rutaEstructura = "C:\\Users\\samuel.jimenez\\carpetas.txt";

		// Creamos un bufferedReader para leer nuestro fichero de rutas
		try (BufferedReader br = new BufferedReader(new FileReader(rutaEstructura))) {
			// Creamos una variable para almacenar los datos del fichero
			String linea;
			// While para recorrer todas las lineas
			while ((linea = br.readLine()) != null) {
				// Creamos la carpeta en la ruta con el nombre que hemos recibido al leer
				File carpeta = new File(rutaCarpetas, linea);
				// Si la carpeta existe
				if (!carpeta.exists()) {
					// Creamos la carpeta y sus intermediarios
					carpeta.mkdirs();

				} else {
					System.out.println("Las carpetas ya estaban creadas");
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
