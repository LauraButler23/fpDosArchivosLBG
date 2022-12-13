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

        //Creamos el jaxb para hacer referencia a las anotaciones de cada clase que le pasamos por parámetro.
        JAXBContext jaxbContext = JAXBContext.newInstance(listaProyectos.class, Centros.class, Usuario.class);

        //Pasamos de xml a objeto con unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //Creamos un objeto de cada clase.
        listaProyectos listaProyectos;
        Centros listacentros;
        Usuario listaUsuarios;

        //Hacemos la instancia de cada objeto desde el xml.
        listaProyectos = (Clases.listaProyectos) unmarshaller.unmarshal(new File("src/main/resources/proyectos.xml"));
        listacentros = (Centros) unmarshaller.unmarshal(new File("src/main/resources/centros.xml"));
        listaUsuarios = (Usuario) unmarshaller.unmarshal(new File("src/main/resources/usuarios.xml"));

        //Creamos tres archivos .json
        Path path = Path.of("target/Proyecto.json");
        Path path2 = Path.of("target/Centros.json");
        Path path3 = Path.of("target/Usuarios.json");

        //Creamos un objeto Gson para poder almacenar el texto que queremos almacenar en cada archivo.
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String textoProyecto = gson.toJson(listaProyectos);
        String textoCentros = gson.toJson(listacentros);
        String textoUsuarios = gson.toJson(listaUsuarios);

        //Escribimos el texto a los archivos.
        try {
           Files.write(path, textoProyecto.getBytes());
           Files.write(path2, textoCentros.getBytes());
            Files.write(path3, textoUsuarios.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}