package fatec.pweb.managedbeans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Aluno;
import fatec.pweb.service.AlunoService;

@FacesConverter("converterAluno")
public class AlunoConverter implements Converter {

	private AlunoService servico = new AlunoService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno a = null;
		if (value != null && !value.equals("")) {
			a = servico.getAlunoByNome(value);
		}
		return a;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		} else {
			return ((Aluno) value).getNome();
		}
	}

}
