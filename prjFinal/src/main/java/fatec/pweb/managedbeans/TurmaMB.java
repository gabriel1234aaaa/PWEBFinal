//package fatec.pweb.managedbeans;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import fatec.pweb.model.Turma;
//
//public class TurmaMB {
//	private Turma turma= new Turma();
//	private EntityManagerFactory emf;
//	
//	public TurmaMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(turma);
//		em.getTransaction().commit();
//		em.close();
//		turma = new Turma();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Turma> getTurmas() {
//		List <Turma> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select t from Turma t").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Turma getTurma() {
//		return turma;
//	}
//
//	public void setTurma(Turma turma) {
//		this.turma = turma;
//	}
//}
