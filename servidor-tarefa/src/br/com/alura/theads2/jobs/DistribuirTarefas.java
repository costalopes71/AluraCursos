package br.com.alura.theads2.jobs;

import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para " + socket.getPort());

			Scanner entradaCliente = new Scanner(socket.getInputStream());

			while (entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println(comando);
			}
			
			entradaCliente.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}