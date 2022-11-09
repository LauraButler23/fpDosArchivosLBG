package Clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;

@XmlRootElement(name = "proyecto")
@XmlType(propOrder = {"titulo","participantes", "tags", "familias", "descripcion", "coordinador", "valoracion", "estado", "visibilidad"})

public class Proyecto {

    ArrayList<String> participantes, tags, familias;
    String titulo, descripcion, coordinador;
    Valoracion valoracion;
    Boolean estado, visibilidad;

    public Proyecto() {

    }

    public Proyecto(ArrayList<String> participantes, ArrayList<String> tags, ArrayList<String> familiaImplicadas, String titulo, String descripcion, String coordinador, Valoracion valoracion, Boolean estado, Boolean visibilidad) {
        this.participantes = participantes;
        this.tags = tags;
        this.familias = familiaImplicadas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.coordinador = coordinador;
        this.valoracion = valoracion;
        this.estado = estado;
        this.visibilidad = visibilidad;
    }


    @XmlElement(name = "participante")
    @XmlElementWrapper(name = "participantes")
    public ArrayList<String> getParticipantes() {
        return participantes;
    }

    @XmlElement(name = "tag")
    @XmlElementWrapper(name = "tags")
    public ArrayList<String> getTags() {
        return tags;
    }

    @XmlElement(name = "familia")
    @XmlElementWrapper(name = "familias")
    public ArrayList<String> getFamilias() {
        return familias;
    }

    @XmlElement(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    @XmlElement(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @XmlElement(name = "coordinador")
    public String getCoordinador() {
        return coordinador;
    }

    @XmlElement(name = "valoracion")
    public Valoracion getValoracion() {
        return valoracion;
    }

    @XmlElement(name = "estado")
    public Boolean getEstado() {
        return estado;
    }

    @XmlElement(name = "visibilidad")
    public Boolean getVisibilidad() {
        return visibilidad;
    }


    public void setParticipantes(ArrayList<String> participantes) {
        this.participantes = participantes;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setFamilias(ArrayList<String> familias) {
        this.familias = familias;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setVisibilidad(Boolean visibilidad) {
        this.visibilidad = visibilidad;
    }
}
