import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class clase {
	private String nom;
	static ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
	static ArrayList<String> clasesOrdenada=new ArrayList<String>();
	ArrayList<String> alumnosOrdenados=new ArrayList<String>();
	
	public clase(String nom) {
		super();
		this.nom = nom;
		clasesOrdenada.add(nom);
		
	}
	
	public void borrar(String nom) {
		Iterator<String> it = clasesOrdenada.iterator();
		int contador=0;
		while(it.hasNext()) {
			String temp=it.next();
			if(temp.equals(nom)) {
				clasesOrdenada.remove(contador);
				break;
			}
			contador=contador+1;
		  }
		
		
	}
	
	public void añadirAlumnos(Alumno nom) {
		alumnos.add(nom);
		String texto=nom.getNom();
		alumnosOrdenados.add(texto);
	}
	public static String ClasesOrdenadas() {
		String texto=""; 
		Collections.sort(clasesOrdenada);
		  for (String item : clasesOrdenada) {
			  texto="Las clases mostradas de manera ordenada:"+(clasesOrdenada);
	        }
		  return texto;
	}
	
	public  String mostrarAlumnos() {
		String texto="";
		 for (String item : alumnosOrdenados) {
			  texto=(alumnosOrdenados)+"    ";
	        }
		  return texto;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public static ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public static void setAlumnos(ArrayList<Alumno> alumnos) {
		clase.alumnos = alumnos;
	}
	
	
}
