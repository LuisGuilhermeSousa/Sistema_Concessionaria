package schedule;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// caminho para onde eu vou salvar o cadastros de clientes
		String caminho = "C:\\Users\\Silvio\\Desktop\\cadastros.ser";

		// iniciando o controle para receber as informações pelo teclado
		Controller controle = new Controller();

			// lista para armazenar todos os cadastros de cada cliente
		List<Client> cadastros_cliente = new ArrayList<>();
			// lista para armazenar todos os cadastros do agendamento
		List<Agenda> cadastros_agenda = new ArrayList<>();

		// variável de controle para sair do sistema quando escolhido
		int escolha = 0;

		// estrutura de repetição que irá manter o sistema ativo,
		// enquanto for desejado
		while (escolha != 10) {
			Menu.mostrarMenu();
			escolha = controle.opcao();
			
			// cadastrar um cliente/veículo
			if (escolha == 1) {
				Client c = new Client();
				System.out.println("CADASTRO DE CLIENTE");
				System.out.println("Por favor insira o nome do cliente:\n");
				c.nome = controle.texto();
				System.out.println("Por favor insira o telefone:\n");
				c.telefone = controle.texto();
				System.out.println("Por favor insira o endereço:\n");
				c.endereco = controle.texto();
				System.out.println("Por favor insira o CPF:\n");
				c.cpf = controle.texto();
				
				System.out.println("CADASTRO DE VEÍCULO");
				System.out.println("Por favor insira o número da placa");
				c.num_placa = controle.texto();
				System.out.println("Por favor insira o modelo/versão");
				c.modelo = controle.texto();
				System.out.println("Por favor insira o ano de fabricação");
				c.ano = controle.texto();
				System.out.println("Por favor insira o valor de compra");
				c.valor = controle.texto();
				cadastros_cliente.add(c);
			}
			
			
			// criar um agendamento
			if(escolha == 2) {
				Agenda a = new Agenda();
				System.out.println("Por favor insira o nome do cliente");
				a.nome = controle.texto();
				System.out.println("Por favor insira a data (dd/mm/aa)");
				a.data = controle.texto();
				System.out.println("Por favor insira o horário");
				a.hora = controle.texto();
				cadastros_agenda.add(a);
			}
			
			// remover um agendamento  
			if (escolha == 3) {
				System.out.println("Informe o nome do cliente que deseja excluir o agendamento: ");
				String nomeExcluir = controle.texto();
					for (Agenda definicaoagenda : cadastros_agenda ) {
						if (definicaoagenda.nome.equals(nomeExcluir)) {
							cadastros_agenda.remove(definicaoagenda);
								System.out.println("O cadastro do cliente " + nomeExcluir + " foi removido!");
						}
					}
			}
			
			// editar um agendamento  
			if (escolha == 4) {
				System.out.println("Informe o nome do cliente que deseja editar o agendamento: ");
				String nomeEditar = controle.texto();
					for (Agenda definicaoagenda : cadastros_agenda ) {
						if (definicaoagenda.nome.equals(nomeEditar)) {
							System.out.println("Informe a nova data: ");
							String novaData = controle.texto();
							definicaoagenda.data = novaData;
							System.out.println("A data do agenamento do " + nomeEditar + " foi alterado!");
						}
					}
			}

			// listar os clientes/veículos
			if (escolha == 5) {
				cadastros_cliente.forEach(pessoa -> System.out.println(pessoa));
				if (cadastros_cliente.isEmpty()) {
					System.out.println("Não há clientes cadastros!");
				}
			}
			
			// listar os agendamentos
			if (escolha == 6) {
				cadastros_agenda.forEach(agenda -> System.out.println(agenda));
				if (cadastros_agenda.isEmpty()) {
					System.out.println("Não há agendamentos!");
				}
			}
			

			// serializar um objeto é transformalo numa representação
			// binária, dai é possível salvar/escrever este objeto
			// em disco rigido (HD).
			if (escolha == 7) {
				FileOutputStream canal = new FileOutputStream(caminho);
				ObjectOutputStream escritor = new ObjectOutputStream(canal);
				escritor.writeObject(cadastros_cliente);
				escritor.writeObject(cadastros_agenda);
				escritor.close();
				System.out.println("Cadastros de clientes salvo com sucesso!");
			}

			if (escolha == 8) {
				FileInputStream canal = new FileInputStream(caminho);
				ObjectInputStream leitor = new ObjectInputStream(canal);
				// casting / cast -> casca
				cadastros_cliente = (List<Client>) leitor.readObject();
				cadastros_agenda = (List<Agenda>) leitor.readObject();
				leitor.close();
				System.out.println("Cadastros lidos com sucesso!");
			}
			
			// gerar relatório
			if (escolha == 9) {
				FileWriter arq = new FileWriter("C:\\Users\\Silvio\\Desktop\\relatório.txt");
			    PrintWriter gravarArq = new PrintWriter(arq);
			    
			    cadastros_cliente.forEach(pessoa -> gravarArq.print(pessoa));
			    cadastros_agenda.forEach(agenda -> gravarArq.print(agenda));
				System.out.println("Relatório gerado com sucesso!");
				arq.close();
			}
		
		}
		System.out.println("Obrigado e até a próxima");
	}
}
