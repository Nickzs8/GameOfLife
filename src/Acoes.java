import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Acoes {
	Logic logic;
	Tile[][] jogo;
	
	StartAction start;	
	StopAction stop;
	ReiniciarAction reiniciar;
	
	Acoes(JPanel panel, Logic originalLogic, Tile[][] jogo){
		this.logic = originalLogic;
		this.jogo = jogo;
		
		start = new StartAction();
		stop = new StopAction();
		reiniciar = new ReiniciarAction();
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "start");
		panel.getActionMap().put("start", start);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "stop");
		panel.getActionMap().put("stop", stop);
		
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "reiniciar");
		panel.getActionMap().put("reiniciar", reiniciar);
	}
	
	public class StartAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			logic.run();
		}
		
	}
	
	public class StopAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			logic.stop();
		}
		
	}
	
	public class ReiniciarAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			logic.reiniciar(jogo);
		}
		
	}
}
