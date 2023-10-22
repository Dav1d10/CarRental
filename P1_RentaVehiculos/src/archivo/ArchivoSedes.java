package archivo;

public class ArchivoSedes {
    private String administradorGeneral;
    private String nombreSede;
    private String Ubicacion;
    private String horarioAtencion;

    public ArchivoSedes(String administradorGeneral, String nombreSede, String Ubicacion, String horarioAtencion) {
        this.administradorGeneral = administradorGeneral;
        this.nombreSede = nombreSede;
        this.horarioAtencion = horarioAtencion;
        this.Ubicacion = Ubicacion;

    }

    public String getadministradorGeneral() {
        return this.administradorGeneral;
    }


    public String getnombreSede() {
        return this.nombreSede;
    }


    public String getUbicacion() {
        return this.Ubicacion;
    }

    public String getHorarioAtencion() {
        return this.horarioAtencion;
    }

    public void setAdministradorGeneral(String administradorGeneral) {
        this.administradorGeneral = administradorGeneral;
    }


    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public void setUbicacion( String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public void setHorarioAtencion( String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

}
