package br.com.alura.alurator;

public class Alurator {
	
	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) {
		
		// /controlador/metodo
		
		String[] tokens = url.replaceFirst("/", "").split("/");
		
		String controlerName = Character.toUpperCase(tokens[0].charAt(0)) + tokens[0].substring(1) + "Controller";
		
		try {
			Class<?> classeControle = Class.forName(pacoteBase + controlerName);
			Object instanciaControle = classeControle.newInstance();

			System.out.println(instanciaControle);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return null;
	}

}
