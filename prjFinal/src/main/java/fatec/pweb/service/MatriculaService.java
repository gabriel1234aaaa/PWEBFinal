package fatec.pweb.service;

import java.util.List;

import fatec.pweb.dao.DAOMatricula;
import fatec.pweb.model.Matricula;

public class MatriculaService {
	DAOMatricula matriculaDAO = new DAOMatricula();

	public Matricula salvar(Matricula matricula) {
		matricula = matriculaDAO.save(matricula);
		matriculaDAO.closeEntityManager();
		return matricula;

	}

	public List<Matricula> getCursos() {
		List<Matricula> list = matriculaDAO.getAll(Matricula.class);
		matriculaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Matricula matricula) {
		matriculaDAO.save(matricula);
		matriculaDAO.closeEntityManager();
	}

	public void remover(Matricula matricula) {

		matricula = matriculaDAO.getById(Matricula.class, matricula.getCodigo());
		matriculaDAO.remove(matricula);
		matriculaDAO.closeEntityManager();
	}
}
