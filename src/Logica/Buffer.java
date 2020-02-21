package Logica;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Buffer {

	private static int tamBuffer;
	private static ArrayList<Mensaje> mensajes;
	private ArrayList<Mensaje> respuestas;
	
	public Buffer(int tamBuffer){
		this.tamBuffer=tamBuffer;
		mensajes = new ArrayList<Mensaje>();
		respuestas = new ArrayList<Mensaje>();
	}
	
	public void recibirMensaje(Mensaje msg){
		
		synchronized(msg){
		while(tamBuffer==0){
				System.out.println("El buffer no tiene capacidad para recibir más solicitudes, por favor espere.");
				try {
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//while(tamBuffer>=1){
			synchronized(msg){
				mensajes.add(msg);
				System.out.println("Se agregó el mensaje con id: " + msg.darId() + " al buffer.");
				System.out.println(tamBuffer + " hola");
				--tamBuffer;
				System.out.println("Quedan " + tamBuffer + " espacios en el buffer.");
				//tamBuffer--;
			}
		//}
		
	}
	
	public Mensaje darMensajesServidor(){
		while(mensajes.size()==0){
			synchronized(this){
				try {
					this.wait();
					System.out.println("No hay mensajes en el buffer.");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//while(mensajes.size() >0){
			synchronized(this){
				Mensaje a= mensajes.remove(0);
				tamBuffer++;
				this.notify();
				return a;
				
			}
		//}
		//return null;
	}
	
	
	
	
}
