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
	boolean habilitarCorpo = false;
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
	
	public boolean isModoInsercao() {
		return modoInsercao;
	}

	public void setModoInsercao(boolean modoInsercao) {
		this.modoInsercao = modoInsercao;
	}

	public boolean isModoAlteracao() {
		return modoAlteracao;
	}

	public void setModoAlteracao(boolean modoAlteracao) {
		this.modoAlteracao = modoAlteracao;
	}

	public void salvar() {
		aluno = servico.salvar(aluno);
		aluno = new Aluno();
		
		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
	}

	public void remover() {
		servico.remover(aluno);
		
		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		
	}

	public List<Aluno> getAlunos() {
		return servico.getAlunos();
	}
	
	public void consultar(){
		Aluno consulta = servico.getById(aluno);
		habilitarCorpo = true;
		if(consulta != null){
			aluno = consulta;
			modoAlteracao = true;
			modoInsercao = false;
		}else{
			modoAlteracao = false;
			modoInsercao = true;
		}
	}

}
