package unidad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Ruta donde crearemos las carpetas
		String rutaCarpetas = "C:\\Users\\samuel.jimenez";

		// Nombre del fichero a crear
		String fichero = "index.html";

		String estructura = "<html>\r\n" + "   <head>\r\n" + "      <title> [Nombre de la carpeta] </title>\r\n"
				+ "   </head>\r\n" + "   <body>\r\n" + "      <h1>[Ruta + nombre de la carpeta]</h1>\r\n"
				+ "      <h3>Autor: [nombre_del_alumno]</h3>\r\n" + "   </body>\r\n" + "</html> ";

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
				}
				//Si la carpeta empieza por EJ
				if (carpeta.getName().toUpperCase().startsWith("EJ")) {
					//Creamos el fichero index
					File index = new File(carpeta, "index.html");
					//Recogemos la ruta de la carptea para crear el formato final del index
					String htmlFinal = estructura.replace("[Nombre de la carpeta]", carpeta.getName())
							.replace("[Ruta + nombre de la carpeta]", carpeta.getAbsolutePath())
							.replace("[nombre_del_alumno]", "Samuel Jiménez");
					//Usamos un writer para escribir la estructura dentro del fichero
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(index))) {
						bw.write(estructura);
						System.out.println("Index Creados");
					} catch (IOException e) {

					}
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
