package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		File file = new File("./data/parametros.txt"); 
		int clientes;
		int mensajes;
		int servidores;
		int tam_buffer;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			//Lee el archivo y asigna los valores necesitados para el ejercicio.
			clientes=Integer.parseInt(br.readLine().split("=")[1]);
			mensajes=Integer.parseInt(br.readLine().split("=")[1]);
			servidores=Integer.parseInt(br.readLine().split("=")[1]);
			tam_buffer=Integer.parseInt(br.readLine().split("=")[1]);

			ArrayList<Cliente> cl = new ArrayList<Cliente>();
			ArrayList<Servidor> server = new ArrayList<Servidor>();
			br.close();

			//Inicializa el buffer
			Buffer b = new Buffer(tam_buffer);
			
			//Inicializa los clientes junto con los mensajes a enviar de cada uno.
			for(int i = 0; i<clientes;i++){
				Cliente c = new Cliente(b, i, mensajes);
				cl.add(c);
				for(int j = 0; j<mensajes;j++){
					Mensaje msg = new Mensaje(c);
				}
			}
			
			for(int i = 0; i < servidores; i++){
				Servidor s = new Servidor(i, b);
				server.add(s);
			}


		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
