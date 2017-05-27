package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.avanzada.negocio.beans.PacientesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.UsuarioEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@Named("controladorSolicitudes")
@ViewScoped
public class ControladorSollicitudes implements Serializable {
	
	private List<Paciente> listaSolicitudes;
	
	@EJB
	private PacientesEJB pacienteEJB;
	
	public void cargarSolicitudesUsuarios (){
		listaSolicitudes = pacienteEJB.solicitudesUsuarios();
	}
	
	@PostConstruct
	public void postConstruct(){
		cargarSolicitudesUsuarios();
	}
	
	/**
	 * Habilita a un paciente para que pueda ingresar a la aplicación
	 * @param user Paciente
	 */
	public void habilitarUsuario(Paciente user){
		user.setUsuarioAsignado(true);
		pacienteEJB.editar(user);
	}

	/**
	 * @return the listaSolicitudes
	 */
	public List<Paciente> getListaSolicitudes() {
		return listaSolicitudes;
	}

	/**
	 * @param listaSolicitudes the listaSolicitudes to set
	 */
	public void setListaSolicitudes(List<Paciente> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}	
	

}
