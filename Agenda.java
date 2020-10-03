package schedule;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Agenda implements Serializable{
	public String id;
	public String data;
	public String hora;
	
	public Agenda(String id, String data, String hora) {
		this.id = id;
		this.data = data;
		this.hora = hora;
	}
	
	@Override
	public String toString() {
		String delimitador = "########################";
		String info ="---AGENDAMENTOS---" + "\n-ID do cliente: " + id + "\n-Data: " + data + "\n-Horario: " + hora;
		return "\n" + delimitador + "\n" + info + "\n" + delimitador + "\n";
	}
}
