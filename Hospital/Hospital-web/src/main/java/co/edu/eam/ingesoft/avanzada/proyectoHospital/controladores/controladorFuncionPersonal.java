package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.HospitalizacionEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PacientesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PersonalMedicoEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Usuario;

@Named("controladorFuncionPersonal")
@ViewScoped
public class controladorFuncionPersonal implements Serializable {

	/**
	 * Identificación del paciente hospitalizado
	 */
	private String identificacionPaciente;

	/**
	 * Nombre del paciente hospitalizado
	 */
	private String nombrePaciente;

	/**
	 * Fecha actual que tiene de salida el paciente
	 */
	private Date fechaSalida;

	/**
	 * Nueva fecha de salida del paciente
	 */
	private Date nuevaFechaSalida;

	/**
	 * Lista de citas asignadas a un médico
	 */
	private List<Cita> listaCitas;

	/**
	 * Usuario logueado
	 */
	private Usuario usuario;
	
	private String prueba;

	/**
	 * Fecha en la que se desea buscar las citas del médico
	 */
	private Date fechaCita;
	
	private CalendarView selecionado;

	@EJB
	private HospitalizacionEJB hospitalizacionEJB;

	@EJB
	private PacientesEJB pacienteEJB;

	@EJB
	private PersonalMedicoEJB personalMedicoEJB;

	/**
	 * Guarda la hospitalización buscada a un paciente
	 */
	private Hospitalizacion hospitalizacionPaciente;

	public controladorFuncionPersonal() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void incializar() {
		hospitalizacionPaciente = null;
		usuario = Faces.getApplicationAttribute("usuario");
		listaCitas = personalMedicoEJB.listaCitasPersonal(usuario.getIdentificacion());
	}

	/**
	 * Obtiene la lista de citas de un paciente
	 */
	public void verCitas() {
		Date fecha = fechaCita;
		listaCitas = personalMedicoEJB.listaCitasPersonalFecha(usuario.getIdentificacion(), fecha);
	}
	
	/**
	 * Atiende una cita
	 * @param c Cita que se desea atender
	 */
	public String atender (Cita c){
		ControladorPacienteCita con = new ControladorPacienteCita();
		con.buscarPaciente(c.getPaciente().getIdentificacion());
		return "/paginas/Medico/PaginaInicioPersonal.xhtml?faces-redirect=true";
	}

	/**
	 * Busca un paciente y si este se encuentra o no hospitalizado
	 */
	public void buscar() {
		Paciente paciente = pacienteEJB.buscarPaciente(identificacionPaciente);
		if (paciente != null) {
			Hospitalizacion hosp = hospitalizacionEJB.buscar(identificacionPaciente);
			if (hosp == null) {
				Messages.addFlashGlobalError("Este paciente no se encuentra hospitalizado");
			} else {
				hospitalizacionPaciente = hosp;
				fechaSalida = hosp.getFechaSalida();
				nombrePaciente = paciente.getNombre() + " " + paciente.getApellido();
			}
		} else {
			Messages.addFlashGlobalError("Este paciente no se encuentra registrado");
		}
	}

	/**
	 * Edita la fecha de salida de un paciente
	 */
	public void editarFechaSalida() {
		if (hospitalizacionPaciente == null) {
			Messages.addFlashGlobalError("Debe buscar un paciente previamente");
		} else {
			Date nuevaFecha = selecionado.getDate2();
			hospitalizacionPaciente.setFechaSalida(nuevaFecha);
			hospitalizacionEJB.editar(hospitalizacionPaciente);
		}
	}

	/**
	 * Da de alta a un paciente hospitalizado
	 */
	public void darAlta() {
		if (hospitalizacionPaciente == null) {
			Messages.addFlashGlobalError("Debe buscar un paciente previamente");
		} else {

		}
	}

	/**
	 * @return the identificacionPaciente
	 */
	public String getIdentificacionPaciente() {
		return identificacionPaciente;
	}

	/**
	 * @param identificacionPaciente
	 *            the identificacionPaciente to set
	 */
	public void setIdentificacionPaciente(String identificacionPaciente) {
		this.identificacionPaciente = identificacionPaciente;
	}

	/**
	 * @return the nombrePaciente
	 */
	public String getNombrePaciente() {
		return nombrePaciente;
	}

	/**
	 * @param nombrePaciente
	 *            the nombrePaciente to set
	 */
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida
	 *            the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the nuevaFechaSalida
	 */
	public Date getNuevaFechaSalida() {
		return nuevaFechaSalida;
	}

	/**
	 * @param nuevaFechaSalida
	 *            the nuevaFechaSalida to set
	 */
	public void setNuevaFechaSalida(Date nuevaFechaSalida) {
		this.nuevaFechaSalida = nuevaFechaSalida;
	}

	/**
	 * @return the listaCitas
	 */
	public List<Cita> getListaCitas() {
		return listaCitas;
	}

	/**
	 * @param listaCitas
	 *            the listaCitas to set
	 */
	public void setListaCitas(List<Cita> listaCitas) {
		this.listaCitas = listaCitas;
	}

	/**
	 * @return the fechaCita
	 */
	public Date getFechaCita() {
		return fechaCita;
	}

	/**
	 * @param fechaCita
	 *            the fechaCita to set
	 */
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * @return the prueba
	 */
	public String getPrueba() {
		return prueba;
	}

	/**
	 * @param prueba the prueba to set
	 */
	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}

}
