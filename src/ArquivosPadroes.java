import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class ArquivosPadroes {
	ArrayList<File> arquivos = new ArrayList<File>();
			
	//arquivos.add(new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\climber.rle"));
	
	File file1 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\climber.rle");
	File file2 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\beacon.rle");
	File file3 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\AK-94.rle");
	File file4 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\glider-duplicator-1.rle");
	File file5 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\rats.rle");
	File file6 = new File("C:\\Users\\nickd\\eclipse-workspace\\GameOfLife\\patterns\\gun165.rle");
	
	public void getFile(LabelPadroes label, int pos) {
		switch(pos) {
		case 0: 
			label.arquivoPadrao = file1;
		break;
		case 1: 
			label.arquivoPadrao = file2;
			break;
		case 2: 
			label.arquivoPadrao = file3;
			break;
		case 3: 
			label.arquivoPadrao = file4;
			break;
		case 4: 
			label.arquivoPadrao = file5;
			break;
		case 5: 
			label.arquivoPadrao = file6;
			break;
		}
	}
}

