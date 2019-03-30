# LDAPClase
Proyecto con las clases necesarias, para el proyecto de la 3ª evaluacion de 1ºDAW, 
que permiten el acceso a una estructura de directorio LDAP igual a la utilizada en el centro IES La Vereda.
Entre los metodos disponibles esta:
* **public boolean search(String searchBase, String searchFilter)**

Devuelve true/false para la busqueda realizada
* **public boolean autenticacionLDAP(String usuario, String password)**

Devuelve true/false si el proceso de autentificacion se realiza con exito
* **public byte[] obtenerFoto(String uid)**

Se obtiene la foto del usuario con uid pasado por parametro
* **public String searchAttribute(String searchBase, String searchFilter, String attributeID)**

Se desvuelve el texto que contiene el atributo de la busqueda
* **public boolean obtenerUsuarioLDAPByUID(Persona persona)**

Se obtiene los datos de la persona segun su uid
* **public boolean obtenerUsuarioLDAP(Persona persona)**

Se obtiene los datos de la persona segun su NIA(Alumno) o DNI(Profesor)
* **public boolean existeLogin(String username) throws NamingException**

Se devuelve true/false si ese login existe en la base de datos
* **public ArrayList<Persona> memberOf(String grupo)**

Se devuelve un ArrayList con todas las personas que son miembros del grupo pasado por parametro
