package Clases;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "valoracion")
public class Valoracion {
    String comentario;
    Double puntuacion;

    public Valoracion() {

    }

    public Valoracion(String comentario, Double valoracion) {
        this.comentario = comentario;
        this.puntuacion = valoracion;
    }

    @XmlAttribute(name = "comentario")
    public String getComentario() {
        return comentario;
    }

    @XmlAttribute(name = "puntuacion")
    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
