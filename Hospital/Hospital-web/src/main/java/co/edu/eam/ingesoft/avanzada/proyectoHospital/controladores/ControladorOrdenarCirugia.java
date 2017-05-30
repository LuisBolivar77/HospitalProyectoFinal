package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.CirugiaEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.EspecializacionEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Especializacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoCirugia;

@ViewScoped
@Named("controladorOrdenarCir")
public class ControladorOrdenarCirugia implements Serializable{

	private int codigo;
	
	private String anotaciones;
	
	private List<TipoCirugia>tipoCirugia;
	
	private int tipoCirugiaSeleccionada;
	
	private String duracion;
	
	private List<Especializacion>especializacion;
	
	private int especializacionSeleccionada;
	
	@EJB
	private EspecializacionEJB especializacionEJB;
	
	@EJB
	private CirugiaEJB cirugiaEJB;
	
	@EJB
	private InsumosProcedimientosEJB procedimientosEJB;
	
	@PostConstruct
	public void inicializar(){
		listarComboTipoCirugia();
		listarComboEspecializacion();
	}

	
	
	public void listarComboTipoCirugia(){
		tipoCirugia = cirugiaEJB.tipoDeCirugia();
	}
	
	public void listarComboEspecializacion(){
		especializacion = especializacionEJB.listar();
	}

	
	
	public void ordenarCirugia(){
		TipoCirugia tipo = procedimientosEJB.buscarTipoCirugia(tipoCirugiaSeleccionada);
		Especializacion esp = procedimientosEJB.buscarEspecializacion(especializacionSeleccionada);
		Cirugia c = new Cirugia(codigo, anotaciones, tipo, esp);
		procedimientosEJB.crearCirugia(c);
		Messages.addFlashGlobalInfo("Se ha registrado exitosamente");
	}
	
	
	
	
	
	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public int getTipoCirugiaSeleccionada() {
		return tipoCirugiaSeleccionada;
	}


	public void setTipoCirugiaSeleccionada(int tipoCirugiaSeleccionada) {
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
