import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JLabel;

public class LabelPadroes extends JLabel{
	
	JLabel label;
	String nome;
	ArquivosPadroes arquivos = new ArquivosPadroes();
	File arquivoPadrao;
	PainelPadroes painelOriginal;
	
	
	LabelPadroes(int numeroPagina, int posicao, PainelPadroes painelOriginal){
			this.nome = "Padrão numero " + posicao;
			this.label = new JLabel(nome);
			this.painelOriginal = painelOriginal;
			
			Dimension dimensao = label.getPreferredSize();
			label.setBounds(dimensao.width*posicao, dimensao.height, dimensao.width,dimensao.height);
			
			arquivos.getFile(this, posicao);
			
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					painelOriginal.selecionaArquivo(LabelPadroes.this.arquivoPadrao);
					label.setForeground(Color.black);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					label.setForeground(Color.LIGHT_GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					label.setForeground(Color.black);
				}
			});
	}
}
// quero adicionar logica e leitor em painelControles