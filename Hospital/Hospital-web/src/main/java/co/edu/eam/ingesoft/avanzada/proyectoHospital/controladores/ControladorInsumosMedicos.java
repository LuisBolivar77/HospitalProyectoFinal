package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.negocio.beans.InsumosProcedimientosEJB;
import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;

@ViewScoped
@Named("ControladorInsumos")
public class ControladorInsumosMedicos implements Serializable {

	private int cantidad;

	private String descripcion;

	private int codigo;

	private int estatica;

	@EJB
	private InsumosProcedimientosEJB insumosEJB;

	@PostConstruct
	public void postConstruct() {
		cargaDatosMedicamento();
	}

	/**
	 * registra un insumo medico
	 */
	public void registrarInsumo() {
		try {
			Medicamento medicam = new Medicamento(codigo, cantidad, descripcion);
			insumosEJB.crearMedicamento(medicam);
			Messages.addFlashGlobalInfo("Registro exitoso");
			cancelarRegistro();
		} catch (ExcepcionNegocio e) {
			Messages.addFlashGlobalInfo(e.getMessage());
		}
	}

	/**
	 * busca un insumo medico
	 */
	public void buscarInsumo() {
		if (codigo == 0) {
			Messages.addFlashGlobalInfo("busque un medicamento preeviamente");
		} else {
			Medicamento medi = insumosEJB.buscarMedicamento(codigo);
			if (medi != null) {
				cantidad = medi.getCantidad();
				descripcion = medi.getDescripcion();
				Messages.addFlashGlobalInfo("Medicamento encontrado");
			} else {
				Messages.addFlashGlobalInfo("Este medicamento no se encuentra registrado");
			}
		
		}

	}

	/**
	 * edita un insumo medico
	 */
	public void editarInsumo() {

		if (descripcion.equals("")) {
			Messages.addFlashGlobalInfo("busque un medicamento previa mente");
		} else {
			Medicamento med = insumosEJB.buscarMedicamento(codigo);
			med.setCantidad(cantidad);
			med.setDescripcion(descripcion);
			insumosEJB.editar(med);
			Messages.addFlashGlobalInfo("Medicamento Editado");
		}
	}

	/**
	 * carga los campos previamente
	 */
	public String cargaDatosMedicamento() {
		int cod = Medicamento.getCodigomedicamento();
		if (cod == 0) {
			return "/paginas/Administrador/RegistroInsumos.xhtml?faces-redirect=true";
		} else {
			estatica = Medicamento.getCodigomedicamento();
			Medicamento m = insumosEJB.buscarMedicamento(estatica);
			codigo = m.getId();
			cantidad = m.getCantidad();
			descripcion = m.getDescripcion();
		}
		return null;
	}

	/**
	 * limpia todos los campos
	 */
	public void cancelarRegistro() {
		cantidad = 0;
		codigo = 0;
		descripcion = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstatica() {
		return estatica;
	}

	public void setEstatica(int estatica) {
		this.estatica = estatica;
	}

}
