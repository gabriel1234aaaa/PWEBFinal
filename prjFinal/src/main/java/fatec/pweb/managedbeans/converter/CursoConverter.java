package fatec.pweb.managedbeans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Curso;
import fatec.pweb.service.CursoService;

@FacesConverter("converterCurso")
public class CursoConverter implements Converter {

	private CursoService servico = new CursoService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Curso c = null;
		if (value != null && !value.equals("")) {
			c = new Curso();
			c.setSigla(value);
			c = servico.getById(c);
		}
		return c;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		} else {
			return ((Curso) value).getSigla();
		}
	}

}
