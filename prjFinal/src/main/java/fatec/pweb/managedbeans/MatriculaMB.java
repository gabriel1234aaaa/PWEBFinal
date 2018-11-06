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
//import fatec.pweb.model.Matricula;
//
//@ManagedBean
//@SessionScoped
//public class MatriculaMB {
//	private Matricula matricula= new Matricula();
//	private EntityManagerFactory emf;
//	
//	public MatriculaMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(matricula);
//		em.getTransaction().commit();
//		em.close();
//		matricula = new Matricula();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Matricula> getMatriculas() {
//		List <Matricula> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select m from Matricula m").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Matricula getMatricula() {
//		return matricula;
//	}
//
//	public void setMatricula(Matricula matricula) {
//		this.matricula = matricula;
//	}
//}
