package Logica;

import java.util.ArrayList;

public class Cliente extends Thread{
	
	private Buffer b;
	private int enviados;
	private int respondidos;
	private int id;
	private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();

	
	public Cliente(Buffer b, int id, int enviados, ArrayList<Mensaje> mensajes){
		this.b = b;
		this.id = id;
		this.enviados = enviados;
		this.respondidos=0;
		this.mensajes=mensajes;
	}
	
	public int darRespondidos(){
		return respondidos;
	}
	
	public void registrarRespuesta(){
		respondidos++;
	}
	
	public int darId(){
		return id;
	}
	
	public int darEnviados(){
		return enviados;
	}
	
	public void run(){
		while(enviados!=respondidos){
			//b.recibirMensaje();
		}
	}

	//Cliente
	
}
