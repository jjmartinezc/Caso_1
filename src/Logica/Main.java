package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		File file = new File("./data/parametros.txt"); 
		int clientes;
		int mensajes;
		int servidores;
		int tam_bufer;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			//Lee el archivo y asigna los valores necesitados para el ejercicio.
			clientes=Integer.parseInt(br.readLine().split("=")[1]);
			mensajes=Integer.parseInt(br.readLine().split("=")[1]);
			servidores=Integer.parseInt(br.readLine().split("=")[1]);
			tam_bufer=Integer.parseInt(br.readLine().split("=")[1]);
			
			br.close();
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
