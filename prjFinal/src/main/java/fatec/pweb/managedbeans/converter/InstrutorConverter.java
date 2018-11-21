package fatec.pweb.managedbeans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fatec.pweb.model.Instrutor;
import fatec.pweb.service.InstrutorService;

@FacesConverter("converterInstrutor")
public class InstrutorConverter implements Converter {

	private InstrutorService servico = new InstrutorService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Instrutor i = null;
		if (value != null && !value.equals("")) {
			i = servico.getInstrutorByNome(value);
		}
		return i;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
			return null;
		} else {
			return ((Instrutor) value).getNome();
		}
	}

}
