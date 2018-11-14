package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.AlunoDAO;
import fatec.pweb.model.Aluno;

public class AlunoService {
	
	AlunoDAO alunoDAO = new AlunoDAO();
	
	public Aluno salvar(Aluno aluno){
		aluno = alunoDAO.save(aluno);
		alunoDAO.closeEntityManager();
		return aluno;
	}
	
	public List<Aluno> getAlunos(){
		List<Aluno> lista = alunoDAO.getAll(Aluno.class);
		alunoDAO.closeEntityManager();
		return lista;
	}
	
}
