package Clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(listaProyectos.class, Centros.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        listaProyectos listaProyectos;
        Centros listacentros;
        listaProyectos = (Clases.listaProyectos) unmarshaller.unmarshal(new File("src/main/resources/proyectos.xml"));
        listacentros = (Centros) unmarshaller.unmarshal(new File("src/main/resources/centros.xml"));

        Path path = Path.of("target/Proyecto.json");
        Path path2 = Path.of("target/Centros.json");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String textoProyecto = gson.toJson(listaProyectos);
        String textoCentros = gson.toJson(listacentros);

        try {
           Files.write(path, textoProyecto.getBytes());
           Files.write(path2, textoCentros.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}