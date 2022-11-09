package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
		Path archivo = Path.of("target/centros.json");
		try
		{
			//Creamos el contexto para trabajar con nuestra clase Instituto.
			JAXBContext contexto = JAXBContext.newInstance(Centros.class);

			//Con el objeto tipo Unmarshaller pasamos de XML a Java.
			Unmarshaller objetoUnmarshaller = contexto.createUnmarshaller();
			Centros centro;	//Creamos un objeto tipo Centros.

			//Pasamos de XML a Java y mostramos por pantalla el contenido de la etiqueta <nombre>.
			centro = (Centros) objetoUnmarshaller.unmarshal(xmlCentros);
		
			System.out.println(centro.getNombre());
			System.out.println("\n" + "\n");
			
			//Pasamos de objeto a archivo .json
			
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.setPrettyPrinting().create();

			String texto = gson.toJson(centro);
			
			Files.writeString(archivo, texto);

		} catch (JAXBException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
