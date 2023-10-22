package archivo;

public class ArchivoPagos {
	 	private String duracionAlquiler;
	    private String Seguros;
	    private String sedeEntrega;
	    private String sedeDevolucion;
	    private String conductorAdicional;
	    private String cobroFinal;

	    public ArchivoPagos(String duracionAlquiler, String Seguros, String sedeEntrega, String sedeDevolucion, String condutorAdicional, String cobroFinal) {
	        this.duracionAlquiler = duracionAlquiler;
	        this.Seguros = Seguros;
	        this.sedeEntrega = sedeEntrega;
	        this.sedeDevolucion = sedeDevolucion;
	        this.conductorAdicional = condutorAdicional;
	        this.cobroFinal = cobroFinal;

	    }

	    public String getDuracionAlquiler() {
	        return this.duracionAlquiler;
	    }


	    public String getSeguros() {
	        return this.Seguros;
	    }


	    public String getSedeEntrega() {
	        return this.sedeEntrega;
	    }

	    public String getSedeDevolucion() {
	        return this.sedeDevolucion;
	    }

	    public String getConductorAdicional() {
	        return this.conductorAdicional;
	    }

	    public String getCobroFinal() {
	        return this.cobroFinal;
	    }

	    public void setDuracionAlquiler(String duracionAlquiler) {
	        this.duracionAlquiler = duracionAlquiler;
	    }

	    public void setSeguros(String Seguros) {
	        this.Seguros = Seguros;
	    }

	    public void setSedeEntrega( String sedeEntrega) {
	        this.sedeEntrega = sedeEntrega;
	    }

	    public void setSedeDevolucion( String sedeDevolucion) {
	        this.sedeDevolucion = sedeDevolucion;
	    }

	    public void setConductorAdicional( String conductorAdicional) {
	        this.conductorAdicional = conductorAdicional;
	    }

	    public void setCobroFinal( String cobroFinal) {
	        this.cobroFinal = cobroFinal;
	    }
}

