package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@ViewScoped
@Named("controladorResumenMedico")
public class ControladorResumenMedico implements Serializable{

	
	private String identificacion;
	
	private String nombre;
	
	private Date fechaSalida;
	
	private Date nuevaFechaSalida;
	
	@PostConstruct
	public void inicializar() {
		
	}

	
	/**
	 * metodo que permite dar de alta a un usuario hospitalizado
	 */
	public void darDeAlta(){
		
	
	}
	
	/**
	 * metodo que permite editar la fecha de hopitalizacion de un paciente
	 */
	public void editarHospitalizacion(){
		
	}
	
	
	
	
	
	
	
	
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getNuevaFechaSalida() {
		return nuevaFechaSalida;
	}

	public void setNuevaFechaSalida(Date nuevaFechaSalida) {
		this.nuevaFechaSalida = nuevaFechaSalida;
	}
	
	
	
	
	
}
