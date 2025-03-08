import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FramePrincipal {
	JFrame frame;
	JPanel painelPrincipal;
	PainelControles painelControles = null;
	PainelPadroes painelPadroes = null;
	JMenuBar menuBar;
	JMenu funcionalidades;
	JMenuItem controles,gameOfLife,padroes;
	Grid gridAtiva;
	public int painelAtivo = 0;
	
	FramePrincipal(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setTitle("Game of Life: 0");
		frame.setSize(700,720);
		frame.setLocationRelativeTo(null);
		
		
		menuBar = new JMenuBar();
		funcionalidades = new JMenu("Funcionalidades");
		controles = new JMenuItem("Controles");
		gameOfLife = new JMenuItem("Game Of Life");
		padroes = new JMenuItem("Padrões");
		
		controles.addActionListener(
			  (e) -> {
				  if(painelControles == null) painelControles = new PainelControles();
				  if(painelAtivo != 1) {
					  gridAtiva.originalLogic.stop();
					  removePainelAtivo();
					  frame.add(painelControles);
					  frame.revalidate();
					  frame.repaint();
					  painelAtivo = 1;
				  }

			  }
		  );
		
		gameOfLife.addActionListener(
			(e) -> {
				if(painelAtivo != 0) {
					removePainelAtivo();
					frame.add(painelPrincipal);
					frame.revalidate();
					frame.repaint();
					painelAtivo = 0;
				}
			}
		);
		
		padroes.addActionListener(
			(e) ->{
				if(painelPadroes == null) painelPadroes = new PainelPadroes(FramePrincipal.this);
				if(painelAtivo != 2) {
					gridAtiva.originalLogic.stop();
					removePainelAtivo();
					frame.add(painelPadroes);
					frame.revalidate();
					frame.repaint();
					painelAtivo = 2;
				}
			}
		);
		
		funcionalidades.add(controles);
		funcionalidades.add(gameOfLife);
		funcionalidades.add(padroes);
		menuBar.add(funcionalidades);
		frame.setJMenuBar(menuBar);
		
		
		painelPrincipal = new JPanel();
		
		gridAtiva = new Grid(painelPrincipal, this, 20,20,50);
		
		frame.setVisible(true);
	}
	
	public void removePainelAtivo() {
		switch (painelAtivo) {
		case 0:
			frame.remove(painelPrincipal);
			break;
		case 1:
			frame.remove(painelControles);
			break;
		case 2:
			frame.remove(painelPadroes);
		  }
	}
	
}
