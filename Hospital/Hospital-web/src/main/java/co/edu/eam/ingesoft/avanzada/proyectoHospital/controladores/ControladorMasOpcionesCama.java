package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InstalacionesEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;

@Named("controladorMasOpcionesCama")
@ViewScoped
public class ControladorMasOpcionesCama implements Serializable{

	/**
	 * numero de la cama
	 */
	private int numeroCama;

	/**
	 * lista de camas para llenar la tabla
	 */
	private List<Cama>listaCamas;
	
	private List<Cama>listaNueva;

	@EJB
	private InstalacionesEJB instalacionesEJB;

	@PostConstruct
	public void postconstructor() {
		listarCamas();
	}

	public void listarCamas() {
		listaCamas = instalacionesEJB.listaDeCamas();
	}


	/**
	 * elimina una cama de la base de datos
	 * 
	 * @param c
	 *            la cama a eliminar
	 */
	public void eliminarCama(Cama c) {
		instalacionesEJB.eliminarCama(c);
		Messages.addGlobalInfo("Cama eliminada con exito");
		listarCamas();
	}

	public List<Cama> getListaNueva() {
		return listaNueva;
	}

	public void setListaNueva(List<Cama> listaNueva) {
		this.listaNueva = listaNueva;
	}

	/**
	 * obtiene el numero seleccionado y lo almacena en una variable estatica
	 * @param numero
	 */
	public String editarCama(int numero) {
		Cama.setNumeroCama(numero);
		return "/paginas/Administrador/GestionCamas.xhtml?faces-redirect=true";
	}

	public List<Cama> getListaCamas() {
		return listaCamas;
	}

	public void setListaCamas(List<Cama> listaCamas) {
		this.listaCamas = listaCamas;
	}

	public int getNumeroCama() {
		return numeroCama;
	}

	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}

	public InstalacionesEJB getInstalacionesEJB() {
		return instalacionesEJB;
	}

	public void setInstalacionesEJB(InstalacionesEJB instalacionesEJB) {
		this.instalacionesEJB = instalacionesEJB;
	}
	
	
	
	
	
	
}
