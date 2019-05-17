package test;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import es.ieslavereda.common.Alumno;
import es.ieslavereda.common.Persona;
import es.ieslavereda.common.Profesor;
import es.ieslavereda.configuracion.ConfiguracionSegura;
import es.ieslavereda.ldap.LDAP;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfiguracionSegura conf = new ConfiguracionSegura();
		
		ArrayList<Persona> listado = new ArrayList<Persona>();
		
		LDAP ldap = new LDAP();
	
		//Listar miembros de un grupo
		listado = ldap.memberOf("Docente");
		System.out.println(listado);
				
		// Autentificamos el usuario		
		System.out.println("Es correcto el password:"+ldap.autenticacionLDAP("jfajardo", "1111"));;
		




				
	}


}
