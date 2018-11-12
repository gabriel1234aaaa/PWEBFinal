//package fatec.pweb.service.generic;
//
//import java.io.Serializable;
//import java.util.List;
//
//public abstract class GenericService<D, C, I extends Serializable> {
//
//	D classeDao = null;
//
//	public C salvar(C varClass) {
//		varClass = classeDao.save(varClass);
//		classeDao.closeEntityManager();
//		return varClass;
//	}
//
//	public List<C> getAll() {
//		List<C> list = classeDao.getAll(C.class);
//		classeDao.closeEntityManager();
//		return list;
//	}
//
//	public void alterar(Curso curso) {
//		cursoDAO.save(curso);
//		cursoDAO.closeEntityManager();
//	}
//
//	public void remover(Curso curso) {
//
//		curso = cursoDAO.getById(Curso.class, curso.getSigla());
//		cursoDAO.remove(curso);
//		cursoDAO.closeEntityManager();
//	}
//}
