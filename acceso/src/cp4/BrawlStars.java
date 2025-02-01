package cp4;

import java.io.FileOutputStream;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class BrawlStars {
	public static void main(String[] args) {
		
		String[] personajes = {"Shelly", "Colt", "Jessie", "Nita", "Bo", "Spike", "Crow"};
		int[] edades = {23, 25, 16, 12, 35, 30, 28};
		double[] poderes = {8.5, 7.8, 9.0, 7.0, 8.2, 9.5, 9.8};
		String[] habilidadesEspeciales = {"Super disparo", "Ráfaga de balas",
				"Torreta defensiva", "Gran oso", "Lluvia de flechas",
				"Explosión espinosa", "Veneno tóxico"};

		Document documento;
		try {
			documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			
			Element raiz = documento.createElement("Brawlers");
			
			documento.appendChild(raiz);
			for (int i = 0; i < edades.length; i++) {
				Element brawler = documento.createElement("Brawler");
				brawler.setAttribute("edad", String.valueOf(edades[i]));
				//brawler.setAttribute("Habilidades", habilidadesEspeciales[i]);  ej con string
				raiz.appendChild(brawler);
				
				Element nombre = documento.createElement("Nombre");
				nombre.appendChild(documento.createTextNode(personajes[i]));
				brawler.appendChild(nombre);
				
				Element habilidades = documento.createElement("Habilidades");
				habilidades.appendChild(documento.createTextNode(habilidadesEspeciales[i]));
				brawler.appendChild(habilidades);
				
				Element poder = documento.createElement("Poder");
				poder.appendChild(documento.createTextNode(String.valueOf(poderes[i])));
				brawler.appendChild(poder);
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			DOMSource source = new DOMSource(documento);
			StreamResult resultado = new StreamResult(new FileOutputStream("brawlstars.xml"));
			transformer.transform(source, resultado);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}