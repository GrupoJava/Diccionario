/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos
 * Sección: 10
 * 20/08/2015
 * Hoja de Trabajo 4
 *
 */

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;


/**
 * Esta es la clase InterfazGrafica y muestra una Interfaz
 * mas amigable con el usuario al tener un botón para buscar el
 * archivo deseado para realizar las operacinoes. Busca el archivo
 * y tienen otro botón que permite realizar el cálculo de la operacion.
 * Por útltimo, tiene un área de texto en el cual muestra el resultado
 * de la operación.
 * 
 * @author Rudy Garrido 
 * @author Yosemite Meléndez
 *
 */
public class InterfazGrafica {

	private JFrame frame;
	private Evento evento = new Evento();
	private JSlider slider;
	private JLabel label;
	private JTextField textField;
	private JFileChooser fc;
	private File file;
	private JButton btnSeleccionarArchivo;
	private JButton buttonCalcular;
	private JTextArea textArea;
	private int metodo=1;
	private JTextField txtTextoATraducir;
	private JButton btnSeleccionarTexto;
	private JButton btnTraducirTexto;
	private JTextArea textArea_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InterfazGrafica(){
		initialize();
	}
	/**
	 * Crea los elementos de la interfaz gráfica.
	 *El frame principal, etiquetas para nombre y 
	 *resultado, botones buscar archivo y calcular 
	 *y un área de texto para mostrar el resultado.
	 */
	public void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCalculadoraPostfix = new JLabel("Diccionario Traductor");
		lblCalculadoraPostfix.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblCalculadoraPostfix.setBounds(10, 11, 633, 106);
		frame.getContentPane().add(lblCalculadoraPostfix);
		
		btnSeleccionarArchivo = new JButton("Seleccionar Diccionario");
		btnSeleccionarArchivo.setBounds(294, 128, 191, 23);
		btnSeleccionarArchivo.addActionListener(evento);
		frame.getContentPane().add(btnSeleccionarArchivo);
		
		textField = new JTextField();
		textField.setBounds(20, 128, 264, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		buttonCalcular = new JButton("Agregar Diccionario");
		buttonCalcular.setBounds(495, 128, 162, 23);
		buttonCalcular.addActionListener(evento);
		frame.getContentPane().add(buttonCalcular);
		
		JLabel lblResultados = new JLabel("Texto Traducido");
		lblResultados.setBounds(20, 199, 125, 21);
		frame.getContentPane().add(lblResultados);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 218, 351, 113);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		txtTextoATraducir = new JTextField();
		txtTextoATraducir.setBounds(20, 162, 264, 20);
		frame.getContentPane().add(txtTextoATraducir);
		txtTextoATraducir.setColumns(10);
		
		btnSeleccionarTexto = new JButton("Seleccionar Texto");
		btnSeleccionarTexto.setBounds(294, 161, 191, 23);
		btnSeleccionarTexto.addActionListener(evento);
		frame.getContentPane().add(btnSeleccionarTexto);
		
		btnTraducirTexto = new JButton("Traducir Texto");
		btnTraducirTexto.setBounds(495, 161, 162, 23);
		btnTraducirTexto.addActionListener(evento);
		frame.getContentPane().add(btnTraducirTexto);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(381, 218, 276, 113);
		frame.getContentPane().add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblDiccionario = new JLabel("Diccionario");
		lblDiccionario.setBounds(381, 202, 104, 14);
		frame.getContentPane().add(lblDiccionario);
		
		fc = new JFileChooser();
		
		
	}
	private class Evento implements ActionListener{
		private ManejadorDePalabras manejador = new ManejadorDePalabras();
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==btnSeleccionarArchivo){
				int returnVal = fc.showOpenDialog(frame);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = fc.getSelectedFile();
		            textField.setText(file.getAbsolutePath());
		        } 
			}else if(a.getSource() == btnSeleccionarTexto){
				int returnVal = fc.showOpenDialog(frame);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = fc.getSelectedFile();
		            txtTextoATraducir.setText(file.getAbsolutePath());
		        } 
			}else if(a.getSource() == btnTraducirTexto){
				try {
					textArea.setText(manejador.traducir(txtTextoATraducir.getText().toString()));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(a.getSource() == buttonCalcular){
				try {
					manejador.leerDiccionario(textField.getText().toString());
					manejador.getArbol().recorrerArbol(manejador.getArbol().getRoot());
					textArea_1.setText(manejador.getArbol().getDiccionario());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}