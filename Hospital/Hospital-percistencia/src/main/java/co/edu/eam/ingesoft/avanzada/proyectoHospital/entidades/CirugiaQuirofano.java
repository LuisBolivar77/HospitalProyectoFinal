package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CIRUGIA_QUIROFANO")
public class CirugiaQuirofano implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="QUIROFANO")
	private Quirofano quirofano;
	
}
