package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;

@ViewScoped
@Named("controladorMasOpcionesInsumos")
public class ControladorMasOpcionesInsumos implements Serializable {

	private String descripcion;

	private List<Medicamento> listaNueva;
	
	private List<Medicamento> listaMedicamentos;

	@EJB
	InsumosProcedimientosEJB insumosEJB;

	@PostConstruct
	public void postConstruct() {
		listarTabla();
	}

	public void listarTabla() {
		listaMedicamentos = insumosEJB.listarMedicamentos();
	}

	/**
	 * elimina un medicamento
	 * 
	 * @param m
	 */
	public void eliminarMedicamento(Medicamento m) {
		insumosEJB.eliminar(m);
		listarTabla();
		Messages.addGlobalInfo("Quirofano eliminado con exito");
	}

	/**
	 * obtiene el numero seleccionado y lo almacena en una variable estatica
	 * 
	 * @param numero
	 */
	public String editarMedicamento(int cod) {
		Medicamento.setCodigomedicamento(cod);
		return "/paginas/Administrador/RegistroInsumos.xhtml?faces-redirect=true";
	}

	public void buscarInsumos() {

	}

	public List<Medicamento> getListaNueva() {
		return listaNueva;
	}

	public void setListaNueva(List<Medicamento> listaNueva) {
		this.listaNueva = listaNueva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

}
