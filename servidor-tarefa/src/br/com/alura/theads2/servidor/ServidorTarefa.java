package br.com.alura.theads2.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.alura.theads2.jobs.DistribuirTarefas;

public class ServidorTarefa {

	public static void main(String[] args) throws Exception {

		System.out.println("Iniciando servidor.");
		ServerSocket servidor = new ServerSocket(12345);
		
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		while (true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			threadPool.execute(distribuirTarefas);
			
		}

		
	}

}
