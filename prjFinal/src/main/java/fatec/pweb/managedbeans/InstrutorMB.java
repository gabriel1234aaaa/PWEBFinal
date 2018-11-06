//package fatec.pweb.managedbeans;
//
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import fatec.pweb.model.Instrutor;
//
//@ManagedBean
//@SessionScoped
//public class InstrutorMB {
//	private Instrutor instrutor= new Instrutor();
//	private EntityManagerFactory emf;
//	
//	public InstrutorMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(instrutor);
//		em.getTransaction().commit();
//		em.close();
//		instrutor = new Instrutor();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Instrutor> getInstrutors() {
//		List <Instrutor> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select i from Instrutor i").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Instrutor getInstrutor() {
//		return instrutor;
//	}
//
//	public void setInstrutor(Instrutor instrutor) {
//		this.instrutor = instrutor;
//	}
//	
//}
