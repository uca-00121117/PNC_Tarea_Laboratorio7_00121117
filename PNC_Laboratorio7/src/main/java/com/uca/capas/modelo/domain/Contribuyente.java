package com.uca.capas.modelo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {
	//(Clase 15)->@GeneratedValue: Se utiliza para anotar a la propiedad que actúa como llave primaria 
	//(por ende la que está anotada con @Id). La propiedad generator define el nombre del 
	//generador que se utilizará para insertar valores secuenciales a la propiedad.
	//Strategy define la estrategia con la que se generará el valor, en nuestro caso lo dejaremos en AUTO.

	//(Clase 15)->@SequenceGenerator: Se define la secuencia a la que estará haciendo referencia
	//la anotación GeneratedValue. La propiedad name define el nombre con la que se
	//referenciará esta secuencia (es la que también se define en la propiedad generator 
	//de la anotación GeneratedValue, y la propiedad sequenceName define el nombre de la
	//secuencia en la base de datos (esquema incluido)

	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	@Column(name = "c_contribuyente")
	private Integer c_contribuyente;
	
	@Column(name = "s_nombre")
	private String s_nombre;
	
	@Column(name = "s_apellido")
	private String s_apellido;
	
	@Column(name = "s_nit")
	private String s_nit;
	
	@NotNull(message = "El campo Fecha no puede quedar vacio")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha_ingreso")
	private Date f_ingreso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Transient
	private Integer c_importancia;
	
	public Contribuyente() {}

	public Integer getC_contribuyente() {return c_contribuyente;}
	public void setC_contribuyente(Integer c_contribuyente) {this.c_contribuyente = c_contribuyente;}

	public String getS_nombre(){return s_nombre;}
	public void setS_nombre(String s_nombre) {this.s_nombre = s_nombre;}

	public String getS_apellido(){return s_apellido;}
	public void setS_apellido(String s_apellido) {this.s_apellido = s_apellido;}

	public String getS_nit() {return s_nit;}
	public void setSnit(String s_nit) {this.s_nit = s_nit;	}

	public Date getF_ingreso() {return f_ingreso;}
	public String getF_ingresoDelegate() {SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	return formato.format(f_ingreso);}
	public void setF_ingreso(Date f_ingreso) {this.f_ingreso = f_ingreso;}

	public Importancia getImportancia() {return importancia;}
	public void setImportancia(Importancia importancia) {this.importancia = importancia;}

	public Integer getC_importancia() {return c_importancia;}
	public void setC_importancia(Integer cimportancia) {this.c_importancia = cimportancia;}

}
