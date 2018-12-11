package fatec.pweb.managedbeans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.APrazo;
import fatec.pweb.model.AVista;
import fatec.pweb.model.Aluno;
import fatec.pweb.model.Curso;
import fatec.pweb.model.Instrutor;
import fatec.pweb.model.Matricula;
import fatec.pweb.model.Turma;
import fatec.pweb.service.APrazoService;
import fatec.pweb.service.AVistaService;
import fatec.pweb.service.AlunoService;
import fatec.pweb.service.CursoService;
import fatec.pweb.service.InstrutorService;
import fatec.pweb.service.MatriculaService;
import fatec.pweb.service.TurmaService;
import fatec.pweb.util.Util;

@ManagedBean
@ViewScoped
public class MatriculaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Curso curso = new Curso();
	private CursoService cursoService = new CursoService();
	private List<Curso> cursos;
	private Turma turma = new Turma();
	private TurmaService turmaService = new TurmaService();
	private List<Turma> turmas;
	private Aluno aluno = new Aluno();
	private AlunoService alunoService = new AlunoService();
	private Matricula matricula = new Matricula();
	private MatriculaService matriculaService = new MatriculaService();
	private APrazo aPrazo = new APrazo();
	private APrazoService aPrazoService = new APrazoService();
	private AVista aVista = new AVista();
	private AVistaService aVistaService = new AVistaService();

	private String focus = "txtCpf";
	private String selecionado;
	private String valorCurso;

	private boolean habilitarData = false;
	private boolean habilitarCorpo = false;
	private boolean modoInsercao = false;
	private boolean modoAlteracao = false;
	private boolean compoAprazo = false;
	private boolean compoAvista = false;

	public MatriculaMB() {
		cursos = cursoService.getCursos();
		if (cursos.size() > 0) {
			curso = cursos.get(0);
			turmas = curso.getTurmas();
			if (turmas.size() > 0) {
				turma = turmas.get(0);
			}
		}
	}

	public void trocaCurso() {
		turmas = turmaService.getTurmasByCurso(curso);
		if (turmas.size() > 0)
			turma = turmas.get(0);
		else
			turma = null;
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

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

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

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public void salvar() {
		AVista tempAVista = null;
		APrazo tempAPrazo = null;

		if (selecionado.equals("Aprazo")) {
			if (matricula.getAvista() != null) {
				tempAVista = matricula.getAvista();
			}
			aPrazo = aPrazoService.salvar(aPrazo);
			aVista = null;
		} else if (selecionado.equals("Avista")) {
			if (matricula.getAprazo() != null) {
				tempAPrazo = matricula.getAprazo();
			}
			aVista = aVistaService.salvar(aVista);
			aPrazo = null;
		}

		matricula.setAprazo(aPrazo);
		matricula.setAvista(aVista);
		matricula.setAluno(aluno);
		matricula.setTurma(turma);

		matricula = matriculaService.salvar(matricula);

		if (tempAVista != null)
			aVistaService.remover(tempAVista);
		if (tempAPrazo != null)
			aPrazoService.remover(tempAPrazo);
		if (modoInsercao) {
			Util.addInfo("Inserção", "A matrícula foi inserida com sucesso!");
		} else {
			Util.addInfo("Alteração", "A matrícula foi alterada com sucesso!");
		}

		aVista = new AVista();
		aPrazo = new APrazo();
		matricula = new Matricula();
		aluno = new Aluno();

		compoAprazo = false;
		compoAvista = false;
		habilitarData = false;
		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		selecionado = "AVista";
		focus = "txtCpf";
	}

	public void remover() {
		if (matricula.getAprazo() != null) {
			aPrazo = matricula.getAprazo();
			aVista = null;
		} else {
			aVista = matricula.getAvista();
			aPrazo = null;
		}

		matriculaService.remover(matricula);

		if (aPrazo != null)
			aPrazoService.remover(aPrazo);
		if (aVista != null)
			aVistaService.remover(aVista);

		Util.addInfo("Exclusão", "A matrícula foi excluída com sucesso!");

		aVista = new AVista();
		aPrazo = new APrazo();
		matricula = new Matricula();
		aluno = new Aluno();

		compoAprazo = false;
		compoAvista = false;
		habilitarData = false;
		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		selecionado = "AVista";
		focus = "txtCpf";
	}

	public void consultar() {
		if (Util.validarCPF(aluno.getCpf().replaceAll("[^0-9]", ""))) {
			InstrutorService instrutorService = new InstrutorService();
			Instrutor instrutor = new Instrutor();
			instrutor.setCpf(aluno.getCpf());
			instrutor = instrutorService.getById(instrutor);

			if (instrutor != null) {
				Util.addErro("CPF Inválido", "O CPF já está sendo utilizado por um instrutor.");
				focus = "txtCpf";
			} else {
				Aluno temp = alunoService.getById(aluno);
				if (temp != null) {
					aluno = temp;
					habilitarCorpo = true;
					Matricula consultaMatricula = matriculaService.getMatriculaByIds(aluno, turma);

					if (consultaMatricula != null) {
						matricula = consultaMatricula;
						modoAlteracao = true;
						modoInsercao = false;
						habilitarData = false;
						if (matricula.getAprazo() != null) {
							selecionado = "Aprazo";
							focus = "txtQtdMens";
						} else {
							selecionado = "Avista";
							focus = "txtAgencia";
						}
					} else {
						selecionado = "Avista";
						modoAlteracao = false;
						modoInsercao = true;
						habilitarData = true;
						focus = "txtDtMatricula";
					}
					selecionaRadio();
				} else {
					Util.addErro("404 - Não Encontrado", "Aluno não encontrado nos registros.");
					focus = "txtCpf";
				}
			}
		} else {
			Util.addErro("CPF Inválido", "Por favor, digite um CPF válido.");
			focus = "txtCpf";
		}
	}

	public boolean isCompoAprazo() {
		return compoAprazo;
	}

	public void setCompoAprazo(boolean compoAprazo) {
		this.compoAprazo = compoAprazo;
	}

	public boolean isCompoAvista() {
		return compoAvista;
	}

	public void setCompoAvista(boolean compoAvista) {
		this.compoAvista = compoAvista;
	}

	public String getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	public boolean isHabilitarData() {
		return habilitarData;
	}

	public void setHabilitarData(boolean habilitarData) {
		this.habilitarData = habilitarData;
	}

	public APrazo getaPrazo() {
		return aPrazo;
	}

	public void setaPrazo(APrazo aPrazo) {
		this.aPrazo = aPrazo;
	}

	public AVista getaVista() {
		return aVista;
	}

	public void setaVista(AVista aVista) {
		this.aVista = aVista;
	}

	public String getValorCurso() {
		if(curso == null) {
			valorCurso = "Selecione um curso.";
		}else {
			DecimalFormat df = new DecimalFormat("R$ #,##0.00");
			valorCurso = df.format(curso.getValor());
		}
		return valorCurso;
	}

	public void setValorCurso(String valorCurso) {
		this.valorCurso = valorCurso;
	}

	public void selecionaRadio() {
		if (selecionado.equals("Aprazo")) {
			if (matricula.getAprazo() != null)
				aPrazo = aPrazoService.getById(matricula.getAprazo());
			compoAprazo = true;
			compoAvista = false;
			aVista = new AVista();
		} else {
			if (matricula.getAvista() != null)
				aVista = aVistaService.getById(matricula.getAvista());
			compoAvista = true;
			compoAprazo = false;
			aPrazo = new APrazo();
		}
	}
}
