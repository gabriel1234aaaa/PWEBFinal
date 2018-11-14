package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.CursoDAO;
import fatec.pweb.model.Curso;

public class CursoService {

CursoDAO cursoDAO = new CursoDAO();
 	
	public Curso salvar(Curso curso)
	{
		curso = cursoDAO.save(curso);
		cursoDAO.closeEntityManager();
		return curso;
		
	}
	
	public List <Curso> getCursos()
	{
		List <Curso> list = cursoDAO.getAll(Curso.class);
		cursoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Curso curso) {
		cursoDAO.save(curso);
		cursoDAO.closeEntityManager();
	}

	
	public void remover(Curso curso) {
		
		curso = cursoDAO.getById(Curso.class, curso.getSigla());
		cursoDAO.remove(curso);
		cursoDAO.closeEntityManager();
	}
	
}
