package schedule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class App {
	@SuppressWarnings("unchecked")
	public void Run(int loja) throws Exception {
		// caminho para onde eu vou salvar o cadastros de clientes
		String caminho = "C:\\Users\\Silvio\\Desktop\\cadastros.ser";

		// iniciando o controle para receber as informações pelo teclado
		Controller controle = new Controller();
		ClientController services = new ClientController();
		AgendaController agendamento = new AgendaController();
	

		// variável de controle para sair do sistema quando escolhido
		int escolha = 0;

		// estrutura de repetição que irá manter o sistema ativo,
		// enquanto for desejado
		while (escolha != 10) {
			Menu.mostrarMenu();
			escolha = controle.opcao();
			
			// cadastrar um cliente/veículo
			if (escolha == 1) {
				System.out.println("CADASTRO DE CLIENTE");
				System.out.print("Digite o nome: ");
				String nome = controle.texto();
				
				System.out.println("Digite o telefone: ");
				String telefone = controle.texto();
				
				System.out.println("Digite o endereço: ");
				String endereco = controle.texto();
				
				System.out.println("Digite o CPF: ");
				String cpf = controle.texto();
				
				System.out.println("Deseja cadastrar um veículo? (S/N)");
				String op = controle.texto();
				if(op.equals("S") || op.equals("N")) {
					if(op.equals("S")) {
						System.out.println("CADASTRO DE VEÍCULO");
						System.out.println("Digite número da placa: ");
						String num_placa = controle.texto();
						
						System.out.println("Digite o modelo/versão: ");
						String modelo = controle.texto();
						
						System.out.println("Digite o ano de fabricação: ");
						String ano = controle.texto();
						
						System.out.println("Digite o valor de compra: ");
						String valor = controle.texto();
						
						services.Cadastrador_veiculo(modelo, num_placa, ano, valor);
						System.out.println("\nVeículo cadastrado com sucesso!");
					}
					
					
				}else {
					System.out.println("Por favor digite S ou N");
					op = controle.texto();
				}
				
				services.Cadastrador_cliente(nome, telefone, endereco, cpf, loja);
				System.out.println("\nCliente cadastrado com sucesso!");
			}
			
			
			// criar um agendamento
			if(escolha == 2) {
				System.out.println("Insira o ID do cliente: ");
				String id = controle.texto();
				System.out.println("Digite a data (dd/mm/aa)");
				String data = controle.texto();
				System.out.println("Digite o horário");;
				String hora = controle.texto();
				
				agendamento.Cadastrador_agenda(id, data, hora);
				System.out.println("\nAgendamento relaizado com sucesso!");
			}
			
			// remover um agendamento  
			if (escolha == 3) {
				System.out.println("Informe o ID do cliente que deseja excluir o agendamento: ");
				String idExcluir = controle.texto();
					for (Agenda percorre : agendamento.agenda ) {
						if (percorre.id.equals(idExcluir)) {
							agendamento.agenda.remove(percorre);
							System.out.println("O cadastro do cliente com ID" + idExcluir + " foi removido!");
							break;
						}
					}
			}
			
			// editar um agendamento  
			if (escolha == 4) {
				System.out.println("Informe o nome ID do cliente que deseja trocar a data: ");
				String nomeEditar = controle.texto();
					for (Agenda percorre : agendamento.agenda ) {
						if (percorre.id.equals(nomeEditar)) {
							System.out.println("Informe a nova data: ");
							String novaData = controle.texto();
							percorre.data = novaData;
							System.out.println("A data do agenamento do " + nomeEditar + " foi alterado!");
						}
					}
			}

			// listar os clientes/veículos
			if (escolha == 5) {
				services.Listagem();
			}
			
			// listar os agendamentos
			if (escolha == 6) {
				agendamento.Listagem_Agenda();
			}
			

			// serializar um objeto é transformalo numa representação
			// binária, dai é possível salvar/escrever este objeto
			// em disco rigido (HD).
			if (escolha == 7) {
				FileOutputStream canal = new FileOutputStream(caminho);
				ObjectOutputStream escritor = new ObjectOutputStream(canal);
				escritor.writeObject(services.clientes);
				escritor.writeObject(services.veiculos);
				escritor.writeObject(agendamento.agenda);
				escritor.close();
				System.out.println("Cadastros de clientes salvo com sucesso!");
			}

			if (escolha == 8) {
				FileInputStream canal = new FileInputStream(caminho);
				ObjectInputStream leitor = new ObjectInputStream(canal);
				// casting / cast -> casca
				services.clientes = (List<Client>) leitor.readObject();
				services.veiculos = (List<Vehicle>) leitor.readObject();
				agendamento.agenda = (List<Agenda>) leitor.readObject();
				leitor.close();
				System.out.println("Cadastros lidos com sucesso!");
			}
			
			// gerar relatório
			if (escolha == 9) {
				FileWriter arq = new FileWriter("C:\\Users\\Silvio\\Desktop\\relatório.txt");
			    PrintWriter gravarArq = new PrintWriter(arq);
			    
			    services.clientes.forEach(pessoa -> gravarArq.print(pessoa));
			    services.veiculos.forEach(carro -> gravarArq.print(carro));			    
			    agendamento.agenda.forEach(agenda -> gravarArq.print(agenda));
				System.out.println("Relatório gerado com sucesso!");
				arq.close();
			}
		
		}
		System.out.println("Obrigado e até a próxima");
	}
}