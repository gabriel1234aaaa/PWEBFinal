package fatec.pweb.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util implements Serializable {

	private static final long serialVersionUID = 1L;

	public static boolean validarCPF(String cpf) {
		if (cpf.length() < 11) {
			return false;
		} else {
			int primeiroDigito = 0;
			for (int i = 0; i < 9; i++) {
				primeiroDigito += (cpf.charAt(i) - '0') * (i + 1);
			}
			primeiroDigito = primeiroDigito % 11;
			if (primeiroDigito == 10) {
				primeiroDigito = 0;
			}
			if (primeiroDigito == cpf.charAt(9) - '0') {
				int segundoDigito = 0;
				for (int i = 0; i < 10; i++) {
					segundoDigito += (cpf.charAt(i) - '0') * (11 - i);
				}
				segundoDigito = (segundoDigito * 10) % 11;
				if (segundoDigito == 10) {
					segundoDigito = 0;
				}
				if (segundoDigito == cpf.charAt(10) - '0') {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static void addInfo(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void addErro(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
