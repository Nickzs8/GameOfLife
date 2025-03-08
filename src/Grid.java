import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid {
	
	Tile[][] jogo;	
	Acoes acoes;
	Logic originalLogic;
	int numberColumns, numberLines;
	
	
	Grid(JPanel painelPrincipal, FramePrincipal framePrincipal, int numeroLinhas, int numeroColunas, int velocidade){
		this.numberColumns = numeroColunas;
		this.numberLines = numeroLinhas;
		
		painelPrincipal.removeAll();
		
		painelPrincipal.setLayout(new GridLayout(numeroLinhas,numeroColunas,0,0));
		
		jogo = new Tile[numeroLinhas][numeroColunas];
		
		
		originalLogic = new Logic(jogo, framePrincipal, numeroLinhas, numeroColunas, velocidade);
		
		acoes = new Acoes(painelPrincipal, originalLogic, jogo);
		
		for(int i=0;i<numeroLinhas;i++) {
			for(int j=0;j<numeroColunas;j++) {
				jogo[i][j] = new Tile(j,i,painelPrincipal, originalLogic, jogo);
			}
		}
		
		framePrincipal.frame.add(painelPrincipal);
	}
	
}
