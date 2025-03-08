import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelControles extends JPanel {
	
	PainelControles(){
		this.setLayout(null);
		JLabel controles = new JLabel("<html>1: Resume o programa<br>2: Pausa o programa <br>3: Reinicia o programa<html>");
		controles.setBounds(0,0,200,100);
		this.add(controles);
		}
}
