package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Cliente> cl = new ArrayList<Cliente>();
	private static ArrayList<Servidor> server = new ArrayList<Servidor>();
	private static int clientes;
	private static int mensajes;
	private static int servidores;
	public static int tam_buffer;

	public static void main(String[] args) {

		File file = new File("./data/parametros.txt"); 
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			//Lee el archivo y asigna los valores necesitados para el ejercicio.
			clientes=Integer.parseInt(br.readLine().split("=")[1]);
			mensajes=Integer.parseInt(br.readLine().split("=")[1]);
			servidores=Integer.parseInt(br.readLine().split("=")[1]);
			tam_buffer=Integer.parseInt(br.readLine().split("=")[1]);


			br.close();

			//Inicializa el buffer
			Buffer b = new Buffer(tam_buffer);

			//Inicializa los clientes junto con los mensajes a enviar de cada uno.
			for(int i = 0; i<clientes;i++){
				ArrayList<Mensaje> m = new ArrayList<Mensaje>();
				for(int j = 0; j<mensajes;j++){
					Mensaje msg = new Mensaje((i*mensajes)+j);
					m.add(msg);
				}
				Cliente c = new Cliente(b, i,m.size(), m);
				cl.add(c);
			}

			for(int i = 0; i < servidores; i++){
				Servidor s = new Servidor(i, b);
				server.add(s);
			}


		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		run();
	}


	public static void run(){	

		for(int i =0;i<cl.size();i++){
			cl.get(i).start();
		}	

		for(int i =0;i<server.size();i++){
			server.get(i).start();
		}

	}

	public int darClientes(){
		return clientes;
	}
	public int darMensajes(){
		return mensajes;
	}


}
