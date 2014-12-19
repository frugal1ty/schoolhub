import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ClickCountListender implements ActionListener{

	private int clickcounter = 0;
	private final JButton button;
	
	public ClickCountListender(JButton button){
		this.button=button;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		this.button.setText("geklickt: " + ++clickcounter);
		
	}
}