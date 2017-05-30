package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import java.util.List;

import co.edu.eam.ingesoft.avanzada.negocio.beans.ExamenEJB;
import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoExamen;

@Named("controladorExamen")
@ViewScoped
public class ControladorExamen implements Serializable {
	
	private String descripcion;
	
	private String tipoExamenSelecc;

	List<TipoExamen> examenes;
	
	private int numeroExamen;
	
	private String nombreExamen;
	
	private String  tipoExamen;
	

	private int numeroExamenEdi;
	
	private String descripcionEDI;
	
	private String tipoExamenEDI;
	
	List<Examen> exam;
	
	@EJB
	ExamenEJB examen;

	@EJB
	InsumosProcedimientosEJB insumosYproc;
	

	public void listarTipoExamenes(){
		examenes = examen.listarTipoExamenes();
	}
	
	public void listarExamenes(){
		exam = examen.listarExamenes();
	}

	@PostConstruct
	public void inicializar() {
		listarTipoExamenes();

	}
	
	
	/**
	 * Registra una patologia en la base de datos
	 */
	public void registarExamen() {
		if (descripcion == null || tipoExamenSelecc == null) {
			Messages.addFlashGlobalInfo("Ingrese todos los campos");
		} else {
			
			TipoExamen tipo = new TipoExamen();
			tipo.setDescripcion(tipoExamenSelecc);
			
			Examen pa = new Examen();
			pa.setDescripcion(descripcion);
			pa.setTipoExamen(tipo);
			
			try {
				examen.registrarExamen(pa);
				Messages.addFlashGlobalInfo("Registro exitoso");
			} catch (ExcepcionNegocio e) {
				Messages.addFlashGlobalError(e.getMessage());
			}
		}
	}

	
	/**
	 * Busca una patologia
	 */
	public void buscarExamen() {
		if (numeroExamen == 0) {
			Messages.addFlashGlobalError("ingrese un idenentificador de la patologia");
		} else {
			Examen p = examen.buscarExamen(numeroExamen);
			if (p != null) {
				nombreExamen = p.getDescripcion();
				Messages.addFlashGlobalInfo("Examen encontrada");
			} else {
				Messages.addFlashGlobalError("Esta patologia no se encuentra registrada");
			}
		}
	}

	public List<TipoExamen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<TipoExamen> examenes) {
		this.examenes = examenes;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipoExamenSelecc
	 */
	public String getTipoExamenSelecc() {
		return tipoExamenSelecc;
	}

	/**
	 * @param tipoExamenSelecc the tipoExamenSelecc to set
	 */
	public void setTipoExamenSelecc(String tipoExamenSelecc) {
		this.tipoExamenSelecc = tipoExamenSelecc;
	}

	/**
	 * @return the examen
	 */
	public ExamenEJB getExamen() {
		return examen;
	}

	/**
	 * @param examen the examen to set
	 */
	public void setExamen(ExamenEJB examen) {
		this.examen = examen;
	}

	/**
	 * @return the insumosYproc
	 */
	public InsumosProcedimientosEJB getInsumosYproc() {
		return insumosYproc;
	}

	/**
	 * @param insumosYproc the insumosYproc to set
	 */
	public void setInsumosYproc(InsumosProcedimientosEJB insumosYproc) {
		this.insumosYproc = insumosYproc;
	}

}
