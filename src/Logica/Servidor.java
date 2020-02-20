package Logica;

public class Servidor extends Thread{

	private Buffer b;
	private int id;
	
	public Servidor(int id, Buffer b){
		this.b = b;
		this.id = id;
	}
	
}
