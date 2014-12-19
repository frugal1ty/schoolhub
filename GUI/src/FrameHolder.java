import javax.swing.JButton;
import javax.swing.JFrame;


public class FrameHolder {

	private JFrame frame;
	
	public FrameHolder(){
		this.frame = new JFrame("Hello World!");//Fenster, mit Beschriftung
		JButton button = new JButton("Hello World");
		this.frame.add(button);
		//Reihenfolge ist wichtig: erst Gr��e, dann Mitte ermitteln.
		this.frame.pack(); //Minimale gr��e des Fensters, angepasst an den Inhalt
		this.frame.setLocationRelativeTo(null); //Anordnung von Fenstern zueinander, null setzt das Fenster in die Mitte des Bildschirms.
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Funktion des Roten-X, Fenster schlie�en oder ganzens Programm
		this.frame.setVisible(true);//Fenster wird sichtbar
	}
}