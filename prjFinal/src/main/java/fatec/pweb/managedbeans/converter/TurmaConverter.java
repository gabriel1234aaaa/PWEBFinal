package fatec.pweb.managedbeans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Turma;
import fatec.pweb.service.TurmaService;

@FacesConverter("converterTurma")
public class TurmaConverter implements Converter {

	private TurmaService servico = new TurmaService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Turma t = null;
		if (value != null && !value.equals("")) {
			t = new Turma();
			t.setSiglaTurma(value);
			t = servico.getTurmaById(t);
		}
		return t;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		} else {
			return ((Turma) value).getSiglaTurma();
		}
	}

}
