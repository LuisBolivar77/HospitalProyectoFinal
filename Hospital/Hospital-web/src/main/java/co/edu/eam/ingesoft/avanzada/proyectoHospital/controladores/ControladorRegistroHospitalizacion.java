package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.avanzada.negocio.beans.Insumos_ProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;

@ViewScoped
@Named("controladorHospitalizacion")
public class ControladorRegistroHospitalizacion implements Serializable {

	private List<Cita> citas;

	private String citaSeleccionada;

	private Date fechaEntrada;

	private Date fechaSalida;

	private List<Cama> cama;
	
	private String camaSeleccionada;

	private String anotaciones;

	@EJB
	private Insumos_ProcedimientosEJB insumosEJB;
	
	
	
	@PostConstruct
	public void inicializar() {

	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getCamaSeleccionada() {
		return camaSeleccionada;
	}

	public void setCamaSeleccionada(String camaSeleccionada) {
		this.camaSeleccionada = camaSeleccionada;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public String getCitaSeleccionada() {
		return citaSeleccionada;
	}

	public void setCitaSeleccionada(String citaSeleccionada) {
		this.citaSeleccionada = citaSeleccionada;
	}

}
