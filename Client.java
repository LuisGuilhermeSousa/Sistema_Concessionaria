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
		String info = "---CLIENTE---\n" + "-Nome: " + nome + "\n-Telefone: " + telefone + "\n-Endere�o: " +
				endereco + "\n-CPF: " + cpf + "\n" + "\n---VE�CULO---\n" + "-Modelo/Vers�o: " + modelo + 
				"\n-Numero da Placa: " +	num_placa +  "\n-Ano de Fabrica��o: " + ano + 
				"\n-Valor de compra: " + valor;
		
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}