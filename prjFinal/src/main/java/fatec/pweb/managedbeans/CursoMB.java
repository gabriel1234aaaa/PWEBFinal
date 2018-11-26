package fatec.pweb.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fatec.pweb.model.Curso;
import fatec.pweb.service.CursoService;

@ManagedBean
@ViewScoped
public class CursoMB {
	Curso curso = new Curso();
	CursoService servico = new CursoService();
	List<Curso> cursos;
	boolean habilitarCorpo = false;
	boolean modoInsercao = false;
	boolean modoAlteracao = false;

	/*private Curso formToObject() {
		String cpf = txtCPF.getText().replaceAll("[^0-9]", "");
		Aluno aluno = new Aluno(txtNome.getText(), cpf);
		aluno.setDataNasc(txtDataNascto.getText().replaceAll("[^0-9]", ""));
		aluno.setSexo(cmbSexo.getSelectedItem().equals("Feminino") ? "F" : "M");
		aluno.setEstadoCivil(cmbEstadoCivil.getSelectedItem().toString().replace("(a)", ""));
		aluno.setEscolaridade(cmbEscolaridade.getSelectedItem().toString());
		aluno.setEndereco(txtEndereco.getText());
		aluno.setNumero(Integer.parseInt(txtN.getText()));
		aluno.setBairro(txtBairro.getText());
		aluno.setCEP(txtCEP.getText().replaceAll("[^0-9]", ""));
		aluno.setCidade(txtCidade.getText());
		aluno.setEstado(cmbEstado.getSelectedItem().toString());
		aluno.setTelefone(txtTelRes.getText().replaceAll("[^0-9]", ""));
		aluno.setRG(txtRG.getText().replaceAll("[^0-9]", ""));
		aluno.setCelular(txtCelular.getText().replaceAll("[^0-9]", ""));
		aluno.setEmail(txtEmail.getText());

		return aluno;
	}*/

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

	public void salvar() {
		curso = servico.salvar(curso);
		if (cursos != null) {
			cursos.add(curso);
		}
		curso = new Curso();
	}

	public void remover(Curso curso) {
		servico.remover(curso);
		cursos.remove(curso);
	}

	public List<Curso> getCursos() {
		if (cursos == null) {
			cursos = servico.getCursos();
		}

		return cursos;
	}

	public void consultar() {
		Curso consulta = servico.getById(curso);
		habilitarCorpo = true;
		modoInsercao = true;
		modoAlteracao = true;
		if (consulta != null) {
			curso = consulta;
			
		}
	}

	public void inserir() {
	
	}
	
	public void alterar() {
		
	}
	
	
}
