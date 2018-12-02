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
public class TurmaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Turma turma = new Turma();
	private Curso curso;
	private List<Curso> cursos;
	private TurmaService turmaService = new TurmaService();
	private CursoService cursoService = new CursoService();
	private boolean habilitarCorpo = false;
	private boolean modoInsercao = false;
	private boolean modoAlteracao = false;
	private String focus = "txtSigla";

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

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

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
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

	public List<Turma> getTurmas() {
		return turmaService.getTurmas();
	}

	public List<Curso> getCursos() {
		if (cursos == null)
			cursos = cursoService.getCursos();

		return cursos;
	}

	public void salvar() {
		turma.setCurso(curso);
		curso.addTurma(turma);

		turmaService.salvar(turma);
		cursoService.salvar(curso);
		if (modoInsercao) {
			Util.addInfo("Inserção", "A turma foi inserida com sucesso!");
		} else {
			Util.addInfo("Alteração", "A turma foi alterada com sucesso!");
		}

		turma = new Turma();
		curso = null;

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtSigla";
	}

	public void remover() {
		turmaService.remover(turma);
		Util.addInfo("Exclusão", "A turma foi excluída com sucesso!");
		turma = new Turma();
		curso = null;

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtSigla";
	}

	public void consultar() {
		Turma consulta = turmaService.getById(turma);
		habilitarCorpo = true;
		if (consulta != null) {
			turma = consulta;
			modoAlteracao = true;
			modoInsercao = false;
			int indice = cursos.indexOf(turma.getCurso());
			Curso temp = cursos.get(0);
			cursos.set(0, turma.getCurso());
			cursos.set(indice, temp);
			curso = turma.getCurso();
		} else {
			modoAlteracao = false;
			modoInsercao = true;
		}
		focus = "cbxCurso";
	}

}
