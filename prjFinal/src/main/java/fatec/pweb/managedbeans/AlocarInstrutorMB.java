package fatec.pweb.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Curso;
import fatec.pweb.model.Instrutor;
import fatec.pweb.model.Turma;
import fatec.pweb.service.CursoService;
import fatec.pweb.service.InstrutorService;
import fatec.pweb.service.TurmaService;
import fatec.pweb.util.Util;

@ManagedBean
@ViewScoped
public class AlocarInstrutorMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();
	private CursoService cursoService = new CursoService();
	private List<Curso> cursos;
	private Turma turma = new Turma();
	private TurmaService turmaService = new TurmaService();
	private List<Turma> turmas;
	private Instrutor instrutor = new Instrutor();
	private InstrutorService instrutorService = new InstrutorService();
	private List<Instrutor> instrutores;
	private String situacao;
	private boolean alocado = false;

	public AlocarInstrutorMB() {
		cursos = cursoService.getCursos();
		turmas = cursos.get(0).getTurmas();
		instrutores = instrutorService.getInstrutores();

		if (turmas.size() > 0 && turmas.get(0).getInstrutor() != null) {
			int indice = instrutores.indexOf(turmas.get(0).getInstrutor());
			Instrutor temp = instrutores.get(0);
			instrutores.set(0, turmas.get(0).getInstrutor());
			instrutores.set(indice, temp);
			situacao = "Alocada";
			alocado = true;
		} else {
			situacao = "Liberada";
			alocado = false;
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public boolean isAlocado() {
		return alocado;
	}

	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}

	public void trocaCurso() {
		turmas = turmaService.getTurmasByCurso(curso);

		if (turmas.size() > 0 && turmas.get(0).getInstrutor() != null) {
			int indice = instrutores.indexOf(turmas.get(0).getInstrutor());
			Instrutor temp = instrutores.get(0);
			instrutores.set(0, turmas.get(0).getInstrutor());
			instrutores.set(indice, temp);
			situacao = "Alocada";
			alocado = true;
		} else {
			situacao = "Liberada";
			alocado = false;
		}
	}

	public void trocaTurma() {
		if (turma.getInstrutor() != null) {
			int indice = instrutores.indexOf(turma.getInstrutor());
			Instrutor temp = instrutores.get(0);
			instrutores.set(0, turma.getInstrutor());
			instrutores.set(indice, temp);
			situacao = "Alocada";
			alocado = true;
		} else {
			situacao = "Liberada";
			alocado = false;
		}
	}

	public void trocaInstrutor() {
		if (instrutor.equals(turma.getInstrutor())) {
			situacao = "Alocada";
			alocado = true;
		} else {
			situacao = "Liberada";
			alocado = false;
		}
	}

	public void alocar() {
		if(turma.getInstrutor() != null) {
			turma.getInstrutor().remTurma(turma);
			instrutorService.salvar(turma.getInstrutor());
		}
		turma.setInstrutor(instrutor);
		instrutor.addTurma(turma);

		turmaService.salvar(turma);
		instrutorService.salvar(instrutor);

		situacao = "Alocada";
		alocado = true;
		Util.addInfo("Alocação", "O instrutor foi alocado para a turma com sucesso!");
	}

	public void liberar() {
		turma.setInstrutor(null);
		instrutor.remTurma(turma);

		turmaService.salvar(turma);
		instrutorService.salvar(instrutor);

		situacao = "Liberada";
		alocado = false;
		Util.addInfo("Liberação", "O instrutor foi liberado da turma com sucesso!");
	}

}
