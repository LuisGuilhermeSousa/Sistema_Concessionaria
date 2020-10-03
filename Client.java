package schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Client implements Serializable{
	public String id;
	public String nome;
	public String telefone;
	public String endereco;
	public String cpf;
	public int loja;
	
	public Client( String id, String nome, String telefone, String endereco, String cpf, int loja) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.loja = loja;
	}

	@Override
	public String toString() {
		String delimitador = "--------------------------------";
		String info = "Id: " +id + "\n-Nome: " + nome + "\n-Telefone: " + telefone + "\n-Endereço: " +
				endereco + "\n-CPF: " + cpf + "\nLoja: " + loja;
		
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}