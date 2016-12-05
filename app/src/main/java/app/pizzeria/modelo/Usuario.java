package app.pizzeria.modelo;

/**
 * Created by marlonpya on 1/12/16.
 */

public class Usuario {

    private int id;
    private String usuario;
    private String contrasenia;
    private String dia;
    private String mes;
    private String anio;
    private String genero;

    public Usuario() {}

    public Usuario(int id, String usuario, String contrasenia, String dia, String mes, String anio, String genero) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.genero = genero;
    }

    public Usuario(String usuario, String contrasenia, String dia, String mes, String anio, String genero) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
