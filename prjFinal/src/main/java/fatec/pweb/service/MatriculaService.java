package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.MatriculaDAO;
import fatec.pweb.model.Aluno;
import fatec.pweb.model.Matricula;

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
		matricula = matriculaDAO.getById(Matricula.class, matricula.getCodigo());
		matriculaDAO.remove(matricula);
		matriculaDAO.closeEntityManager();
	}
	
	public Matricula getMatriculaByIds(String cpf,String siglaTurma) {
		return matriculaDAO.getEntityManager()
				.createQuery("SELECT o FROM Matricula o WHERE o.cpfaluno = '" + cpf + "' and o.siglaturma = '" + siglaTurma + "'", Matricula.class).getSingleResult();
	}
	
}
