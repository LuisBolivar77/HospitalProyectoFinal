package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.HorarioEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PersonalMedicoEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Horario;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PersonalMedico;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.enumeraciones.DiaSemanaEnum;

@Named("ControladorHorarioPersonal")
@ViewScoped
public class ControladorHorarioPersonal implements Serializable {

	private String horaInicio;
	
	private String horaFin;
	
	private String diaHorario;
	
	private List<Horario> listaHorarios;
	
	private DiaSemanaEnum diaSeleccionado;
	
	private Usuario sesion;
	
	@EJB
	private HorarioEJB horarioEJB;
	
	@EJB
	private PersonalMedicoEJB personalEJB;
	
	@PostConstruct
	public void postConstructor(){
		sesion = Faces.getApplicationAttribute("usuario");
		listaHorarios = horarioEJB.horariosPersonal(sesion.getIdentificacion());
	}
	
	public void eliminarHorario(int id){
		horarioEJB.eliminarHorario(id);
		postConstructor();
		Messages.addFlashGlobalInfo("El horario ha sido eliminado");
	}
	
	public void agregarHorario(){
		try{
		PersonalMedico per = personalEJB.buscar(sesion.getIdentificacion());
		System.out.println("Dia: "+diaSeleccionado);
		System.out.println("Dia Ingresado: " + diaHorario);
		horarioEJB.agregarHorario(diaSeleccionado, horaInicio, horaFin, per);
		Messages.addFlashGlobalInfo("Se ha registrado el horario exitosamente");
		} catch (ExcepcionNegocio e){
			Messages.addFlashGlobalError(e.getMessage());
		}
	}
	

	public DiaSemanaEnum[] getDiasSemana(){
		return DiaSemanaEnum.values();
	}

	/**
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFin
	 */
	public String getHoraFin() {
		return horaFin;
	}

	/**
	 * @param horaFin the horaFin to set
	 */
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * @return the diaHorario
	 */
	public String getDiaHorario() {
		return diaHorario;
	}

	/**
	 * @param diaHorario the diaHorario to set
	 */
	public void setDiaHorario(String diaHorario) {
		this.diaHorario = diaHorario;
	}

	/**
	 * @return the listaHorarios
	 */
	public List<Horario> getListaHorarios() {
		return listaHorarios;
	}

	/**
	 * @param listaHorarios the listaHorarios to set
	 */
	public void setListaHorarios(List<Horario> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}

	/**
	 * @return the diaSeleccionado
	 */
	public DiaSemanaEnum getDiaSeleccionado() {
		return diaSeleccionado;
	}

	/**
	 * @param diaSeleccionado the diaSeleccionado to set
	 */
	public void setDiaSeleccionado(DiaSemanaEnum diaSeleccionado) {
		this.diaSeleccionado = diaSeleccionado;
	}

	
}
