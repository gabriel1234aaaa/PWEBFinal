package fatec.pweb.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fatec.pweb.model.AVista;

@ManagedBean
@SessionScoped
public class AVistaMB {
	private AVista aVista= new AVista();
	private EntityManagerFactory emf;
	
	public AVistaMB() {
		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
	}	
	
	public void salvar() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(aVista);
		em.getTransaction().commit();
		em.close();
		aVista = new AVista();
	}

	@SuppressWarnings("unchecked")
	public List<AVista> getAVistas() {
		List <AVista> lista;
		EntityManager em = emf.createEntityManager();
		lista = em.createQuery("Select av from AVista av").getResultList();
		em.close();
		return lista;
	}

	public AVista getAVista() {
		return aVista;
	}

	public void setAVista(AVista aVista) {
		this.aVista = aVista;
	}
	
}
