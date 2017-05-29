package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InstalacionesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;

@ViewScoped
@Named("controladorCamas")
public class ControladorCama implements Serializable {

	/**
	 * Número que identifica la cama
	 */
	private int numeroCama;

	/**
	 * descrpcion de la cama
	 */
	private String descripcionCama;

	/**
	 * estado de la cama
	 */
	private boolean estado = false;

	@EJB
	private InstalacionesEJB instalacionesEJB;

	private int estatica;

	@PostConstruct
	public void postconstructor() {
		cargaDatosCama();
	}

	/**
	 * Registra una cama en la base de datos
	 */
	public void registarCama() {
		if (numeroCama == 0 || descripcionCama == "") {
			Messages.addFlashGlobalInfo("Ingrese todos los campos");
		} else {
			Cama c = new Cama();
			c.setOcupada(estado);
			c.setDescripcion(descripcionCama);
			c.setNumero(numeroCama);
			cancelarRegistro();
			try {
				instalacionesEJB.registrarCama(c);
				Messages.addFlashGlobalInfo("Registro exitoso");
			} catch (ExcepcionNegocio e) {
				Messages.addFlashGlobalError(e.getMessage());
			}
		}
	}

	/**
	 * Busca una cama
	 */
	public void buscarCama() {
		if (numeroCama == 0) {
			Messages.addFlashGlobalInfo("ingrese un numero de cama");
		} else {
			Cama c = instalacionesEJB.buscarCama(numeroCama);
			if (c != null) {
				descripcionCama = c.getDescripcion();
				Messages.addFlashGlobalInfo("Cama encontrada");
			} else {
				Messages.addFlashGlobalError("Esta cama no se encuentra registrada");
			}
		}
	}

	/**
	 * edita una cama
	 */
	public void editarCama() {
		if (numeroCama == 0) {
			Messages.addFlashGlobalInfo("busque previa mente una cama");
		} else {
			Cama c = instalacionesEJB.buscarCama(numeroCama);
			c.setDescripcion(descripcionCama);
			instalacionesEJB.editarCama(c);
			Messages.addFlashGlobalInfo("Cama editada correctamente");
		}
	}

	/**
	 * carga los campos previamente
	 */
	public String cargaDatosCama() {
		int numero = Cama.getNumeroCama();
		if (numero == 0) {
			return "/paginas/Administrador/GestionCamas.xhtml?faces-redirect=true";
		} else {
			estatica = Cama.getNumeroCama();
			Cama cama = instalacionesEJB.buscarCama(estatica);
			numeroCama = cama.getNumero();
			descripcionCama = cama.getDescripcion();

		}
		return null;
	}

	/**
	 * cancela un registro de una cama
	 */
	public void cancelarRegistro() {
		numeroCama = 0;
		descripcionCama = "";
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public String getDescripcionCama() {
		return descripcionCama;
	}

	public void setDescripcionCama(String descripcionCama) {
		this.descripcionCama = descripcionCama;
	}

	public int getEstatica() {
		return estatica;
	}

	public void setEstatica(int estatica) {
		this.estatica = estatica;
	}
}
