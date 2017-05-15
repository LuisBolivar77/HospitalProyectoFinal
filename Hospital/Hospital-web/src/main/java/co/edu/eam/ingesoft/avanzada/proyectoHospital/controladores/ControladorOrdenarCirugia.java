package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.avanzada.negocio.beans.CirugiaEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.EspecializacionEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoCirugia;

@ViewScoped
@Named("controladorOrdenarCir")
public class ControladorOrdenarCirugia implements Serializable{

	
	
	private String anotaciones;
	
	private List<TipoCirugia>tipoCirugia;
	
	private String tipoCirugiaSeleccionada;
	
	private String duracion;
	
	private List<Especializacion>especializacion;
	
	private int especializacionSeleccionada;
	
	@EJB
	private EspecializacionEJB especializacionEJB;
	
	@EJB
	private CirugiaEJB cirugiaEJB;
	
	@PostConstruct
	public void inicializar(){
		//listarComboTipoCirugia();
		//listarComboEspecializacion();
	}

	
	
	public void listarComboTipoCirugia(){
		tipoCirugia = cirugiaEJB.tipoDeCirugia();
	}
	
	public void listarComboEspecializacion(){
		especializacion = especializacionEJB.listar();
	}

	
	
	public void ordenarCirugia(){
		
		
	}
	
	
	
	
	
	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getEspecializacionSeleccionada() {
		return especializacionSeleccionada;
	}


	public void setEspecializacionSeleccionada(int especializacionSeleccionada) {
		this.especializacionSeleccionada = especializacionSeleccionada;
	}

	public String getTipoCirugiaSeleccionada() {
		return tipoCirugiaSeleccionada;
	}


	public void setTipoCirugiaSeleccionada(String tipoCirugiaSeleccionada) {
		this.tipoCirugiaSeleccionada = tipoCirugiaSeleccionada;
	}


	public String getAnotaciones() {
		return anotaciones;
	}


	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}


	public List<TipoCirugia> getTipoCirugia() {
		return tipoCirugia;
	}


	public void setTipoCirugia(List<TipoCirugia> tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}


	public List<Especializacion> getEspecializacion() {
		return especializacion;
	}


	public void setEspecializacion(List<Especializacion> especializacion) {
		this.especializacion = especializacion;
	}
	
	
	
}
