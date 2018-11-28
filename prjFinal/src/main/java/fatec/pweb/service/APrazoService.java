package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.APrazoDAO;
import fatec.pweb.model.APrazo;

public class APrazoService implements Serializable {

	private static final long serialVersionUID = 1L;
	APrazoDAO aPrazoDAO = new APrazoDAO();

	public APrazo salvar(APrazo aPrazo) {
		aPrazo = aPrazoDAO.save(aPrazo);
		aPrazoDAO.closeEntityManager();
		return aPrazo;

	}

	public List<APrazo> getAPrazos() {
		List<APrazo> list = aPrazoDAO.getAll(APrazo.class);
		aPrazoDAO.closeEntityManager();
		return list;
	}

	public void alterar(APrazo aPrazo) {
		aPrazoDAO.save(aPrazo);
		aPrazoDAO.closeEntityManager();
	}

	public void remover(APrazo aPrazo) {

		aPrazo = aPrazoDAO.getById(APrazo.class, aPrazo.getCodigo());
		aPrazoDAO.remove(aPrazo);
		aPrazoDAO.closeEntityManager();
	}
}
