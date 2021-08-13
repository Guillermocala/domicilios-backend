package domicilios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mensajeros")
public class Mensajero {
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
	private int cedula;
	
	@Column
	private String placa;

	public Mensajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensajero(Long id, String nombre, String direccion, int cel, int cedula, String placa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.cel = cel;
		this.cedula = cedula;
		this.placa = placa;
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

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Mensajero [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", cel=" + cel + ", cedula="
				+ cedula + ", placa=" + placa + "]";
	}
}
