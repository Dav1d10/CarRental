package modelo;

import java.io.IOException;

public class EleccionPasarela {
    private PasarelaPago pasarela;
    public EleccionPasarela(String clasepasarela,String numeroTarjeta, String nombre, String precio) {
        try {
            Class<?> clase = Class.forName(clasepasarela);
            pasarela = (PasarelaPago)clase.getDeclaredConstructor().newInstance(null);

            pasarela.cargarDatos();
            pasarela.agregarPagos(numeroTarjeta, nombre, precio);
        }
        catch (IOException e)
        {
        System.out.println("Hubo un error de lectura");
        e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
        System.out.println("No existe la clase " + clasepasarela);
        }
        catch (Exception e)
        {
        System.out.println("Hubo otro error construyendo la agenda telefónica: " + e.getMessage());
        e.printStackTrace();
        }
    }

}