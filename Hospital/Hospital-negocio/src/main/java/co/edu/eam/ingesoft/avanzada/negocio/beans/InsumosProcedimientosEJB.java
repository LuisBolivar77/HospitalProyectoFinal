package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.negocio.exception.ExcepcionNegocio;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;

@LocalBean
@Stateless
public class InsumosProcedimientosEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * metodo que registra un medicamento en la base de datos
	 * 
	 * @param m
	 *            el medicamento a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearMedicamento(Medicamento m) {
		Medicamento med = buscarMedicamento(m.getId());
		if (med == null) {
			em.persist(m);
		} else {
			throw new ExcepcionNegocio("Este medicamento ya se encuentra registrado");
		}
	}

	/**
	 * metodo que busca un medicamento
	 * 
	 * @param cod
	 *            codigo por el que se el va a buscar
	 * @return el medicamento
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Medicamento buscarMedicamento(int cod) {
		return em.find(Medicamento.class, cod);
	}

	/**
	 * Edita un medicamento
	 * 
	 * @param m
	 *            el medicamento a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(Medicamento m) {
		em.merge(m);
	}

	/**
	 * Elimina un medicamento registrado
	 * 
	 * @param med
	 *            el medicamento a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(Medicamento med) {
		em.remove(med);
	}

	/**
	 * metodo que registra una cirugia en la base de datos
	 * 
	 * @param c
	 *            la cirugia a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearCirugia(Cirugia c) {
		Cirugia cir = buscarCirugia(c.getId());
		if (cir == null) {
			em.persist(c);
		} else {
			throw new ExcepcionNegocio("Esta cirugia ya se encuentra registrado");
		}
	}

	/**
	 * metodo que busca una cirugia
	 * 
	 * @param cod
	 *            codigo por el que se el va a buscar
	 * @return el la cirugia
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Cirugia buscarCirugia(int cod) {
		return em.find(Cirugia.class, cod);
	}

	/**
	 * Edita una cirugia
	 * 
	 * @param c
	 *            la cirugia a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarCirugia(Cirugia c) {
		em.merge(c);
	}

	/**
	 * Elimina una cirugia registrada
	 * 
	 * @param c
	 *            la cirugia a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarCirugia(Cirugia c) {
		em.remove(c);
	}

	/**
	 * metodo que registra una hospitalizacion en la base de datos
	 * 
	 * @param hos
	 *            la hospitalizacion a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearHospitalizacion(Hospitalizacion hos) {
		em.persist(hos);
	}

	/**
	 * metodo que busca una Hospitalizacion
	 * 
	 * @param cod
	 *            codigo por el que se el va a buscar
	 * @return la Hospitalizacion
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Hospitalizacion buscarHospitalizacion(int cod) {
		return em.find(Hospitalizacion.class, cod);
	}

	/**
	 * Edita una Hospitalizacion
	 * 
	 * @param h
	 *            Hospitalizacion a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(Hospitalizacion h) {
		em.merge(h);
	}

	/**
	 * Elimina una Hospitalizacion registrada
	 * 
	 * @param hos
	 *            la Hospitalizacion a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(Hospitalizacion hos) {
		em.remove(hos);
	}

	/**
	 * metodo que registra un Examen en la base de datos
	 * 
	 * @param e
	 *            el examen a registrar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearExamen(Examen e) {
		Examen ex = buscarExamen(e.getId());
		if (ex == null) {
			em.persist(e);
		} else {
			throw new ExcepcionNegocio("Este Examen ya se encuentra registrado");
		}
	}

	/**
	 * metodo que busca un examen
	 * 
	 * @param cod
	 *            codigo por el que se el va a buscar
	 * @return el examen
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Examen buscarExamen(int cod) {
		return em.find(Examen.class, cod);
	}

	/**
	 * Edita un examen
	 * 
	 * @param e
	 *            el examen a editar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editar(Examen e) {
		em.merge(e);
	}

	/**
	 * Elimina un examen registrado
	 * 
	 * @param ex
	 *            el examen a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(Examen ex) {
		em.remove(ex);
	}

}
