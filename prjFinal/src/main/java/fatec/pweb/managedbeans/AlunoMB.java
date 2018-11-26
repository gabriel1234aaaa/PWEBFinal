package fatec.pweb.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Aluno;
import fatec.pweb.service.AlunoService;

@ManagedBean
@ViewScoped
public class AlunoMB {

	Aluno aluno = new Aluno();
	AlunoService servico = new AlunoService();
	List<Aluno> alunos;
	boolean habilitarCorpo = true;
	boolean modoInsercao = false;
	boolean modoAlteracao = false;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isHabilitarCorpo() {
		return habilitarCorpo;
	}

	public void setHabilitarCorpo(boolean habilitarCorpo) {
		this.habilitarCorpo = habilitarCorpo;
	}

	public void salvar() {
		aluno = servico.salvar(aluno);
		if (alunos != null) {
			alunos.add(aluno);
		}
		aluno = new Aluno();
	}

	public void remover(Aluno aluno) {
		servico.remover(aluno);
		alunos.remove(aluno);
	}

	public List<Aluno> getAlunos() {
		if (alunos == null) {
			alunos = servico.getAlunos();
		}

		return alunos;
	}
	
	public void consultar(){
		Aluno consulta = servico.getById(aluno);
		habilitarCorpo = false;
		if(consulta != null){
			aluno = consulta;
		}
	}

}
