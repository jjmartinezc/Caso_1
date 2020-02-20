package Logica;

import java.util.ArrayList;

public class Buffer {

	private int tamBuffer;
	private ArrayList<Mensaje> mensajes;
	private ArrayList<Mensaje> respuestas;
	
	public Buffer(int tamBuffer){
		this.tamBuffer=tamBuffer;
		mensajes = new ArrayList<Mensaje>();
		respuestas = new ArrayList<Mensaje>();
	}
	
	public void recibirMensaje(Mensaje msg){
		while(mensajes.size()< tamBuffer){
			synchronized(msg){
				mensajes.add(msg);
				System.out.println("Se agregó el mensaje del cliente: " + msg.darCliente() + " al buffer");
			}
			synchronized(msg){
				System.out.println("Se agregó al buffer la respuesta del servidor al mensaje del cliente: " + msg.darCliente());
			}
		}
		synchronized(msg){
		while(mensajes.size()==tamBuffer){
				System.out.println("El buffer no tiene capacidad para recibir más solicitudes, por favor espere.");
				try {
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	
}
