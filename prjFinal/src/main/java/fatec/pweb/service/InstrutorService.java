package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.InstrutorDAO;
import fatec.pweb.model.Instrutor;
import fatec.pweb.model.Turma;

public class InstrutorService implements Serializable {

	private static final long serialVersionUID = 1L;
	private InstrutorDAO instrutorDAO = new InstrutorDAO();
	private TurmaService turmaService = new TurmaService();

	public Instrutor salvar(Instrutor instrutor) {
		instrutor = instrutorDAO.save(instrutor);
		instrutorDAO.closeEntityManager();
		return instrutor;
	}

	public List<Instrutor> getInstrutores() {
		List<Instrutor> list = instrutorDAO.getAll(Instrutor.class);
		instrutorDAO.closeEntityManager();
		return list;
	}

	public void remover(Instrutor instrutor) {
		instrutor = instrutorDAO.getById(Instrutor.class, instrutor.getCpf());
		for(Turma turma : instrutor.getTurmas()) {
			turma.setInstrutor(null);
			turmaService.salvar(turma);
		}
		instrutorDAO.remove(instrutor);
		instrutorDAO.closeEntityManager();
	}

	public Instrutor getInstrutorByNome(String nome) {
		return instrutorDAO.getEntityManager()
				.createQuery("SELECT o FROM Instrutor o WHERE o.nome = '" + nome + "'", Instrutor.class).getSingleResult();
	}

	public Instrutor getById(Instrutor instrutor) {
		instrutor = instrutorDAO.getById(Instrutor.class, instrutor.getCpf());
		instrutorDAO.closeEntityManager();
		return instrutor;
	}
}
