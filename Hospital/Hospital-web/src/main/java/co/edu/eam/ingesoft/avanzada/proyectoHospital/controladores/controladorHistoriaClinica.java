package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import co.edu.eam.ingesoft.avanzada.negocio.beans.HistoriaClinicaEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.EncargadoCirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.MedicamentoPaciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.PatologiaPaciente;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.ResultadoExamen;

@ViewScoped
@Named("controladorHistoriaClinica")
public class controladorHistoriaClinica implements Serializable {

	private List<Hospitalizacion> listaHospitalizaciones;
	
	private List<EncargadoCirugia> listaCirugias;
	
	private List<ResultadoExamen> listaExamenes;
	
	private List<MedicamentoPaciente> listaMedicamentos;
	
	private List<PatologiaPaciente> listaPatologias;
	
	private Paciente sesion;
	
	@EJB
	private HistoriaClinicaEJB historiaEJB;
	
	@PostConstruct
	public void inicializar(){
		
		listaHospitalizaciones = historiaEJB.listaHospitalizaciones(Paciente.getIdPaciente());
		listaCirugias = historiaEJB.listaCirugias(Paciente.getIdPaciente());
		listaExamenes = historiaEJB.listaExamenes(Paciente.getIdPaciente());
		listaMedicamentos = historiaEJB.listaMedicamentos(Paciente.getIdPaciente());
		listaPatologias = historiaEJB.listaPatologias(Paciente.getIdPaciente());
	}

	/**
	 * @return the listaHospitalizaciones
	 */
	public List<Hospitalizacion> getListaHospitalizaciones() {
		return listaHospitalizaciones;
	}

	/**
	 * @param listaHospitalizaciones the listaHospitalizaciones to set
	 */
	public void setListaHospitalizaciones(List<Hospitalizacion> listaHospitalizaciones) {
		this.listaHospitalizaciones = listaHospitalizaciones;
	}

	/**
	 * @return the listaCirugias
	 */
	public List<EncargadoCirugia> getListaCirugias() {
		return listaCirugias;
	}

	/**
	 * @param listaCirugias the listaCirugias to set
	 */
	public void setListaCirugias(List<EncargadoCirugia> listaCirugias) {
		this.listaCirugias = listaCirugias;
	}

	/**
	 * @return the listaExamenes
	 */
	public List<ResultadoExamen> getListaExamenes() {
		return listaExamenes;
	}

	/**
	 * @param listaExamenes the listaExamenes to set
	 */
	public void setListaExamenes(List<ResultadoExamen> listaExamenes) {
		this.listaExamenes = listaExamenes;
	}

	/**
	 * @return the listaMedicamentos
	 */
	public List<MedicamentoPaciente> getListaMedicamentos() {
		return listaMedicamentos;
	}

	/**
	 * @param listaMedicamentos the listaMedicamentos to set
	 */
	public void setListaMedicamentos(List<MedicamentoPaciente> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

	/**
	 * @return the listaPatologias
	 */
	public List<PatologiaPaciente> getListaPatologias() {
		return listaPatologias;
	}

	/**
	 * @param listaPatologias the listaPatologias to set
	 */
	public void setListaPatologias(List<PatologiaPaciente> listaPatologias) {
		this.listaPatologias = listaPatologias;
	}
	
	
}
