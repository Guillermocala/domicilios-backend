package domicilios.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Domicilios")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "idSolicitante", updatable = false, nullable = false)
	private Solicitante solicitante;
	
	@OneToOne
	@JoinColumn(name = "idDestinatario", updatable = false, nullable = false)
	private Destinatario destinatario;
	
	@Column
	private String descripcionPaquete;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Mensajero mensajero;
	
	@Column
	private boolean estado;
	
	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domicilio(Long id, Solicitante solicitante, Destinatario destinatario, String descripcionPaquete,
			Mensajero mensajero, boolean estado) {
		super();
		this.id = id;
		this.solicitante = solicitante;
		this.destinatario = destinatario;
		this.descripcionPaquete = descripcionPaquete;
		this.mensajero = mensajero;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public String getDescripcionPaquete() {
		return descripcionPaquete;
	}

	public void setDescripcionPaquete(String descripcionPaquete) {
		this.descripcionPaquete = descripcionPaquete;
	}

	public Mensajero getMensajero() {
		return mensajero;
	}

	public void setMensajero(Mensajero mensajero) {
		this.mensajero = mensajero;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
