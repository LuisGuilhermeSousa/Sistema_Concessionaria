package schedule;

public class Loja {
	public static void main(String[] args) throws Exception {
		Controller controle = new Controller();
		
		int escolha = 0;
		
		
		while (escolha == 0) {
			
				
			System.out.println("\n\n--------------------------");
			System.out.println("  Bem vindo! ");
			System.out.println("--------------------------");
			System.out.println("  Escolha a sua loja  ");
			System.out.println("1 -  Principal");
			System.out.println("2 -  Loja 1");
			System.out.println("3 -  Loja 2");
			System.out.println("--------------------------");
			
		
			escolha = controle.opcao();
			
					
		}
		
		App admin = new App();
		admin.Run(escolha);
	
	}
}
