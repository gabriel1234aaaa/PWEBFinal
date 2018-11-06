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
//import fatec.pweb.model.Aluno;
//
//
//@ManagedBean
//@SessionScoped
//public class AlunoMB {
//	private Aluno aluno = new Aluno();
//	private EntityManagerFactory emf;
//	
//	public AlunoMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(aluno);
//		em.getTransaction().commit();
//		em.close();
//		aluno = new Aluno();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Aluno> getAlunos() {
//		List <Aluno> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select a from Aluno a").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Aluno getAluno() {
//		return aluno;
//	}
//
//	public void setAluno(Aluno aluno) {
//		this.aluno = aluno;
//	}
//	
//}
