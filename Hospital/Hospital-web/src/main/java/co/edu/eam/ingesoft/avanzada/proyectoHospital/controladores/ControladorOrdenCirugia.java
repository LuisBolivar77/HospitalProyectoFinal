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
import co.edu.eam.ingesoft.avanzada.negocio.beans.PacientesEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.CirugiaRealizar;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.FechaCita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Quirofano;

@ViewScoped
@Named("controladorOrdenCirugia")
public class ControladorOrdenCirugia implements Serializable {

	private int cirugiaSeleccionada;
	
	private List<Quirofano> quirofanos;
	
	private List<Cirugia> listaNueva;
	
	private int quirofanoSeleccionado;
	
	private List<Cirugia> listaCirugias;
	
	private String anotaciones;
	
	@EJB
	private CirugiaEJB cirugiaEJB;
	
	@EJB
	private PacientesEJB pacienteEJB;
	
	@PostConstruct
	public void inicializar(){
		quirofanos = cirugiaEJB.quirofanosDisponibles();
		listaCirugias = cirugiaEJB.listarCirugias();
	}
	
	public void ordenarCirugia(Cirugia c){
		Cita cit = new Cita();
		cit.setAnotaciones(anotaciones);
		FechaCita fecha = new FechaCita();
		fecha.setFecha(new Date());
		fecha.setOcupado(true);
		cit.setFecha(fecha);
		Paciente p = pacienteEJB.buscarPaciente(Paciente.getIdPaciente());
		cit.setPaciente(p);
		
		Quirofano q = cirugiaEJB.buscarQuirofano(quirofanoSeleccionado);
		
		CirugiaRealizar cr = new CirugiaRealizar();
		cr.setCirugia(c);
		cr.setCita(cit);
		cr.setFechaHora(new Date());
		cr.setQuirofano(q);
		
		cirugiaEJB.registrarCirugiaRealizar(cr);
		Messages.addFlashGlobalInfo("Se ha registrado exitosamente");
	}

	/**
	 * @return the cirugiaSeleccionada
	 */
	public int getCirugiaSeleccionada() {
		return cirugiaSeleccionada;
	}

	/**
	 * @param cirugiaSeleccionada the cirugiaSeleccionada to set
	 */
	public void setCirugiaSeleccionada(int cirugiaSeleccionada) {
		this.cirugiaSeleccionada = cirugiaSeleccionada;
	}

	/**
	 * @return the quirofanos
	 */
	public List<Quirofano> getQuirofanos() {
		return quirofanos;
	}

	/**
	 * @return the listaNueva
	 */
	public List<Cirugia> getListaNueva() {
		return listaNueva;
	}

	/**
	 * @param listaNueva the listaNueva to set
	 */
	public void setListaNueva(List<Cirugia> listaNueva) {
		this.listaNueva = listaNueva;
	}

	/**
	 * @param quirofanos the quirofanos to set
	 */
	public void setQuirofanos(List<Quirofano> quirofanos) {
		this.quirofanos = quirofanos;
	}

	/**
	 * @return the quirofanoSeleccionado
	 */
	public int getQuirofanoSeleccionado() {
		return quirofanoSeleccionado;
	}

	/**
	 * @param quirofanoSeleccionado the quirofanoSeleccionado to set
	 */
	public void setQuirofanoSeleccionado(int quirofanoSeleccionado) {
		this.quirofanoSeleccionado = quirofanoSeleccionado;
	}

	/**
	 * @return the listaCirugias
	 */
	public List<Cirugia> getListaCirugias() {
		return listaCirugias;
	}

	/**
	 * @param listaCirugias the listaCirugias to set
	 */
	public void setListaCirugias(List<Cirugia> listaCirugias) {
		this.listaCirugias = listaCirugias;
	}

	/**
	 * @return the anotaciones
	 */
	public String getAnotaciones() {
		return anotaciones;
	}

	/**
	 * @param anotaciones the anotaciones to set
	 */
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	
	
	
}
