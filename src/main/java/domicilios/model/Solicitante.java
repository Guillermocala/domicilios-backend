package domicilios.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Solicitantes")
public class Solicitante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String direccion;
	
	@Column
	private Long cel;
	
	@Column
	private String hora;
	
	@OneToOne(mappedBy = "solicitante", cascade = CascadeType.ALL)
	private Domicilio domicilio;

	public Solicitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
