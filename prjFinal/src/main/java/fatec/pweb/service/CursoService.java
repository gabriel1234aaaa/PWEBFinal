package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.CursoDAO;
import fatec.pweb.model.Curso;

public class CursoService implements Serializable {

	private static final long serialVersionUID = 1L;
	private CursoDAO cursoDAO = new CursoDAO();

	public Curso salvar(Curso curso) {
		curso = cursoDAO.save(curso);
		cursoDAO.closeEntityManager();
		return curso;

	}

	public List<Curso> getCursos() {
		List<Curso> list = cursoDAO.getAll(Curso.class);
		cursoDAO.closeEntityManager();
		return list;
	}

	public void remover(Curso curso) {
		curso = cursoDAO.getById(Curso.class, curso.getSigla());
		cursoDAO.remove(curso);
		cursoDAO.closeEntityManager();
	}

	public Curso getCursoByNome(String nome) {
		return cursoDAO.getEntityManager().createQuery("SELECT o FROM Curso o WHERE o.nome = '" + nome + "'", Curso.class).getSingleResult();
	}

	public Curso getById(Curso curso) {
		curso = cursoDAO.getById(Curso.class, curso.getSigla());
		cursoDAO.closeEntityManager();
		return curso;
	}

}
