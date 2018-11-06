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
//import fatec.pweb.model.Pessoa;
//
//@ManagedBean
//@SessionScoped
//public class PessoaMB {
//	private Pessoa pessoa= new Pessoa();
//	private EntityManagerFactory emf;
//	
//	public PessoaMB() {
//		emf = Persistence.createEntityManagerFactory("prjPwebFinal");//persistence.xml>general>name
//	}	
//	
//	public void salvar() {
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(pessoa);
//		em.getTransaction().commit();
//		em.close();
//		pessoa = new Pessoa();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Pessoa> getPessoas() {
//		List <Pessoa> lista;
//		EntityManager em = emf.createEntityManager();
//		lista = em.createQuery("Select p from Pessoa p").getResultList();
//		em.close();
//		return lista;
//	}
//
//	public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}
//}
