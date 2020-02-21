package Logica;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Buffer {

	private static int tamBuffer;
	private static ArrayList<Mensaje> mensajes;
	private static Main ma;
	private static int mensajesEsperados;

	public Buffer(int tamBuffer){
		this.tamBuffer=tamBuffer;
		mensajes = new ArrayList<Mensaje>();
		ma = new Main();
		mensajesEsperados=ma.darClientes()*ma.darMensajes();
	}

	public void recibirMensaje(Mensaje msg){

		synchronized(this){
			while(tamBuffer==0){
				System.out.println("El buffer no tiene capacidad para recibir más solicitudes, por favor espere.");
				try {
					//this.wait();
					Cliente.yield();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		synchronized(this){
			if(tamBuffer>=1){
				mensajes.add(msg);
				System.out.println("Se agregó el mensaje con id: " + msg.darId() + " al buffer.");
				--tamBuffer;

				System.out.println("Quedan " + tamBuffer + " espacios en el buffer.");
				System.out.println(mensajes.size()+" Tamaño mensajes");

				//tamBuffer--;
			}
		}

	}

	public Mensaje darMensajesServidor(){
		while(mensajes.size()==0){
			synchronized(this){
				try {
					System.out.println("Gonoplasta");
					//this.wait();
					System.out.println("No hay mensajes en el buffer.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//synchronized(this){
			if(mensajes.size() >0){
				Mensaje a= mensajes.remove(0);
				if(tamBuffer<ma.tam_buffer){
					tamBuffer++;
				}
				//this.notify();
				return a;

			//}
		}
		return null;
	}

	public int darNMensajes(){
		return mensajes.size();
	}
	
	public int darME(){
		return mensajesEsperados;
	}
	public synchronized void restarME(){
		mensajesEsperados--;
	}


}
