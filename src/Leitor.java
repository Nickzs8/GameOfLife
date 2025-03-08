import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Leitor{
	int controlador = 0;
	Logic logica;
	
	Leitor(Logic originalLogic){
		this.logica = originalLogic;
	}
	
	public void lerArquivo(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line, line1 = "", line2 = "", linhaEntrada;
	        
	        while ((line = reader.readLine()) != null) {
	        	if(line.charAt(0) == '#') {
	        		continue;
	        	}
	            if(controlador == 0) {
	            	line1 = line;
	            	controlador++;
	            } else {
	            	linhaEntrada = line;
	            	line2 = line2.concat(linhaEntrada);
	            }
	        }
	        controlador = 0;
	        logica.tratarString(line1, line2);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		}
	}
