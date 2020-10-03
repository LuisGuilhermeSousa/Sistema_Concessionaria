package schedule;

public class Menu {
	// métodos static, são métodos que não precisam de um objeto
	// para serem executados!
	// métodos static pertencem a classe
	// static é um modificador de comportamento
	public static void mostrarMenu() {
		System.out.println("\n*********************");
		System.out.println("Selecione a opção desejada:");
		System.out.println("1. Cadastrar cliente");
		System.out.println("2. Fazer agendamento");
		System.out.println("3. Remover agendamento");
		System.out.println("4. Editar agendamento");
		System.out.println("5. Listar cliente");
		System.out.println("6. Listar agendamentos");
		System.out.println("7. Salvar arquivo");
		System.out.println("8. Ler arquivo");
		System.out.println("9. Gerar relatório");

		System.out.println("10. Tchau");
		System.out.println("*********************\n");
	}
}