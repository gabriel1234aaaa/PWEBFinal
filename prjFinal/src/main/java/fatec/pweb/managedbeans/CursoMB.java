package fatec.pweb.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Curso;
import fatec.pweb.model.Turma;
import fatec.pweb.service.CursoService;
import fatec.pweb.service.TurmaService;
import fatec.pweb.util.Util;

@ManagedBean
@ViewScoped
public class CursoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();
	private CursoService servico = new CursoService();
	private TurmaService turmaService = new TurmaService();
	private boolean habilitarCorpo = false;
	private boolean modoInsercao = false;
	private boolean modoAlteracao = false;
	private String focus = "txtSiglaCurso";

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public List<Curso> getCursos() {
		return servico.getCursos();
	}

	public void salvar() {
		curso = servico.salvar(curso);
		if (modoInsercao) {
			Util.addInfo("Inserção", "O curso foi inserido com sucesso!");
		} else {
			Util.addInfo("Alteração", "O curso foi alterado com sucesso!");
		}

		curso = new Curso();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtSiglaCurso";
	}

	public void remover() {
		for(Turma turma : curso.getTurmas()){
			turma.setCurso(null);
			turmaService.salvar(turma);
		}
		servico.remover(curso);
		Util.addInfo("Exclusão", "O curso foi excluído com sucesso!");
		curso = new Curso();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtSiglaCurso";
	}

	public void consultar() {
		Curso consulta = servico.getById(curso);
		habilitarCorpo = true;
		if (consulta != null) {
			curso = consulta;
			modoAlteracao = true;
			modoInsercao = false;
		} else {
			modoAlteracao = false;
			modoInsercao = true;
		}
		focus = "txtNomeCurso";
	}

}
