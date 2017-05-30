package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PacientesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PatologiaEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.FechaCita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PatologiaPaciente;

@ViewScoped
@Named("controladorOrdenPatologia")
public class ControladorOrdenPatologia implements Serializable {

	private List<Patologia> listaPatologias;
	
	private String anotaciones;
	
	private int patologiaSeleccionada;
	
	private List<Patologia> listaNueva;
	
	@EJB
	private PacientesEJB pacienteEJB;
	
	@EJB
	private PatologiaEJB patologiaEJB;
	
	@PostConstruct
	public void inicializar(){
		listaPatologias = patologiaEJB.listarPatologias();
	}
	
	public void registrarPatologia (){
		if (anotaciones == ""){
			Messages.addFlashGlobalError("Debe ingresar las anotaciones");
		} else {
			
			Cita cit = new Cita();
			cit.setAnotaciones(anotaciones);
			FechaCita fecha = new FechaCita();
			fecha.setFecha(new Date());
			fecha.setOcupado(true);
			cit.setFecha(fecha);
			Paciente p = pacienteEJB.buscarPaciente(Paciente.getIdPaciente());
			cit.setPaciente(p);
			
			PatologiaPaciente pp = new PatologiaPaciente();
			pp.setCita(cit);
			Patologia pat = patologiaEJB.buscarPatologia(patologiaSeleccionada);
			pp.setPatologia(pat);	
			patologiaEJB.registrarPatologiaPaciente(pp);
			Messages.addFlashGlobalInfo("Se ha registrado la patología al paciente");
		}
	}

	/**
	 * @return the listaPatologias
	 */
	public List<Patologia> getListaPatologias() {
		return listaPatologias;
	}

	/**
	 * @param listaPatologias the listaPatologias to set
	 */
	public void setListaPatologias(List<Patologia> listaPatologias) {
		this.listaPatologias = listaPatologias;
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

	/**
	 * @return the listaNueva
	 */
	public List<Patologia> getListaNueva() {
		return listaNueva;
	}

	/**
	 * @param listaNueva the listaNueva to set
	 */
	public void setListaNueva(List<Patologia> listaNueva) {
		this.listaNueva = listaNueva;
	}

	/**
	 * @return the patologiaSeleccionada
	 */
	public int getPatologiaSeleccionada() {
		return patologiaSeleccionada;
	}

	/**
	 * @param patologiaSeleccionada the patologiaSeleccionada to set
	 */
	public void setPatologiaSeleccionada(int patologiaSeleccionada) {
		this.patologiaSeleccionada = patologiaSeleccionada;
	}
	
	
	
}
