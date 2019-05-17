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
		conf.setLdapPassword("1111");
		conf.guardar();
		
		ArrayList<Persona> listado = new ArrayList<Persona>();
		
		LDAP ldap = new LDAP();
	
		String DNI="053052298S";
		
		//Listar miembros de un grupo
		listado = ldap.memberOf("Docente");
		System.out.println(listado);
		
		// Obtener un profesor por DNI
		Profesor p = new Profesor();
		p.establecerIdentificacion(DNI);
		ldap.obtenerUsuarioLDAP(p);
		System.out.println(p);
		visualizarFoto(p.getFoto());
		
		// Obtener una persona por uid
		Persona persona = new Profesor();
		persona.setUid("jalonso");
		ldap.obtenerUsuarioLDAPByUID(persona);
		System.out.println(persona);
		
		// Obtener si una busqueda produce resultado
		System.out.println("Existe el usuario jalonso?:" + ldap.search("ou=Users", "uid=jalonso"));
		
		// Obtener el atributo de una busqueda
		System.out.println("Mail del usuario con uid=joaalsai -> " + ldap.searchAttribute("ou=Users", "uid=jalonso", "mail"));

		// Obtener la foto de un usuario por uid
		visualizarFoto(ldap.obtenerFoto("jalonso"));
		
		conf.setLdapPassword("ldapPassword");
		conf.guardar();
				
	}
	

}
