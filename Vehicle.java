package schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vehicle implements Serializable{
	public String modelo;
	public String num_placa;
	public String ano;
	public String valor;
	
	public Vehicle( String modelo, String num_placa, String ano, String valor) {
		this.modelo = modelo;
		this.num_placa = num_placa;
		this.ano = ano;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		String delimitador = "--------------------------------";
		String info = "-Modelo/Versão: " + modelo + "\n-Numero da Placa: " + num_placa + 
				"\n-Ano de Fabricação: " + ano + "\n-Valor de compra: " + valor;
		
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}