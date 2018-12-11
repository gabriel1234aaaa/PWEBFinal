package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import fatec.pweb.dao.MatriculaDAO;
import fatec.pweb.model.Aluno;
import fatec.pweb.model.Matricula;
import fatec.pweb.model.Turma;

public class MatriculaService implements Serializable {

	private static final long serialVersionUID = 1L;
	private MatriculaDAO matriculaDAO = new MatriculaDAO();

	public Matricula salvar(Matricula matricula) {
		matricula = matriculaDAO.save(matricula);
		matriculaDAO.closeEntityManager();
		return matricula;
	}

	public List<Matricula> getMatriculas() {
		List<Matricula> list = matriculaDAO.getAll(Matricula.class);
		matriculaDAO.closeEntityManager();
		return list;
	}

	public void remover(Matricula matricula) {
		matriculaDAO.remove(matricula);
		matriculaDAO.closeEntityManager();
	}

	public Matricula getMatriculaByIds(Aluno aluno, Turma turma) {
		Matricula matricula = null;
		try {
			matricula = matriculaDAO.getEntityManager()
					.createQuery("SELECT o FROM Matricula o WHERE o.aluno = :aluno and o.turma = :turma",
							Matricula.class)
					.setParameter("aluno", aluno).setParameter("turma", turma).getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		return matricula;
	}

}
