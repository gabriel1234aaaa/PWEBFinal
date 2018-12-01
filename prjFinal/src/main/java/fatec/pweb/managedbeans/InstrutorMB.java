package fatec.pweb.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Instrutor;
import fatec.pweb.service.InstrutorService;
import fatec.pweb.util.Util;

@ManagedBean
@ViewScoped
public class InstrutorMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instrutor instrutor = new Instrutor();
	private InstrutorService servico = new InstrutorService();
	private boolean habilitarCorpo = false;
	private boolean modoInsercao = false;
	private boolean modoAlteracao = false;
	private String focus = "txtCpf";

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
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

	public List<Instrutor> getInstrutors() {
		return servico.getInstrutores();
	}

	public void salvar() {
		instrutor = servico.salvar(instrutor);
		if (modoInsercao) {
			Util.addInfo("Inserção", "O instrutor foi inserido com sucesso!");
		} else {
			Util.addInfo("Alteração", "O instrutor foi alterado com sucesso!");
		}

		instrutor = new Instrutor();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtCpf";
	}

	public void remover() {
		servico.remover(instrutor);
		Util.addInfo("Exclusão", "O instrutor foi excluído com sucesso!");
		instrutor = new Instrutor();

		habilitarCorpo = false;
		modoAlteracao = false;
		modoInsercao = false;
		focus = "txtCpf";
	}

	public void consultar() {
		Instrutor consulta = servico.getById(instrutor);
		habilitarCorpo = true;
		if (consulta != null) {
			instrutor = consulta;
			modoAlteracao = true;
			modoInsercao = false;
		} else {
			modoAlteracao = false;
			modoInsercao = true;
		}
		focus = "txtNome";
	}

}
