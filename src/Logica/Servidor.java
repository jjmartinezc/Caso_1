package Logica;

public class Servidor extends Thread{

	private static Buffer b;
	private int id;

	public Servidor(int id, Buffer b){
		this.b = b;
		this.id = id;
	}

	public void run(){
		while(b.darME()>0){
			//try{
				if(b.darNMensajes()>0){
					b.darMensajesServidor().responderMsg();
					b.restarME();
					System.out.println("Mensaje respondido");
					//b.notify();
				}
				yield();
			//}
			//catch(Exception e){

			//}

		}
	}
	
	public int darId(){
		return id;
	}
}
