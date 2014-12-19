import javax.swing.JButton;
import javax.swing.JFrame;


public class FrameHolderwCtrl {

	private JFrame frame;
	
	public FrameHolderwCtrl(){
		this.frame = new JFrame("Z�hlknopf!");
		JButton button = new JButton("geklickt: 0");
		//Dem Button wird ein neues ActionListener Objekt hinzugef�gt.
		button.addActionListener(new ClickCountListender(button));
		this.frame.add(button);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}
}
