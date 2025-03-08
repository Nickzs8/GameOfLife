import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PainelPadroes extends JPanel{
	int numeroPagina = 1;
	ArrayList<LabelPadroes> labelPadroes = new ArrayList<LabelPadroes>();
	Leitor leitor;
	FramePrincipal framePrincipal;
	
	
	PainelPadroes(FramePrincipal framePrincipal){
		this.framePrincipal = framePrincipal;
		
		leitor = new Leitor(framePrincipal.gridAtiva.originalLogic);
		
		criaPadroes();
	}
	
	public void criaPadroes() {
			for(int i =0;i<6;i++) {
				labelPadroes.add(new LabelPadroes(numeroPagina, i, this));
				this.add(labelPadroes.get(i).label);
				}
	}
	
	public void selecionaArquivo(File arquivoPadrao) {
		framePrincipal.removePainelAtivo();
		framePrincipal.frame.add(framePrincipal.painelPrincipal);
		framePrincipal.frame.revalidate();
		framePrincipal.frame.repaint();
		framePrincipal.gridAtiva.originalLogic.reiniciar(framePrincipal.gridAtiva.jogo);
		
		leitor.lerArquivo(arquivoPadrao);
		framePrincipal.painelAtivo = 0;
	}
}
