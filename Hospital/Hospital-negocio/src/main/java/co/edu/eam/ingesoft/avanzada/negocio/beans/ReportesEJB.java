package co.edu.eam.ingesoft.avanzada.negocio.beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades.Medicamento;

@LocalBean
@Stateless
public class ReportesEJB implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Lista de medicamentos que nunca han sido recetados
	 * @return la lista de medicamentos
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Medicamento> medicamentosNoRecetados(){
		Query q = em.createNamedQuery("SELECT m.ID FROM MEDICAMENTO m"
				+ "  MINUS SELECT mp.MEDICAMENTO_ID FROM MEDICAMENTO_PACIENTE mp");
		List<Medicamento> lista  = q.getResultList();
		return lista;
	}
	
	/**
	 * Cantidad de medicamentos que han sido entregados en un mes
	 * @param mes el mes
	 * @return la cantidad de medicamentos
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public int medicamentosEntregados(String mes){
		Query q = em.createNamedQuery("");
		q.setParameter(1, mes);
		Object[] cant = (Object[]) q.getSingleResult();
		return Integer.parseInt(cant[0].toString());
	}
	
	/**
	 * CATIDAD DE PERSONAS QUE FUERON HOSPITALIZADAS POR PATOLOGÍA EN UNA FEHCA DETERMINADA
	 * 
	 * SELECT pat.ID, pat.NOMBRE PATOLOGIA, COUNT (p.IDENTIFICACION) PERSONAS_HOSPITALIZADAS
  FROM PACIENTE p JOIN CITA c ON c.PACIENTE_ID = p.IDENTIFICACION
  JOIN HOSPITALIZACION h ON h.CITA_ID = c.ID JOIN PATOLOGIA_PACIENTE pp
  ON pp.CITA_ID = c.ID JOIN PATOLOGIA pat ON pat.ID = pp.PATOLOGIA_ID
  WHERE h.FECHA_ENTRADA='12/12/10'
  GROUP BY pat.ID, pat.NOMBRE
	 */
	
	/**
	 * POR PATOLOGÍA CUÁL ES EL PORCENTAJE DE PACIENTES QUE LA PADECEN
	 * 
	 * SELECT pat.ID, pat.NOMBRE PATOLOGIA, NVL(ROUND(COUNT(p.IDENTIFICACION/
  (SELECT COUNT(*) FROM PACIENTE)*100),2),0)||'%' PORCENTAJE
  FROM PACIENTE p JOIN CITA c ON c.PACIENTE_ID = p.IDENTIFICACION
  JOIN PATOLOGIA_PACIENTE pp ON pp.CITA_ID = c.ID 
  JOIN PATOLOGIA pat ON pat.ID = pp.PATOLOGIA_ID
  GROUP BY pat.ID, pat.NOMBRE
	 */
	
}
