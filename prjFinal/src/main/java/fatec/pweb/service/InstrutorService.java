package fatec.pweb.service;

import java.util.List;

import javax.persistence.Query;

import fatec.pweb.dao.InstrutorDAO;
import fatec.pweb.model.Instrutor;

public class InstrutorService {

	InstrutorDAO instrutorDAO = new InstrutorDAO();
	
	public Instrutor salvar(Instrutor instrutor) {
		instrutor = instrutorDAO.save(instrutor);
		instrutorDAO.closeEntityManager();
		return instrutor;
	}
	
	public List<Instrutor> getInstrutores(){
		List<Instrutor> list = instrutorDAO.getAll(Instrutor.class);
		instrutorDAO.closeEntityManager();
		return list;
	}
	
	public void alterar(Instrutor instrutor) {
		instrutorDAO.save(instrutor);
		instrutorDAO.closeEntityManager();
	}
	
	public void remover(Instrutor instrutor) {
		instrutor = instrutorDAO.getById(Instrutor.class, instrutor.getCpf());
		instrutorDAO.remove(instrutor);
		instrutorDAO.closeEntityManager();
	}
	
	public Instrutor getInstrutorByNome(String nome) {
		Query query = instrutorDAO.getEntityManager().createQuery("SELECT o FROM Instrutor WHERE o.nome = :nome");
		query.setParameter("nome", nome);
		return (Instrutor) query.getSingleResult();
	}
}
