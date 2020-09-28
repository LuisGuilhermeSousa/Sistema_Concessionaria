package schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Agenda implements Serializable{
	public String nome;
	public String data;
	public String hora;
	
	@Override
	public String toString() {
		String delimitador = "########################";
		String info ="---AGENDAMENTOS---" + "\n-Nome: " + nome + "\n-Data: " + data + "\n-Horario: " + hora;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}
