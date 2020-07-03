package views;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LabelAndTextPanel extends JPanel{

	private JLabel label = new JLabel();
	private JTextField texto = new JTextField("", 10);
	private JPanel panel =  new JPanel(new FlowLayout(FlowLayout.LEFT));

	public LabelAndTextPanel(String nombreLabel, String valorTexto) {
		super();
		setLabel(nombreLabel);
		setTexto(valorTexto);
		setPanel();
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(String nombreLabel) {
		this.label.setText(nombreLabel);
	}
	public String getText() {
		return texto.getText();
	}
	
	public JTextField getTexto() {
		return texto;
	}
	public void setTexto(String valorTexto) {
		this.texto.setText(valorTexto);
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel() {
		this.panel.add(getLabel());
		this.panel.add(getTexto());
	}
	
}
