import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField NombreClase;
	private JTextField EntradaTexto;
	
	static ArrayList<clase> clases=new ArrayList<clase>();
	private JButton btnMostrarTodasLas;
	private JTextPane txtpnParaIntroducirUn;
	private JButton btnGenerarSelecionador;
	private JTextField NombreAlumno;
	private JButton btnAadirAlumno;
	private JButton btnMostrarAlumnos;
	private JButton btnNewButton;
	private JButton btnEliminarClase;
	private JTextField txtPonerClasse;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static boolean EmpiezaLetra(String texto) {
        int i;
        for(i=0;i<=9;i++) {
        	if (!(texto.charAt(0)=='i')) {
        		return true;
        	} else {
        		throw new NoEMpiezaPorLetra("No empiza por una letra");
        		
        	}
		}return false;
    }
	
	
	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextPane mostrarClases = new JTextPane();
		
		//String[] array;
		/**String[] array = new String[clases.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = clases.get(i).getNom();
		}**/
		
		JComboBox comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion=comboBox.getSelectedItem()+"";
			}
		});
		comboBox.setBounds(581, 38, 137, 24);
		contentPane.add(comboBox);
		
		
		
		JButton btnAadirClase = new JButton("Añadir clase");
		btnAadirClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String texto= EntradaTexto.getText();
					if(EmpiezaLetra(texto));
					clase clase1 = new clase(texto);
					clases.add(clase1);
					NombreClase.setText(texto);
					comboBox.addItem(texto);
				}catch(NoEMpiezaPorLetra x){
	                System.out.println(x.getMessage());
				
					}

			}
		});
		btnAadirClase.setBounds(12, 38, 164, 25);
		contentPane.add(btnAadirClase);
		
		NombreClase = new JTextField();
		NombreClase.setBounds(26, 93, 114, 19);
		contentPane.add(NombreClase);
		NombreClase.setColumns(10);
		
		EntradaTexto = new JTextField();
		EntradaTexto.setBounds(220, 41, 114, 19);
		contentPane.add(EntradaTexto);
		EntradaTexto.setColumns(10);
		
		
		mostrarClases.setBounds(26, 287, 297, 66);
		contentPane.add(mostrarClases);
		
		btnMostrarTodasLas = new JButton("Mostrar todas las clases");
		btnMostrarTodasLas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<clase> iterator=clases.iterator();
				int contador=0;
				String texto;
				texto="Las clases son las siguientes:";
				while (iterator.hasNext()){
                    contador=contador+1;
                    texto=texto+iterator.next().getNom()+",";              
				}
				mostrarClases.setText(texto);
			
			}
		});
		btnMostrarTodasLas.setBounds(26, 215, 277, 25);
		contentPane.add(btnMostrarTodasLas);
		
		txtpnParaIntroducirUn = new JTextPane();
		txtpnParaIntroducirUn.setText("Para introducir un alumno selecione la clase e introduzca el nombre.");
		txtpnParaIntroducirUn.setBounds(384, 9, 130, 103);
		contentPane.add(txtpnParaIntroducirUn);
		
		NombreAlumno = new JTextField();
		NombreAlumno.setBounds(581, 93, 114, 19);
		contentPane.add(NombreAlumno);
		NombreAlumno.setColumns(10);
		
		btnAadirAlumno = new JButton("Añadir alumno");
		btnAadirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto= NombreAlumno.getText();
				Alumno alumno = new Alumno(texto);
				Iterator<clase> iterator=clases.iterator();
				int contador=0;
				while (iterator.hasNext()){
					clase temp = iterator.next();
                    if(temp.getNom().equals(comboBox.getSelectedItem())) {
                    	temp.añadirAlumnos(alumno);
                    }
				}
			}
		});
		btnAadirAlumno.setBounds(581, 148, 178, 25);
		contentPane.add(btnAadirAlumno);
		
		JTextArea mostrarAlumnos = new JTextArea();
		mostrarAlumnos.setBounds(420, 268, 339, 85);
		contentPane.add(mostrarAlumnos);
		
		btnMostrarAlumnos = new JButton("Mostrar Alumnos");
		btnMostrarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<clase> iterator=clases.iterator();
				String texto="";
				if(iterator.hasNext()==false) {
			           throw new ErrorMostrar("No hi ha clases");
				}
				try{
					while (iterator.hasNext()){
					
					clase Temp=iterator.next();
					
					
                    
					texto=texto+"Los alumnos de la classe "+Temp.getNom() +" son: "+Temp.mostrarAlumnos()+"\n";
                   
                    
					}
					
				} catch (ErrorMostrar a) {
	                texto=(a.getMessage());
	                }
				mostrarAlumnos.setText(texto);
				/**
				Iterator<clase> iterator=clases.iterator();
				String texto="";
				while (iterator.hasNext()){
					clase Temp=iterator.next();
					texto=Temp.mostrarAlumnos();
					}
				
				mostrarAlumnos.setText(texto);
				**/
				
			}
		});
		btnMostrarAlumnos.setBounds(420, 215, 248, 25);
		contentPane.add(btnMostrarAlumnos);
		
		btnNewButton = new JButton("Mostrar clases ordenadas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto=clase.ClasesOrdenadas();
				mostrarClases.setText(texto);
				
				
			}
		});
		btnNewButton.setBounds(26, 178, 277, 25);
		contentPane.add(btnNewButton);
		
		btnEliminarClase = new JButton("Eliminar clase");
		btnEliminarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String 	texto=txtPonerClasse.getText();
				Iterator<clase> iterator=clases.iterator();
				
				try{while (iterator.hasNext()){
					clase Temp=iterator.next();
					if(Temp.getNom().equals(texto)) {
						String nom=Temp.getNom();
						Temp.borrar(nom);
						clases.remove(Temp);
						}
					}
				}catch(Exception i) {}
			}		
		});
		btnEliminarClase.setBounds(12, 128, 164, 25);
		contentPane.add(btnEliminarClase);
		
		txtPonerClasse = new JTextField();
		txtPonerClasse.setText("Poner classe");
		txtPonerClasse.setBounds(230, 131, 114, 19);
		contentPane.add(txtPonerClasse);
		txtPonerClasse.setColumns(10);
		
		
		
		
		
	}
}
