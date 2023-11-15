package archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import modelo.DatosTarjetaCredito;

public class ArchivoPagos {

    private String numeroTarjeta;
    private String fechaVencimiento;
    private String cvv;
    private String banco;
    private static String nombreArchivo = "data/pagos.txt";

    public ArchivoPagos() {

    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }


    public static void agregarArchivo(DatosTarjetaCredito tarjeta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String datos = "El numero de la tarjeta es " + tarjeta.getNumeroTarjeta() + " , la fecha de vencimiento es " 
        + tarjeta.getFechaVencimiento() + " , el cvv es " + tarjeta.getCvv() + " , el banco es " + tarjeta.getBanco();
            writer.newLine(); 
            writer.write(datos);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    
    public static void agregarPrecio(int precio) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String datos = "El precio que se debe pagar con esa tarjeta es:  " + precio;
            writer.newLine(); 
            writer.write(datos);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }


}

