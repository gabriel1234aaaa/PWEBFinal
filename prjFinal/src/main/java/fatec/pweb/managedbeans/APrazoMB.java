package fatec.pweb.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fatec.pweb.model.APrazo;


@ManagedBean
@SessionScoped
public class APrazoMB {

	private APrazo aPrazo= new APrazo();
	private EntityManagerFactory emf;
	
	public APrazoMB() {
		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
	}	
	
	public void salvar() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(aPrazo);
		em.getTransaction().commit();
		em.close();
		aPrazo = new APrazo();
	}

	@SuppressWarnings("unchecked")
	public List<APrazo> getAPrazos() {
		List <APrazo> lista;
		EntityManager em = emf.createEntityManager();
		lista = em.createQuery("Select ap from APrazo ap").getResultList();
		em.close();
		return lista;
	}

	public APrazo getAPrazo() {
		return aPrazo;
	}

	public void setAPrazo(APrazo aPrazo) {
		this.aPrazo = aPrazo;
	}
	
	
}
