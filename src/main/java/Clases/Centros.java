package Clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="centro")
@XmlType(propOrder= {"nombre","proyecto","web","contacto","profesor","familia_Profesional","alumno"})

public class Centros {

	private String nombre, web, familia_Profesional;
	private int contacto;
	private Proyectos proyecto;
	private Profesores profesores;
	private Alumnos alumno;
	public Centros(String nombre, String web, String familia_Profesional, int contacto, Proyectos proyecto, Profesores profesores,
			Alumnos alumno) {
		super();
		this.nombre = nombre;
		this.web = web;
		this.familia_Profesional = familia_Profesional;
		this.contacto = contacto;
		this.profesores = profesores;
		this.alumno = alumno;
		this.proyecto = proyecto;
	}
	
	public Centros() {}
	
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="proyecto")
	public Proyectos getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyectos proyecto) {
		this.proyecto = proyecto;
	}
	
	
	@XmlElement(name="web")
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	
	@XmlElement(name="contacto")
	public int getContacto() {
		return contacto;
	}
	public void setContacto(int contacto) {
		this.contacto = contacto;
	}
	
	@XmlElement(name="profesor")
	public Profesores getProfesor() {
		return profesores;
	}
	public void setProfesor(Profesores profesores) {
		this.profesores = profesores;
	}
	
	@XmlElement(name="familia_Profesional")
	public String getFamilia_Profesional() {
		return familia_Profesional;
	}
	public void setFamilia_Profesional(String familia_Profesional) {
		this.familia_Profesional = familia_Profesional;
	}
	
	@XmlElement(name="alumno")
	public Alumnos getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

}
