import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Logic {
	boolean controle = true;
	int velocidade;
	int numeroLinhas;
	int numeroColunas;
	int geracoes = 0;
	Timer timer;
	FramePrincipal framePrincipal;
	Tile[][] jogo;
	
	Logic(Tile[][] jogo, FramePrincipal frame, int numeroLinhas, int numeroColunas, int velocidade){
		
		this.framePrincipal = frame;
		this.numeroLinhas = numeroLinhas;
		this.numeroColunas = numeroColunas;
		this.jogo = jogo;
		this.velocidade = velocidade;
	}

	public void run(){
		if(timer == null) {
			timer = new Timer(velocidade, e -> {
			    checaAdjacenciaEmMatriz(jogo);
			    mudaEstadoEmMatriz(jogo);
			    geracoes++;
			    framePrincipal.frame.setTitle("Game of Life: " + geracoes);
			});
			timer.start();
		} else timer.start();
	} 
	
	public void stop() {
        if (timer != null) timer.stop();
    }
	
	public void checaAdjacenciaEmMatriz(Tile[][] jogo) {
		for (int i = 0; i < numeroLinhas; i++) {
	        for (int j = 0; j < numeroColunas; j++) {
	            checaAdjacencia(jogo, jogo[i][j], j, i);
	        }
	    }
	}
	
	public void mudaEstadoEmMatriz(Tile[][] jogo) {
		for (int i = 0; i < numeroLinhas; i++) {
	        for (int j = 0; j < numeroColunas; j++) {
	            mudaEstado(jogo[i][j]);
	        }
	    }
	}

	public void checaAdjacencia(Tile[][] jogo, Tile tile, int x, int y) {
		tile.pretosAdjacentes = 0;
		
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				if(i == 0 && j == 0) continue;
				
				int xMatriz = (x + i + numeroColunas)%numeroColunas;
				int yMatriz = (y + j + numeroLinhas)%numeroLinhas;
				
				if(jogo[yMatriz][xMatriz].ePreto) tile.pretosAdjacentes++;
			}
		}
	}
	
	public void mudaEstado(Tile tile) {
		if(tile.ePreto && tile.pretosAdjacentes < 2 || tile.pretosAdjacentes > 3) {
			tile.ePreto = false;
			tile.setBackground(Color.white);	
		} else if(!tile.ePreto && tile.pretosAdjacentes == 3) {
			tile.ePreto = true;
			tile.setBackground(Color.black);
		}
	}
	
	public void reiniciar(Tile[][] jogo) {
		for (int i = 0; i < numeroLinhas; i++) {
	        for (int j = 0; j < numeroColunas; j++) {
	            jogo[i][j].ePreto = false;
	            jogo[i][j].setBackground(Color.white);
	        }
	    }
		stop();
		geracoes = 0;
		framePrincipal.frame.setTitle("Game of Life: 0");
	}
	
	public void tratarString(String line1, String line2) {
		String[] stringDividida, stringDividida2;
		boolean[][] matrizBooleana;
		String[][] matrizString;
		int numberColumns, numberLines;
		int numeroColunas = 0, numeroLinhas = 0;
	
		stringDividida = line1.split("[=\\,]");
		
		numberColumns = Integer.parseInt(stringDividida[1].trim());
		numberLines = Integer.parseInt(stringDividida[3].trim());
		
		matrizBooleana = new boolean[numberLines][numberColumns];
		
		stringDividida2 = line2.split("[\\$\\!]");
		
		matrizString = new String[stringDividida2.length][];
		
		if(numberColumns > framePrincipal.gridAtiva.numberColumns && numberLines > framePrincipal.gridAtiva.numberLines) {
			criaNovaGrid(numberColumns+10, numberLines+10, framePrincipal);
			this.jogo = framePrincipal.gridAtiva.jogo;
		}
		
		/*for(Tile[] i : jogo) {
			numeroLinhas++;
			numeroColunas = 0;
			for(Tile j : i) {
				numeroColunas++;
			}
		}
		System.out.printf("numeroLinhas: %d \t numeroColunas: %d", numeroLinhas, numeroColunas);*/
	
		preencherMatriz(stringDividida2, matrizString, numberColumns);
		
		criaPadrao(matrizString, matrizBooleana, numberLines, numberColumns);
		
}
		
	
	public void preencherMatriz(String[] stringDividida2, String[][] matrizString, int numeroColunas) {
	    for (int i = 0; i < stringDividida2.length; i++) {
	        int numeroCelulas = 0;
	        StringBuilder linha = new StringBuilder();
	        StringBuilder numero = new StringBuilder();
	       
	        for (int j = 0; j < stringDividida2[i].length(); j++) {
	        	 char c = stringDividida2[i].charAt(j);
	        	 numeroCelulas = completaLinha(c, linha, numero);
	        }
	           

	        for (int l = numeroCelulas; l < numeroColunas; l++) {
	            linha.append("b");
	        }

	        matrizString[i] = linha.toString().split("");
	    }
	}
	
	public int completaLinha(char c, StringBuilder linha, StringBuilder numero) {
		 int numeroCelulas = 0;
		 
         if (Character.isDigit(c)) {
             numero.append(c);
         } else {
             int repeticoes = numero.length() > 0 ? Integer.parseInt(numero.toString()) : 1;
             for (int k = 0; k < repeticoes; k++) {
                 linha.append(c);
                 numeroCelulas++;
             }
             numero.setLength(0);
         }
         return numeroCelulas;
	}

	
	public void criaPadrao(String[][] matrizString, boolean[][] matrizBooleana, int numeroLinhas, int numeroColunas) {
		for(int i =0;i<numeroLinhas;i++) {
			for(int j=0;j<numeroColunas;j++) {
				if(matrizString[i][j].equals("o")) {
					jogo[i][j].ePreto = true;
					jogo[i][j].setBackground(Color.black);
				} else {
					jogo[i][j].ePreto = false;
					jogo[i][j].setBackground(Color.white);
				};
			}
		}
	}
		
	public void criaNovaGrid(int numeroLinhas, int numeroColunas, FramePrincipal framePrincipal) {
		framePrincipal.gridAtiva = new Grid(framePrincipal.painelPrincipal, framePrincipal, numeroLinhas, numeroColunas, 50);
		this.jogo = framePrincipal.gridAtiva.jogo;
	}
}
