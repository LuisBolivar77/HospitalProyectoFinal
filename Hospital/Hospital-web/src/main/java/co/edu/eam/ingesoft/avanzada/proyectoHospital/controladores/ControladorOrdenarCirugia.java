package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@ViewScoped
@Named("controladorOrdenarCir")
public class ControladorOrdenarCirugia implements Serializable{

	
	private Date fechaSeleccionada;
	
	private String quirofanosSeleccionado;
	
	private String tipoCirugiaSeleccionada;
	
	private String cirugiaSeleccionada;
	
	private String anotaciones;
	
	
	@PostConstruct
	public void inicializar(){
		
	}


	public Date getFechaSeleccionada() {
		return fechaSeleccionada;
	}


	public void setFechaSeleccionada(Date fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}


	public String getQuirofanosSeleccionado() {
		return quirofanosSeleccionado;
	}


	public void setQuirofanosSeleccionado(String quirofanosSeleccionado) {
		this.quirofanosSeleccionado = quirofanosSeleccionado;
	}


	public String getTipoCirugiaSeleccionada() {
		return tipoCirugiaSeleccionada;
	}


	public void setTipoCirugiaSeleccionada(String tipoCirugiaSeleccionada) {
		this.tipoCirugiaSeleccionada = tipoCirugiaSeleccionada;
	}


	public String getCirugiaSeleccionada() {
		return cirugiaSeleccionada;
	}


	public void setCirugiaSeleccionada(String cirugiaSeleccionada) {
		this.cirugiaSeleccionada = cirugiaSeleccionada;
	}


	public String getAnotaciones() {
		return anotaciones;
	}


	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	
	
	
}
