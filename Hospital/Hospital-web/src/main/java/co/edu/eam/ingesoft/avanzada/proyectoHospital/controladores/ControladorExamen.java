package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import java.util.List;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.TipoExamen;

@Named("controladorExamen")
@ViewScoped
public class ControladorExamen implements Serializable {

	String tipoSelecciondo;

	List<TipoExamen> examenes;

	@EJB
	InsumosProcedimientosEJB insumosYproc;

	@PostConstruct
	public void inicializar() {
		examenes = insumosYproc.listarExamenes();
		for (int i = 0; i < examenes.size(); i++) {
			System.out.println("examenes----------------------------------:" + examenes.get(i));
		}

	}

	public String getTipoSelecciondo() {
		return tipoSelecciondo;
	}

	public void setTipoSelecciondo(String tipoSelecciondo) {
		this.tipoSelecciondo = tipoSelecciondo;
	}

	public List<TipoExamen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<TipoExamen> examenes) {
		this.examenes = examenes;
	}

}
