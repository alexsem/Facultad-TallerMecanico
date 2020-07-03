package views;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import utils.Helper;

import views.Handler;
import views.LabelAndTextPanel;

@SuppressWarnings("serial")
public class AutoPartesPanel extends JPanel {
	
	private JFrame frame; 
	static JTable tabla = new JTable(){
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    }; //Tabla para armar la lista de auto partes
	DefaultTableModel model;

	public AutoPartesPanel(JFrame frame) {
		this.frame = frame;
	};
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
	
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JPanel listarAutoPartesPanel() {
		JPanel autoPartesPanel = new JPanel();
		JPanel autoPartesBotones = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		JButton autoPartesInsertar = new JButton("Insertar Nuevo");
		JButton autoPartesActualizar = new JButton("Actualizar");
		JButton autoPartesBorrar = new JButton("Borrar");
		
		autoPartesPanel.setLayout(new BoxLayout(autoPartesPanel, BoxLayout.Y_AXIS));
		autoPartesBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		DefaultTableModel model = new DefaultTableModel();
		
		model = refrescarTablaAutoPartes(model);	
		
		tabla.setModel(model);
		
		autoPartesInsertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Insertar Auto Partes");
				
				Helper.createNewFrame(getFrame(), insertarAutoPartesPanel(tabla));
				getFrame().pack();
				getFrame().setVisible(true);
			}
		});
		
		autoPartesActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Actualizar Auto Partes");
				
				int row = tabla.getSelectedRow();
				if (row >= 0) {
					String idAutoParte = (String) tabla.getValueAt(row, 0);
					String descripcionAutoParte = (String) tabla.getValueAt(row, 1);
					String cantidadAutoParte = (String) tabla.getValueAt(row, 2);
					String costoAutoParte = (String) tabla.getValueAt(row, 3);
					
					Helper.createNewFrame(getFrame(), actualizarAutoPartesPanel(idAutoParte, descripcionAutoParte, cantidadAutoParte, costoAutoParte));
					getFrame().pack();
					getFrame().setVisible(true);
				} else {
					Helper.messageBox("Elija un registro");
				}
			}
		});
		
		autoPartesBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Borrar Auto Partes");

				int row = tabla.getSelectedRow();
				if (row >= 0) {
					Handler handler = new Handler();
					String idAutoParte = (String) tabla.getValueAt(row, 0);
					
					if(handler.borrarAutoParte(idAutoParte)) {
						Helper.messageBox("Se borro el registro con exito");
						getModel().removeRow(row);
						getModel().fireTableDataChanged();
						System.out.println("Se borro la auto parte con ID: " + idAutoParte);	
						
					} else {
						Helper.messageBox("Hubo un problema al borrar el registro");
					}
				} else {
					Helper.messageBox("Elija un registro");
				}
			}
		});

		autoPartesBotones.add(autoPartesInsertar);
		autoPartesBotones.add(autoPartesActualizar);
		autoPartesBotones.add(autoPartesBorrar);
		scrollPane.setViewportView(tabla);
		
		autoPartesPanel.add(scrollPane);
		autoPartesPanel.add(autoPartesBotones);
		
		return autoPartesPanel;
	}	
	
	public JPanel insertarAutoPartesPanel(JTable tabla) {
		JPanel autoPartesPanel = new JPanel();
		autoPartesPanel.setLayout(new BoxLayout(autoPartesPanel, BoxLayout.Y_AXIS));
		
		LabelAndTextPanel descripcionAutoPartePanel = new LabelAndTextPanel("Descripcion: ", "");
		LabelAndTextPanel cantidadAutoPartePanel = new LabelAndTextPanel("Cantidad: ", "");
		LabelAndTextPanel costoAutoPartePanel = new LabelAndTextPanel("Costo: ", "");
		
		//Botones
		JButton insertarAutoParteBoton = new JButton("Insertar");
		JPanel botonesAutoPartePanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		insertarAutoParteBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(descripcionAutoPartePanel.getTexto().getText().equals("") || 
						cantidadAutoPartePanel.getTexto().getText().equals("") || 
						costoAutoPartePanel.getTexto().getText().equals("")) {
					Helper.messageBox("Se debe completar todos los campos");
				} else {
					System.out.println("Se inserta una auto parte");
					System.out.println("Descripcion: " + descripcionAutoPartePanel.getTexto().getText());
					System.out.println("Cantidad: " + cantidadAutoPartePanel.getTexto().getText());
					System.out.println("Costo: " + costoAutoPartePanel.getTexto().getText());
					
					Handler handler = new Handler();
					
					handler.insertarAutoPartesHandler(descripcionAutoPartePanel.getTexto().getText(), 
							cantidadAutoPartePanel.getTexto().getText(), 
							costoAutoPartePanel.getTexto().getText());
					
					Helper.createNewFrame(getFrame(), listarAutoPartesPanel());
					getFrame().pack();
					getFrame().setVisible(true);
				}
			}
		});
		
		botonesAutoPartePanel.add(insertarAutoParteBoton);
		
		// Armo el Panel Principal
		autoPartesPanel.add(descripcionAutoPartePanel.getPanel());
		autoPartesPanel.add(cantidadAutoPartePanel.getPanel());
		autoPartesPanel.add(costoAutoPartePanel.getPanel());
		autoPartesPanel.add(botonesAutoPartePanel);
		
		
		return autoPartesPanel;
	}
	
	public JPanel actualizarAutoPartesPanel(String id, String descripcion, String cantidad, String costo) {
		JPanel autoPartesPanel = new JPanel();
		autoPartesPanel.setLayout(new BoxLayout(autoPartesPanel, BoxLayout.Y_AXIS));
		
		LabelAndTextPanel descripcionAutoPartePanel = new LabelAndTextPanel("Descripcion: ", descripcion);
		LabelAndTextPanel cantidadAutoPartePanel = new LabelAndTextPanel("Cantidad: ", cantidad);
		LabelAndTextPanel costoAutoPartePanel = new LabelAndTextPanel("Costo: ", costo);
		
		//Botones
		JButton actualizarAutoParteBoton = new JButton("Actualizar");
		JPanel botonesAutoPartePanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		actualizarAutoParteBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(descripcionAutoPartePanel.getTexto().getText().equals("") || 
						cantidadAutoPartePanel.getTexto().getText().equals("") || 
						costoAutoPartePanel.getTexto().getText().equals("")) {
					Helper.messageBox("Se debe completar todos los campos");
				} else {
					System.out.println("Se actualiza una auto parte");
					System.out.println("Descripcion: " + descripcionAutoPartePanel.getTexto().getText());
					System.out.println("Cantidad: " + cantidadAutoPartePanel.getTexto().getText());
					System.out.println("Costo: " + costoAutoPartePanel.getTexto().getText());
					
					Handler handler = new Handler();
					
					handler.actualizarAutoPartesHandler(
							id,
							descripcionAutoPartePanel.getTexto().getText(), 
							cantidadAutoPartePanel.getTexto().getText(), 
							costoAutoPartePanel.getTexto().getText());
					
					Helper.messageBox("Se actualizo el registro con exito.");
					
					Helper.createNewFrame(getFrame(), listarAutoPartesPanel());
					getFrame().pack();
					getFrame().setVisible(true);
				}
			}
		});
		
		botonesAutoPartePanel.add(actualizarAutoParteBoton);
		
		// Armo el Panel Principal
		autoPartesPanel.add(descripcionAutoPartePanel.getPanel());
		autoPartesPanel.add(cantidadAutoPartePanel.getPanel());
		autoPartesPanel.add(costoAutoPartePanel.getPanel());
		autoPartesPanel.add(botonesAutoPartePanel);
		
		
		return autoPartesPanel;
	}
	
	public DefaultTableModel refrescarTablaAutoPartes(DefaultTableModel model) {
		Handler handler = new Handler();
		
		String[] columnNames = {"ID Auto Parte",
                "Descripcion",
                "Cantidad Disponible",
                "Costo"};

		ArrayList<String[]> datosAutoPartes;
		
		datosAutoPartes = handler.listarAutoPartesHandler();
		
		model.setColumnIdentifiers(columnNames);
		
		for(int i = 0; i < datosAutoPartes.size(); i++) {
			String[] fila = datosAutoPartes.get(i);
			model.addRow(fila);
		}
		
		return model;
		
	}
}
