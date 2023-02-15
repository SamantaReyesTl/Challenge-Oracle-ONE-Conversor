package com.conversor.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.conversor.controller.Option;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversorUI extends JFrame {

	private JPanel contentPane;
	private JTextField cantidadA;
	private JTextField cantidadC;
	private JComboBox paisRecibido;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorUI frame = new ConversorUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorUI() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setBounds(10, 23, 113, 20);
		contentPane.add(lblNewLabel);
		
		cantidadA = new JTextField();
		cantidadA.setBounds(10, 50, 240, 21);
		contentPane.add(cantidadA);
		cantidadA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Convertido a ");
		lblNewLabel_1.setBounds(10, 127, 113, 20);
		contentPane.add(lblNewLabel_1);
		
		cantidadC = new JTextField();
		cantidadC.setBounds(10, 150, 240, 20);
		contentPane.add(cantidadC);
		cantidadC.setColumns(10);
		
		//JComboBox de arriba
		JComboBox paisA = new JComboBox();
		paisA.setModel(new DefaultComboBoxModel(new String[] {"Dollar", "Euro", "Libra Esterlina", "Won sur Coreano", "Yen", "Peso Colombiano", "Peso Mexicano"}));
		paisA.setSelectedIndex(5);
		paisA.setBounds(273, 49, 140, 22);
		paisA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { //lógica de opciones
				if ("Peso Mexicano" == paisA.getSelectedItem().toString()) {
					paisRecibido.setEnabled(true);
					paisRecibido.setSelectedItem("Dollar");
					
				} else {
					paisRecibido.setSelectedItem("Peso Mexicano");
					paisRecibido.setEnabled(false);
				}
			}
		});
		contentPane.add(paisA);
		
		//JButton convertir
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cantidad = cantidadA.getText();
				String seleccionArriba = paisA.getSelectedItem().toString();
				String seleccionAbajo = paisRecibido.getSelectedItem().toString();
				
				if (seleccionArriba.equals("Peso Mexicano")) {	//lógica del clic
					double resultado = Option.conversionA(Option.sellection(seleccionAbajo), Double.valueOf(cantidad));
					cantidadC.setText(String.valueOf(resultado));
				} else {
					double resultado = Option.conversionTo(Option.sellection(seleccionArriba), Double.valueOf(cantidad));
					cantidadC.setText(String.valueOf(resultado));
				}
				
			}
		});
		btnNewButton.setBounds(145, 195, 172, 40);	
		contentPane.add(btnNewButton);
		
		//JComboBox de abajo
		paisRecibido = new JComboBox();
		paisRecibido.setModel(new DefaultComboBoxModel(new String[] {"Dollar", "Euro", "Libra Esterlina", 
																	"Won sur Coreano", "Yen", "Peso Colombiano", 
																	"Peso Mexicano"}));
		paisRecibido.setBounds(273, 149, 140, 22);
		paisRecibido.setSelectedItem("Peso Mexicano");
		paisRecibido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	//lógica de seleccion
				if ("Peso Mexicano" != paisRecibido.getSelectedItem().toString()) {
					paisA.setEnabled(true);
				} else if ("Peso Mexicano" == paisRecibido.getSelectedItem().toString() && "Peso Mexicano" == paisA.getSelectedItem().toString()) {
					paisRecibido.setSelectedItem("Dollar");
				}
			}
		});
		contentPane.add(paisRecibido);
		//Opcion por defecto
		paisA.setSelectedItem("Peso Mexicano");
		
	}
}
