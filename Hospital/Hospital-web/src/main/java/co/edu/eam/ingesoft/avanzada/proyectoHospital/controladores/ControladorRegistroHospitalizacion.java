package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omg.CORBA.ORBPackage.InconsistentTypeCode;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.HospitalizacionEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.InstalacionesEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.PersonalMedicoEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;

@ViewScoped
@Named("controladorHospitalizacion")
public class ControladorRegistroHospitalizacion implements Serializable {

	private Date fechaEntrada;

	private Date fechaSalida;

	private List<Cama> cama;

	private int camaSeleccionada;
	
	private Date horarioSeleccionado;
	
	private String anotaciones;

	@EJB
	private InstalacionesEJB instalacionesEJB;

	@EJB
	private InsumosProcedimientosEJB insumosProcEJB;

	@EJB
	private HospitalizacionEJB hospEJB;
	
	@EJB
	private PersonalMedicoEJB personalEJB;

	@Inject
	private ControladorLogIn sesion;
	
	@PostConstruct
	public void inicializar() {
		 //citas = personalEJB.listaCitasPersonal(1094969918);
		cama = instalacionesEJB.listarCamas();
	}

	public void ListarCombos() {
		
		 
	}

	public void ordenarHospitalizacion() {
		try {
			
			Cama c = instalacionesEJB.buscarCama(camaSeleccionada);
			Cita cit = new Cita();
			
			Hospitalizacion hospitalizacion = new Hospitalizacion(fechaEntrada, fechaSalida, cit, c);
			insumosProcEJB.crearHospitalizacion(hospitalizacion);
			Messages.addFlashGlobalInfo("Hospitalizacon ordenada");
			
		} catch (ExcepcionNegocio e) {
			e.printStackTrace();
			Messages.addGlobalError(e.getMessage());
		}
	}

	public List<Cama> getCama() {
		return cama;
	}

	public void setCama(List<Cama> cama) {
		this.cama = cama;
	}

	public InstalacionesEJB getInstalacionesEJB() {
		return instalacionesEJB;
	}

	public void setInstalacionesEJB(InstalacionesEJB instalacionesEJB) {
		this.instalacionesEJB = instalacionesEJB;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getCamaSeleccionada() {
		return camaSeleccionada;
	}

	public void setCamaSeleccionada(int camaSeleccionada) {
		this.camaSeleccionada = camaSeleccionada;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

}
