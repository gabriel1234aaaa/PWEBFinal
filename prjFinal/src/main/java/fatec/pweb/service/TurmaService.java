package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.TurmaDAO;
import fatec.pweb.model.Curso;
import fatec.pweb.model.Turma;

public class TurmaService implements Serializable {

	private static final long serialVersionUID = 1L;
	private TurmaDAO turmaDAO = new TurmaDAO();

	public Turma salvar(Turma turma) {
		turma = turmaDAO.save(turma);
		turmaDAO.closeEntityManager();
		return turma;
	}

	public List<Turma> getTurmas() {
		List<Turma> list = turmaDAO.getAll(Turma.class);
		turmaDAO.closeEntityManager();
		return list;
	}

	public void remover(Turma turma) {
		turmaDAO.remove(turma);
		turmaDAO.closeEntityManager();
	}

	public Turma getById(Turma turma) {
		turma = turmaDAO.getById(Turma.class, turma.getSiglaTurma());
		turmaDAO.closeEntityManager();
		return turma;
	}

	public List<Turma> getTurmasByCurso(Curso curso) {
		List<Turma> list = turmaDAO.getEntityManager()
				.createQuery("SELECT o FROM Turma o WHERE o.curso = :curso", Turma.class).setParameter("curso", curso)
				.getResultList();
		turmaDAO.closeEntityManager();
		return list;
	}
}
