package es.ieslavereda.ldap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configuracion {

	private final String FICHERO = "default.config.properties";

	private Properties prop;

	// Propiedades para la BD
	private String host;
	private String port;
	private String user;
	private String password;
	private String database;

	// Propiedades para LDAP
	private String ldapUsername;
	private String ldapPassword;
	private String servername;
	private String shema_base;

	/**
	 * Genera un objeto para el almacenaje de propiedades, utilizando el fichero
	 * default.config.properties
	 */
	public Configuracion() {
		prop = new Properties();
		OutputStream output = null;

		File fc = new File(FICHERO);

		if (!fc.isFile()) {
			try {

				output = new FileOutputStream(FICHERO);

				// Propiedades de la conexion a la Base de datos
				prop.setProperty("host", "127.0.0.1");
				prop.setProperty("port", "3306");
				prop.setProperty("database", "database");
				prop.setProperty("user", "user");
				prop.setProperty("password", "password");
				
				// Propiedades para LDAP
				prop.setProperty("ldapUsername", "cn=admin,dc=ieslavereda,dc=local");
				prop.setProperty("ldapPassword", "passwordForLDAP");
				prop.setProperty("servername", "ldap://10.0.0.243:389");
				prop.setProperty("shema_base", "dc=ieslavereda,dc=local");

				// save properties to project root folder
				prop.store(output, null);

			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		// Cargamos las propiedades
		cargar();
	}

	/**
	 * Guarda la configuracion almacenada en el fichero
	 * default.config.properties
	 * 
	 * @return True si se ha podido almacenar.
	 */
	public boolean guardar() {
		boolean guardado = false;

		OutputStream output = null;

		if (new File(FICHERO).exists()) {
			try {

				output = new FileOutputStream(FICHERO);
				prop = new Properties();

				// Propiedades para la BD
				prop.setProperty("host", host);
				prop.setProperty("port", port);
				prop.setProperty("database", database);
				prop.setProperty("user", user);
				prop.setProperty("password", password);

				// Propiedades para LDAP
				prop.setProperty("ldapUsername", ldapUsername);
				prop.setProperty("ldapPassword", ldapPassword);
				prop.setProperty("servername", servername);
				prop.setProperty("shema_base", shema_base);

				// save properties to project root folder
				prop.store(output, null);
				guardado = true;

				return guardado;

			} catch (IOException io) {
				io.printStackTrace();
				return guardado;
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
		return guardado;
	}

	private void cargar() {

		prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(FICHERO);

			// Cargar archivo propiedades
			prop.load(input);

			// Obtener propiedades de la base de datos
			this.host = prop.getProperty("host");
			this.port = prop.getProperty("port");
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
			this.database = prop.getProperty("database");

			// Obtener propiedades de LDAP
			this.ldapUsername = prop.getProperty("ldapUsername");
			this.ldapPassword = prop.getProperty("ldapPassword");
			this.servername = prop.getProperty("servername");
			this.shema_base = prop.getProperty("shema_base");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @return the prop
	 */
	public Properties getProp() {
		return prop;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param database
	 *            the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * @return the ldapUsername
	 */
	public String getLdapUsername() {
		return ldapUsername;
	}

	/**
	 * @return the ldapPassword
	 */
	public String getLdapPassword() {
		return ldapPassword;
	}

	/**
	 * @return the servername
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * @return the shema_base
	 */
	public String getShema_base() {
		return shema_base;
	}

	/**
	 * @param ldapUsername
	 *            the ldapUsername to set
	 */
	public void setLdapUsername(String ldapUsername) {
		this.ldapUsername = ldapUsername;
	}

	/**
	 * @param ldapPassword
	 *            the ldapPassword to set
	 */
	public void setLdapPassword(String ldapPassword) {
		this.ldapPassword = ldapPassword;
	}

	/**
	 * @param servername
	 *            the servername to set
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * @param shema_base
	 *            the shema_base to set
	 */
	public void setShema_base(String shema_base) {
		this.shema_base = shema_base;
	}

}
