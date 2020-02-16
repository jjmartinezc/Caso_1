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

			clientes=Integer.parseInt(br.readLine().split("=")[1]);
			mensajes=Integer.parseInt(br.readLine().split("=")[1]);
			servidores=Integer.parseInt(br.readLine().split("=")[1]);
			tam_bufer=Integer.parseInt(br.readLine().split("=")[1]);
			
			br.close();
			
			System.out.println(clientes);
			System.out.println(mensajes);
			System.out.println(servidores);
			System.out.println(tam_bufer);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
