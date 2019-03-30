package es.ieslavereda.common;

public class Alumno extends Persona{

	private String NIA;
	private String sexo;
	private String fechaMatricula;
	private String ensenyanza;
	private String cicloFP;
	private String curso;
	private String grupo;
	private String turnoFP;
	private String expGC;
		
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public String getNIA() {
		return NIA;
	}

	public void setNIA(String nIA) {
		NIA = nIA;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getEnsenyanza() {
		return ensenyanza;
	}

	public void setEnsenyanza(String ensenyanza) {
		this.ensenyanza = ensenyanza;
	}

	public String getCicloFP() {
		return cicloFP;
	}

	public void setCicloFP(String cicloFP) {
		this.cicloFP = cicloFP;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTurnoFP() {
		return turnoFP;
	}

	public void setTurnoFP(String turnoFP) {
		this.turnoFP = turnoFP;
	}

	public String getExpGC() {
		return expGC;
	}

	public void setExpGC(String expGC) {
		this.expGC = expGC;
	}

	@Override
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}else if( this.getNIA().compareTo(((Alumno)o).getNIA())==0) {
			return true;
		}else return false;
	}
	
	@Override
	public String toString() {
		return "\nAlumno [\n"+super.toString() +", \nNIA=" + NIA + ", \nsexo=" + sexo + ", \nfechaMatricula=" + fechaMatricula + ", \nensenyanza="
				+ ensenyanza + ", \ncicloFP=" + cicloFP + ", \ncurso=" + curso + ", \ngrupo=" + grupo + ", \nturnoFP=" + turnoFP
				+ ", \nexpGC=" + expGC + "\n]";
	}

	@Override
	public String obtenerIdentificacion() {
		// TODO Auto-generated method stub
		return NIA;
	}

	@Override
	public void establecerIdentificacion(String identificacion) {
		this.NIA=identificacion;		
	}
	
	

}
