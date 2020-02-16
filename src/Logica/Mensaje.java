package Logica;

public class Mensaje {

	/**
	 * Mensaje del mensaje (debe ser respondido)
	 */
	private int msg; 
	
	/**
	 * Cliente que genera el mensaje
	 */
	private Cliente client;
	
	public Mensaje(Cliente c){
		msg = 0;
		client = c;
	}
	
	/**
	 * Responde el mensaje (agrega en 1 el valor del msg)
	 */
	public void responderMsg(){
		msg++;
	}
	
	/**
	 * Retorna el cliente dueño del mensaje
	 * @return client, cliente dueño del mensaje
	 */
	public Cliente darCliente(){
		return client;
	}
	
	/**
	 * Retorna el valor del msg
	 * @return msg, valor del mensaje (1 si ya fue respondido, 0 de lo contrario)
	 */
	public int darMsg(){
		return msg;
	}
	
	
}
