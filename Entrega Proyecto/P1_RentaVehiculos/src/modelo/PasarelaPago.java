package modelo;

import java.io.IOException;

public abstract class PasarelaPago {
    public PasarelaPago() {
    }


    protected abstract void agregarPagos(String numero, String nombre, String precio)throws IOException;



    protected abstract void cargarDatos() throws IOException;


}