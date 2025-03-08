import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Tile extends JPanel implements MouseListener{
	int x, y, pretosAdjacentes;
	boolean ePreto = false; 
	
	Tile(int x, int y, JPanel painelPrincipal, Logic originalLogic, Tile[][] jogoOriginal){
		
		this.x = x;
		this.y = y;
		
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		this.addMouseListener(this);
		
		painelPrincipal.add(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!this.ePreto) {
		this.ePreto = true;
		this.setBackground(Color.black);
		} else {
			this.ePreto = false;
			this.setBackground(Color.white);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	/*	Timer timer;
		
		if(timer == null) {
			timer = new Timer(100, e -> {
			   mouseClicked();
			});
			timer.start();
		} else timer.start();*/
	} 

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));		
	}
}
