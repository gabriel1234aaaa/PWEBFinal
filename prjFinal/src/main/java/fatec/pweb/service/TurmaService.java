package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.DAOTurma;
import fatec.pweb.model.Turma;

public class TurmaService {
	DAOTurma turmaDAO = new DAOTurma();

	public Turma salvar(Turma turma) {
		turma = turmaDAO.save(turma);
		turmaDAO.closeEntityManager();
		return turma;

	}

	public List<Turma> getCursos() {
		List<Turma> list = turmaDAO.getAll(Turma.class);
		turmaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Turma turma) {
		turmaDAO.save(turma);
		turmaDAO.closeEntityManager();
	}

	public void remover(Turma turma) {

		turma = turmaDAO.getById(Turma.class, turma.getSiglaTurma());
		turmaDAO.remove(turma);
		turmaDAO.closeEntityManager();
	}
}
