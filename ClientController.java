package schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientController {
	List<Client> clientes = new ArrayList<>();
	List<Vehicle> veiculos = new ArrayList<>();
	
	// Gera o id
	public String generateHexCode() {
        Random random = new Random();
        int val = random.nextInt();
        String Code = new String();
        Code = Integer.toHexString(val);
        
        return Code;
	}
	
	// Cadastrador de Clientes
	public void Cadastrador_cliente(String nome, String telefone, String endereco, String cpf, int loja ) {
		this.clientes.add(new Client(this.generateHexCode(), nome, telefone, endereco, cpf, loja));
	}
	
	// Cadastrador de Veículos
	public void Cadastrador_veiculo(String num_placa, String modelo, String ano, String valor) {
		this.veiculos.add(new Vehicle(modelo, num_placa, ano, valor));
	}
	
	// Faz a listagem de Clientes e Veículos
	public void Listagem() {
		this.clientes.forEach(client -> System.out.println(client));
		this.veiculos.forEach(vehicle -> System.out.println(vehicle));
		if(clientes.isEmpty()) {
			System.out.println("Não há clientes cadastrados");
		}
	}

	

}
