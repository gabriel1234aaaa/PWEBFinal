package fatec.pweb.service;

import java.io.Serializable;
import java.util.List;

import fatec.pweb.dao.AVistaDAO;
import fatec.pweb.model.AVista;

public class AVistaService implements Serializable {

	private static final long serialVersionUID = 1L;
	private AVistaDAO aVistaDAO = new AVistaDAO();

	public AVista salvar(AVista aVista) {
		aVista = aVistaDAO.save(aVista);
		aVistaDAO.closeEntityManager();
		return aVista;
	}

	public List<AVista> getAVistas() {
		List<AVista> list = aVistaDAO.getAll(AVista.class);
		aVistaDAO.closeEntityManager();
		return list;
	}

	public void remover(AVista aVista) {
		aVistaDAO.remove(aVista);
		aVistaDAO.closeEntityManager();
	}
	
	public AVista getById(AVista aVista) {
		aVista = aVistaDAO.getById(AVista.class, aVista.getCodigo());
		aVistaDAO.closeEntityManager();
		return aVista;
	}

}
