package com.uca.capas.modelo.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
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
	@GeneratedValue(generator="importancia_c_importancia_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "importancia_c_importancia_seq", sequenceName = "public.importancia_c_importancia_seq", allocationSize = 1)
	@Column(name = "c_importancia")
	private Integer c_importancia;
	
	@Column(name = "s_importancia")
	private String s_importancia;
	
	@OneToMany(mappedBy = "importancia", fetch = FetchType.LAZY)
	private List<Contribuyente> contribuyentes;

	public Integer getC_importancia() {return c_importancia;}
	public void setC_importancia(Integer c_importancia) {	this.c_importancia = c_importancia;}

	public String getS_importancia() {return s_importancia;	}
	public void setSimportancia(String s_importancia) {this.s_importancia = s_importancia;	}

	public List<Contribuyente> getContribuyentes() {return contribuyentes;}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {this.contribuyentes = contribuyentes;}

}
