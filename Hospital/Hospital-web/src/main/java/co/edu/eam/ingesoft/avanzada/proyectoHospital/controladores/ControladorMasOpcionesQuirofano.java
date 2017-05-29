package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.jboss.logging.Message;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InstalacionesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

@Named("controladorMasOpcionesQuirof")
@ViewScoped
public class ControladorMasOpcionesQuirofano implements Serializable {

	/**
	 * numero del quirofano
	 */
	private int numeroQuirofano;

	private int numQuirofano;

	/**
	 * lista de quirofanos para llenar la tabla
	 */
	private List<Quirofano> quirofanos;
	

	@EJB
	private InstalacionesEJB instalacionesEJB;

	@PostConstruct
	public void postconstructor() {
		listarQuirofanos();
	}

	public void listarQuirofanos() {
		quirofanos = instalacionesEJB.listarQuirofanos();
	}

	
	/**
	 * buscaa un quirofano y lo muestra en la tabla
	*/
	public void buscarQuirofano(){
		quirofanos = null;
		quirofanos = instalacionesEJB.quirofanoPorNumero(numeroQuirofano);
		
	} 
	

	/**
	 * elimina un quirofano de la base de datos
	 * 
	 * @param q
	 *            el quirofano a eliminar
	 */
	public void eliminarQuirofano(Quirofano q) {
		instalacionesEJB.eliminarQuirofano(q);
		Messages.addGlobalInfo("Quirofano eliminado con exito");
		listarQuirofanos();
	}

	/**
	 * obtiene el numero seleccionado y lo almacena en una variable estatica
	 * @param numero
	 */
	public String editarQuirofano(int numero) {
		Quirofano.setNumeroQuirofano(numero);
		return "/paginas/Administrador/GestionQuirofano.xhtml?faces-redirect=true";
	}

	public int getNumeroQuirofano() {
		return numeroQuirofano;
	}

	public void setNumeroQuirofano(int numeroQuirofano) {
		this.numeroQuirofano = numeroQuirofano;
	}

	public List<Quirofano> getQuirofanos() {
		return quirofanos;
	}

	public void setQuirofanos(List<Quirofano> quirofanos) {
		this.quirofanos = quirofanos;
	}

	public int getNumQuirofano() {
		return numQuirofano;
	}

	public void setNumQuirofano(int numQuirofano) {
		this.numQuirofano = numQuirofano;
	}

	public InstalacionesEJB getInstalacionesEJB() {
		return instalacionesEJB;
	}

	public void setInstalacionesEJB(InstalacionesEJB instalacionesEJB) {
		this.instalacionesEJB = instalacionesEJB;
	}
	
	
}
