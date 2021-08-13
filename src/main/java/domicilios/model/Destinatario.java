package domicilios.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Destinatarios")
public class Destinatario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private int cel;
	
	@Column
	private String hora;

	@JsonIgnore
	@OneToOne(mappedBy = "destinatario", cascade = CascadeType.ALL)
	private Domicilio domicilio;
	
	public Destinatario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Destinatario(Long id, String nombre, String direccion, int cel, Domicilio domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cel = cel;
		this.domicilio = domicilio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCel() {
		return cel;
	}

	public void setCel(int cel) {
		this.cel = cel;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Destinatario [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", cel=" + cel + ", hora="
				+ hora + ", domicilio=" + domicilio + "]";
	}
	
}
