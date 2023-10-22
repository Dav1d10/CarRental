package archivo;

public class ArchivoAdminGeneral {


private String tarifaTemporada;
private String Vehiculos;

public ArchivoAdminGeneral(String tarifaTemporada, String Vehiculos) {
    this.tarifaTemporada = tarifaTemporada;
    this.Vehiculos = Vehiculos;

}

public String getTarifaTemporada() {
    return this.tarifaTemporada;
}


public String getVehiculos() {
    return this.Vehiculos;
}

public void setTarifaTemporada(String tarifaTemporada) {
    this.tarifaTemporada = tarifaTemporada;
}


public void setVehiculos(String Vehiculos) {
    this.Vehiculos = Vehiculos;
}

}