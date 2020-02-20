package Logica;

public class Mensaje {

	/**
	 * Mensaje del mensaje (debe ser respondido)
	 */
	private int msg; 
	
	/**
	 * id del mensaje
	 */
	private int id;
	
	public Mensaje(int id){
		msg = 0;
		this.id=id;
	}
	
	/**
	 * Responde el mensaje (agrega en 1 el valor del msg)
	 */
	public void responderMsg(){
		msg++;
	}
	
	/**
	 * Retorna el id del mensaje
	 * @return id, id del mensaje
	 */
	public int darId(){
		return id;
	}
	
	/**
	 * Retorna el valor del msg
	 * @return msg, valor del mensaje (1 si ya fue respondido, 0 de lo contrario)
	 */
	public int darMsg(){
		return msg;
	}
	
	
}
