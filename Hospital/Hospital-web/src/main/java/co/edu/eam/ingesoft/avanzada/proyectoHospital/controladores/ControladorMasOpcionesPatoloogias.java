package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PatologiaEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;

@ViewScoped
@Named("controladorMasOpcionesPatol")
public class ControladorMasOpcionesPatoloogias implements Serializable{

	
	/**
	 * numero de la patologia
	 */
	private int numeroPatologia;

	/**
	 * lista de patologias para llenar la tabla
	 */
	private List<Patologia> listaPatologias;
	

	@EJB
	private PatologiaEJB patologiaEJB;

	@PostConstruct
	public void postconstructor() {
		listarPatologias();
	}

	public void listarPatologias() {
		listaPatologias = patologiaEJB.listarPatologias();
	}

	
	/**
	 * busca una patologia y lo muestra en la tabla

	public void buscarPatologia(){
		listaPatologias = patologiaEJB.listarPatologiaPorNumero(numeroPatologia);
	} 	*/
	

	/**
	 * elimina una Patologia de la base de datos
	 * 
	 * @param p
	 *            la patologia a eliminar
	 */
	public void eliminarPatologia(Patologia p) {
		patologiaEJB.eliminarPatologia(p);
		Messages.addGlobalInfo("Patologia eliminada con exito");
		listarPatologias();
	}

	/**
	 * obtiene el numero seleccionado y lo almacena en una variable estatica
	 * @param numero
	 */
	public String editarPatologia(int numero) {
		Patologia.setNumeroPatologia(numero);
		return "/paginas/Administrador/GestionEnfermedades.xhtml?faces-redirect=true";
	}

	public int getNumeroPatologia() {
		return numeroPatologia;
	}

	public void setNumeroPatologia(int numeroPatologia) {
		this.numeroPatologia = numeroPatologia;
	}

	public List<Patologia> getListaPatologias() {
		return listaPatologias;
	}

	public void setListaPatologias(List<Patologia> listaPatologias) {
		this.listaPatologias = listaPatologias;
	}

	public PatologiaEJB getPatologiaEJB() {
		return patologiaEJB;
	}

	public void setPatologiaEJB(PatologiaEJB patologiaEJB) {
		this.patologiaEJB = patologiaEJB;
	}

	
	
	
}
