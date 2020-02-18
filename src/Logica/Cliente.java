package Logica;

import java.util.ArrayList;

public class Cliente extends Thread{
	
	private Buffer b;
	private int enviados;
	private int respondidos;
	private int id;
	private ArrayList<Mensaje> mensajes;
	private ArrayList<Mensaje> respuestas;

	
	public Cliente(Buffer b, ArrayList<Mensaje> mensajes, int id){
		this.b = b;
		this.mensajes = mensajes;
		this.id = id;
		respuestas = new ArrayList<Mensaje>();
		this.enviados = mensajes.size();
		this.respondidos=respuestas.size();
	}
	
	public void run(){
		
	}

	//Cliente
	
}
