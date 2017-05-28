package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PacientesEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;

@Named("ControladorPacienteCita")
@SessionScoped
public class ControladorPacienteCita implements Serializable {
	
	private Paciente paciente;
	
	public ControladorPacienteCita() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private PacientesEJB pacienteEJB;
	
	public void buscarPaciente (String identificacion){
		Paciente p = pacienteEJB.buscarPaciente(identificacion);
		if (p!= null){
			paciente = p;
			Faces.setApplicationAttribute("paciente", paciente);
		}
	}
	
	
	
	public void cerrarSesionPaciente(){
		paciente = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
	}
	
	public boolean isPaciente(){
		return paciente != null;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}	
	
}
