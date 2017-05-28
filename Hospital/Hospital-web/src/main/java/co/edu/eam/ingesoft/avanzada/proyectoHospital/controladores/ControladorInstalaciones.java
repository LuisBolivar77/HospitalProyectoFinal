package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InstalacionesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

@ViewScoped
@Named("controladorInstalaciones")
public class ControladorInstalaciones implements Serializable {

	/**
	 * Número que identifica en quirófano
	 */
	private int numeroQuirofano;

	/**
	 * Nombre del quirofano
	 */
	private String descQuirofano;

	/**
	 * Quirofano que ha sido buscado
	 */
	private Quirofano quirofanoBuscado;

	@EJB
	private InstalacionesEJB instalacionesEJB;

	private int estatica;

	@PostConstruct
	public void postconstructor() {
		cargaDatosQuirofano();
	}

	/**
	 * Registra un quirófano en la base de datos
	 */
	public void registarQuirofano() {
		if (numeroQuirofano == 0 || descQuirofano == "") {
			Messages.addFlashGlobalInfo("Ingrese todos los campos");
		} else {
			Quirofano q = new Quirofano();
			q.setOcupado(false);
			q.setDescripcion(descQuirofano);
			q.setNumero(numeroQuirofano);
			cancelarRegistro();
			try {
				instalacionesEJB.registrarQuirofano(q);
				Messages.addFlashGlobalInfo("Registro exitoso");
			} catch (ExcepcionNegocio e) {
				Messages.addFlashGlobalError(e.getMessage());
			}
		}
	}

	/**
	 * Busca un quirófano
	 */
	public void buscarQuirofano() {
		Quirofano q = instalacionesEJB.buscarQuirofano(numeroQuirofano);
		if (q != null) {
			numeroQuirofano = q.getNumero();
			descQuirofano = q.getDescripcion();
			Messages.addFlashGlobalInfo("quirofano encontrado");
		} else {
			Messages.addFlashGlobalError("Este quirófano no se encuentra registrado");
		}
	}

	/**
	 * edita un quirofano
	 */
	public void editarQuirofano() {
		if (numeroQuirofano == 0) {
			Messages.addFlashGlobalInfo("busque previa mente un quirofano");
		} else {
			quirofanoBuscado = instalacionesEJB.buscarQuirofano(numeroQuirofano);
			quirofanoBuscado.setNumero(numeroQuirofano);
			quirofanoBuscado.setDescripcion(descQuirofano);
			instalacionesEJB.editarQuirofano(quirofanoBuscado);
			Messages.addFlashGlobalInfo("quirofano editado correctamente");
		}
	}

	/**
	 * carga los campos previamente
	 */
	public String cargaDatosQuirofano() {
		int numero = Quirofano.getNumeroQuirofano();
		if (numero == 0) {
			return "/paginas/Administrador/GestionQuirofano.xhtml?faces-redirect=true";
		} else {
			estatica = Quirofano.getNumeroQuirofano();
			Quirofano q = instalacionesEJB.buscarQuirofano(numero);
			numeroQuirofano = q.getNumero();
			descQuirofano = q.getDescripcion();

		}
		return null;
	}

	/**
	 * cancela un registro de un quirofano
	 */
	public void cancelarRegistro() {
		numeroQuirofano = 0;
		descQuirofano = "";
	}

	/**
	 * @return the numeroQuirofano
	 */
	public int getNumeroQuirofano() {
		return numeroQuirofano;
	}

	/**
	 * @param numeroQuirofano
	 *            the numeroQuirofano to set
	 */
	public void setNumeroQuirofano(int numeroQuirofano) {
		this.numeroQuirofano = numeroQuirofano;
	}

	/**
	 * @return the descQuirofano
	 */
	public String getDescQuirofano() {
		return descQuirofano;
	}

	/**
	 * @param descQuirofano
	 *            the descQuirofano to set
	 */
	public void setDescQuirofano(String descQuirofano) {
		this.descQuirofano = descQuirofano;
	}

	public int getEstatica() {
		return estatica;
	}

	public void setEstatica(int estatica) {
		this.estatica = estatica;
	}

}
