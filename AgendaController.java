package schedule;
import java.util.ArrayList;
import java.util.List;


public class AgendaController {
	List<Agenda> agenda = new ArrayList<>();
	
	// Cria um Agendamento
	public void Cadastrador_agenda(String id, String data, String hora) {
			this.agenda.add(new Agenda(id, data, hora));
	}
	
	
	// Faz a listagem de Agendamentos
		public void Listagem_Agenda() {
			this.agenda.forEach(client -> System.out.println(client));
			if(agenda.isEmpty()) {
				System.out.println("Não há agendamentos");
			}
		}
	
	
	
	
	
}
