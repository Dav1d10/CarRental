package archivo;

public class ArchivoLog {


	    private String Vehiculo;
	    private String fechaCompra;
	    private String fechaAlquiler;
	    private String fechasMantenimiento;

	    public ArchivoLog(String Vehiculo, String fechaCompra, String fechaAlquiler, String fechasMantenimiento) {
	        this.Vehiculo = Vehiculo;
	        this.fechaCompra = fechaCompra;
	        this.fechaAlquiler = fechaAlquiler;
	        this.fechasMantenimiento = fechasMantenimiento;

	    }

	    public String getVehiculo() {
	        return this.Vehiculo;
	    }


	    public String getFechaCompra() {
	        return this.fechaCompra;
	    }


	    public String getFechaAlquiler() {
	        return this.fechaAlquiler;
	    }

	    public String getfechasMantenimiento() {
	        return this.fechasMantenimiento;
	    }

	    public void setVehiculo(String Vehiculo) {
	        this.Vehiculo = Vehiculo;
	    }


	    public void setFechaCompra(String fechaCompra) {
	        this.fechaCompra = fechaCompra;
	    }

	    public void setfechaAlquiler( String fechaAlquiler) {
	        this.fechaAlquiler = fechaAlquiler;
	    }

	    public void setFechasMantenimiento( String fechasMantenimiento) {
	        this.fechasMantenimiento = fechasMantenimiento;
	    }
	
}