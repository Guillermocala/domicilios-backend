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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Domicilios")
public class Domicilio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombreSolicitante;
	
	@Column
	private String dirSolicitante;
	
	@Column
	private int celSolicitante;
	
	@Column
	private String horaSolicitante;
	
	@Column
	private String nombreDestinatario;
	
	@Column
	private String dirDestinatario;
	
	@Column
	private int celDestinatario;
	
	@Column
	private String horaDestinatario;
	
	@Column
	private String descripcionPaquete;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMensajero")
	private Mensajero mensajero;
	
	@Column
	private boolean estado;
	
	public Domicilio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domicilio(Long id, String nombreSolicitante, String dirSolicitante, int celSolicitante,
			String horaSolicitante, String nombreDestinatario, String dirDestinatario, int celDestinatario,
			String horaDestinatario, String descripcionPaquete, Mensajero mensajero, boolean estado) {
		super();
		this.id = id;
		this.nombreSolicitante = nombreSolicitante;
		this.dirSolicitante = dirSolicitante;
		this.celSolicitante = celSolicitante;
		this.horaSolicitante = horaSolicitante;
		this.nombreDestinatario = nombreDestinatario;
		this.dirDestinatario = dirDestinatario;
		this.celDestinatario = celDestinatario;
		this.horaDestinatario = horaDestinatario;
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

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public String getDirSolicitante() {
		return dirSolicitante;
	}

	public void setDirSolicitante(String dirSolicitante) {
		this.dirSolicitante = dirSolicitante;
	}

	public int getCelSolicitante() {
		return celSolicitante;
	}

	public void setCelSolicitante(int celSolicitante) {
		this.celSolicitante = celSolicitante;
	}

	public String getHoraSolicitante() {
		return horaSolicitante;
	}

	public void setHoraSolicitante(String horaSolicitante) {
		this.horaSolicitante = horaSolicitante;
	}

	public String getNombreDestinatario() {
		return nombreDestinatario;
	}

	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
	}

	public String getDirDestinatario() {
		return dirDestinatario;
	}

	public void setDirDestinatario(String dirDestinatario) {
		this.dirDestinatario = dirDestinatario;
	}

	public int getCelDestinatario() {
		return celDestinatario;
	}

	public void setCelDestinatario(int celDestinatario) {
		this.celDestinatario = celDestinatario;
	}

	public String getHoraDestinatario() {
		return horaDestinatario;
	}

	public void setHoraDestinatario(String horaDestinatario) {
		this.horaDestinatario = horaDestinatario;
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
