package Logica;

public class Cliente extends Thread{
	
	private Buffer b;
	private int enviados;
	private int respondidos;
	private int id;

	
	public Cliente(Buffer b, int id, int enviados){
		this.b = b;
		this.id = id;
		this.enviados = enviados;
		this.respondidos=0;
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
			
		}
	}

	//Cliente
	
}
