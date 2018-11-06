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
//import fatec.pweb.model.Curso;
//
//@ManagedBean
//@SessionScoped
//public class CursoMB {
//	private Curso curso= new Curso();
//	private EntityManagerFactory emf;
//	
//	public CursoMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(curso);
//		em.getTransaction().commit();
//		em.close();
//		curso = new Curso();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Curso> getCursos() {
//		List <Curso> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select c from Curso c").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Curso getCurso() {
//		return curso;
//	}
//
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
//	
//}
