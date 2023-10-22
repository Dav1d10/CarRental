package archivo;

public class ArchivoInventario {
	private String Vehiculo;
    private String Categoria;
    private String sedeActual;

    public ArchivoInventario(String Vehiculo, String Categoria, String sedeActual) {
        this.Vehiculo = Vehiculo;
        this.Categoria = Categoria;
        this.sedeActual = sedeActual;

    }

    public String getVehiculo() {
        return this.Vehiculo;
    }


    public String getCategoria() {
        return this.Categoria;
    }


    public String getSedeActual() {
        return this.sedeActual;
    }

    public void setVehiculo(String Vehiculo) {
        this.Vehiculo = Vehiculo;
    }


    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }


    public void setSedeActual( String sedeActual) {
        this.sedeActual = sedeActual;
    }
}
