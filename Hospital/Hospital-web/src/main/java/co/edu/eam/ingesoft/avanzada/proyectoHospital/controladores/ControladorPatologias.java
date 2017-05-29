package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PatologiaEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;

@ViewScoped
@Named("controladorPatologias")
public class ControladorPatologias implements Serializable{

	/**
	 * Número que identifica una patologia
	 */
	private int numeroPatologia;

	/**
	 * Nombre de la patologia
	 */
	private String nombrePatologia;

	/**
	 * Anotaciones de esa patologia
	 */
	private String anotacionPat;

	@EJB
	private PatologiaEJB patologiaEJB;

	private int estatica;

	@PostConstruct
	public void postconstructor() {
		cargaDatosPatologia();
	}

	/**
	 * Registra una patologia en la base de datos
	 */
	public void registarPatologia() {
		if (numeroPatologia == 0 || nombrePatologia == "" || anotacionPat == "") {
			Messages.addFlashGlobalInfo("Ingrese todos los campos");
		} else {
			Patologia pa = new Patologia();
			pa.setId(numeroPatologia);
			pa.setNombre(nombrePatologia);
			pa.setAnotacion(anotacionPat);
			cancelarRegistro();
			try {
				patologiaEJB.registrarPatologia(pa);
				Messages.addFlashGlobalInfo("Registro exitoso");
			} catch (ExcepcionNegocio e) {
				Messages.addFlashGlobalError(e.getMessage());
			}
		}
	}

	/**
	 * Busca una patologia
	 */
	public void buscarPatologia() {
		if (numeroPatologia == 0) {
			Messages.addFlashGlobalError("ingrese un idenentificador de la patologia");
		} else {
			Patologia p = patologiaEJB.buscarPatologia(numeroPatologia);
			if (p != null) {
				nombrePatologia = p.getNombre();
				anotacionPat = p.getAnotacion();
				Messages.addFlashGlobalInfo("Patologia encontrada");
			} else {
				Messages.addFlashGlobalError("Esta patologia no se encuentra registrada");
			}
		}
	}

	/**
	 * edita una patologia
	 */
	public void editarPatologia() {
		if (numeroPatologia == 0) {
			Messages.addFlashGlobalInfo("busque previa mente una patologia");
		} else {
			Patologia p = patologiaEJB.buscarPatologia(numeroPatologia);
			p.setNombre(nombrePatologia);
			p.setAnotacion(anotacionPat);
			patologiaEJB.editarPatologia(p);
			Messages.addFlashGlobalInfo("Patologia editada correctamente");
		}
	}

	/**
	 * carga los campos previamente
	 */
	public String cargaDatosPatologia() {
		int numero = Patologia.numeroPatologia;
		if (numero == 0) {
			return "/paginas/Administrador/GestionEnfermedades.xhtml?faces-redirect=true";
		} else {
			estatica = Patologia.numeroPatologia;
			Patologia p = patologiaEJB.buscarPatologia(estatica);
			numeroPatologia = p.getId();
			nombrePatologia = p.getNombre();
			anotacionPat = p.getAnotacion();
		}
		return null;
	}

	/**
	 * cancela un registro de un quirofano
	 */
	public void cancelarRegistro() {
		numeroPatologia = 0;
		nombrePatologia = "";
		anotacionPat = "";
	}

	public int getNumeroPatologia() {
		return numeroPatologia;
	}

	public void setNumeroPatologia(int numeroPatologia) {
		this.numeroPatologia = numeroPatologia;
	}

	public String getNombrePatologia() {
		return nombrePatologia;
	}

	public void setNombrePatologia(String nombrePatologia) {
		this.nombrePatologia = nombrePatologia;
	}

	public String getAnotacionPat() {
		return anotacionPat;
	}

	public void setAnotacionPat(String anotacionPat) {
		this.anotacionPat = anotacionPat;
	}

	public PatologiaEJB getPatologiaEJB() {
		return patologiaEJB;
	}

	public void setPatologiaEJB(PatologiaEJB patologiaEJB) {
		this.patologiaEJB = patologiaEJB;
	}

	public int getEstatica() {
		return estatica;
	}

	public void setEstatica(int estatica) {
		this.estatica = estatica;
	}

}
