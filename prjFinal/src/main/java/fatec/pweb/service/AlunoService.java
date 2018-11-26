package fatec.pweb.service;

import java.util.List;

import javax.persistence.Query;

import fatec.pweb.dao.AlunoDAO;
import fatec.pweb.model.Aluno;

public class AlunoService {

	AlunoDAO alunoDAO = new AlunoDAO();

	public Aluno salvar(Aluno aluno) {
		aluno = alunoDAO.save(aluno);
		alunoDAO.closeEntityManager();
		return aluno;
	}

	public void remover(Aluno aluno) {
		alunoDAO.remove(aluno);
		alunoDAO.closeEntityManager();
	}
	
	public Aluno getById(Aluno aluno){
		aluno = alunoDAO.getById(Aluno.class, aluno.getCpf());
		alunoDAO.closeEntityManager();
		return aluno;
	}

	public List<Aluno> getAlunos() {
		List<Aluno> lista = alunoDAO.getAll(Aluno.class);
		alunoDAO.closeEntityManager();
		return lista;
	}

	public Aluno getAlunoByNome(String nome) {
		Query query = alunoDAO.getEntityManager().createQuery("SELECT o FROM Aluno WHERE o.nome = :nome");
		query.setParameter("nome", nome);
		return (Aluno) query.getSingleResult();
	}
}
