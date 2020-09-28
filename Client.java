package schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Client implements Serializable{
	public String nome;
	public String telefone;
	public String endereco;
	public String cpf;
	public String num_placa;
	public String modelo;
	public String ano;
	public String valor;

	@Override
	public String toString() {
		String delimitador = "########################";
		String info = "---CLIENTE---\n" + "-Nome: " + nome + "\n-Telefone: " + telefone + "\n-Endereço: " +
				endereco + "\n-CPF: " + cpf + "\n" + "\n---VEÍCULO---\n" + "-Modelo/Versão: " + modelo + 
				"\n-Numero da Placa: " +	num_placa +  "\n-Ano de Fabricação: " + ano + 
				"\n-Valor de compra: " + valor;
		
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}