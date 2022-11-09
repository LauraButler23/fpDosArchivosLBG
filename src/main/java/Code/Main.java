package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import Clases.Proyecto;
import Clases.listaProyectos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Clases.Centros;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Main {

    public static void main(String[] args) {

        //Creamos un archivo que apunta a insti.xml
        File xmlCentros = new File("src/main/resources/centros.xml");
        File xmlCentros1 = new File("src/main/resources/proyectos.xml");
        Path archivo = Path.of("target/centros.json");
        Path archivo1 = Path.of("target/Proyecto.json");
        try {
            //Creamos el contexto para trabajar con nuestra clase Instituto.
            JAXBContext contexto = JAXBContext.newInstance(Centros.class);
            JAXBContext contexto1 = JAXBContext.newInstance(Proyecto.class);

            //Con el objeto tipo Unmarshaller pasamos de XML a Java.
            Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();
            Unmarshaller objetoUnmarshaller1 = contexto1.createUnmarshaller();
            Centros centro;    //Creamos un objeto tipo Centros.
            listaProyectos listaProyectos;

            //Pasamos de XML a Java y mostramos por pantalla el contenido de la etiqueta <nombre>.
            centro = (Centros) objetoUnmarshaller.unmarshal(xmlCentros);
            listaProyectos = (Clases.listaProyectos) objetoUnmarshaller1.unmarshal(new File("src/main/resources/proyectos.xml"));


            System.out.println(centro.getNombre());
            System.out.println("\n" + "\n");

            //Pasamos de objeto a archivo .json

            GsonBuilder builder = new GsonBuilder();

            Gson gson = builder.setPrettyPrinting().create();

            String texto = gson.toJson(centro);
            String texto1 = gson.toJson(listaProyectos);

            Files.writeString(archivo, texto);
            Files.writeString(archivo1, texto1);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
