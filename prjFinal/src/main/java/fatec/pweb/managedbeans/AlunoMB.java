package fatec.pweb.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Aluno;
import fatec.pweb.model.Instrutor;
import fatec.pweb.service.AlunoService;
import fatec.pweb.service.InstrutorService;
import fatec.pweb.util.Util;

@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aluno aluno = new Aluno();
	private AlunoService servico = new AlunoService();
	private boolean habilitarCorpo = false;
	private boolean modoInsercao = false;
	private boolean modoAlteracao = false;
	private String focus = "txtCpf";

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

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public List<Aluno> getAlunos() {
		return servico.getAlunos();
	}

	public void salvar() {
		aluno = servico.salvar(aluno);
		if (modoInsercao) {
			Util.addInfo("Inserção", "O aluno foi inserido com sucesso!");
		} else {
			Util.addInfo("Alteração", "O aluno foi alterado com sucesso!");
		}

		aluno = new Aluno();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtCpf";
	}

	public void remover() {
		servico.remover(aluno);
		Util.addInfo("Exclusão", "O aluno foi excluído com sucesso!");
		aluno = new Aluno();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
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
				Aluno consulta = servico.getById(aluno);
				habilitarCorpo = true;
				if (consulta != null) {
					aluno = consulta;
					modoAlteracao = true;
					modoInsercao = false;
				} else {
					modoAlteracao = false;
					modoInsercao = true;
				}
				focus = "txtNome";
			}
		} else {
			Util.addErro("CPF Inválido", "Por favor, digite um CPF válido.");
			focus = "txtCpf";
		}
	}

}
