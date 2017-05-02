package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
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

	/**
	 * Registra un quirófano en la base de datos
	 */
	public void registarQuirofano() {
		Quirofano q = new Quirofano();
		q.setOcupado(false);
		q.setDescripcion(descQuirofano);
		q.setId(numeroQuirofano);
		try {
			instalacionesEJB.registrarQuirofano(q);
			Messages.addFlashGlobalInfo("Registro exitoso");
		} catch (ExcepcionNegocio e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	/**
	 * Busca un quirófano
	 */
	public void buscarQuirofano() {
		Quirofano q = instalacionesEJB.buscarQuirofano(numeroQuirofano);
		if (q != null) {
			quirofanoBuscado = q;
			descQuirofano = q.getDescripcion();
		} else {
			Messages.addFlashGlobalError("Este quirófano no se encuentra registrado");
		}
	}

	/**
	 * Edita un quirófano
	 */
	public void editarQuirofano() {
		if (quirofanoBuscado == null) {
			Messages.addFlashGlobalError("Debe buscar antes de editar");
		} else {
			instalacionesEJB.editarQuirofano(quirofanoBuscado);
		}
	}

	/**
	 * Elimina un quirófano
	 */
	public void eliminarQuirofano() {
		if (quirofanoBuscado == null){
			Messages.addFlashGlobalError("Debe buscar antes de eliminar");
		} else {
			instalacionesEJB.eliminarQuirofano(quirofanoBuscado);
		}
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

}
