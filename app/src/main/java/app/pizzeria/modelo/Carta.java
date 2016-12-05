package app.pizzeria.modelo;

/**
 * Created by marlonpya on 25/11/16.
 */

public class Carta {

    public static final int PIZZA   = 0;
    public static final int PASTAS  = 1;
    public static final int BEBIDAS = 2;
    public static final int OFERTAS = 3;

    private int id_carta;
    private int tipo_carta;
    private String nombre_carta;
    private int imagen_carta;
    private double precio_grande;
    private double precio_familiar;
    private double precio_super_familiar;
    private String detalle;

    public Carta(int id_carta, int tipo_carta, String nombre_carta, int imagen_carta, double precio_grande, double precio_familiar, double precio_super_familiar, String detalle) {
        this.id_carta = id_carta;
        this.tipo_carta = tipo_carta;
        this.nombre_carta = nombre_carta;
        this.imagen_carta = imagen_carta;
        this.precio_grande = precio_grande;
        this.precio_familiar = precio_familiar;
        this.precio_super_familiar = precio_super_familiar;
        this.detalle = detalle;
    }

    public Carta(int tipo_carta, String nombre_carta, int imagen_carta, double precio_grande, double precio_familiar, double precio_super_familiar, String detalle) {
        this.tipo_carta = tipo_carta;
        this.nombre_carta = nombre_carta;
        this.imagen_carta = imagen_carta;
        this.precio_grande = precio_grande;
        this.precio_familiar = precio_familiar;
        this.precio_super_familiar = precio_super_familiar;
        this.detalle = detalle;
    }

    public int getId_carta() {
        return id_carta;
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public int getTipo_carta() {
        return tipo_carta;
    }

    public void setTipo_carta(int tipo_carta) {
        this.tipo_carta = tipo_carta;
    }

    public String getNombre_carta() {
        return nombre_carta;
    }

    public void setNombre_carta(String nombre_carta) {
        this.nombre_carta = nombre_carta;
    }

    public int getImagen_carta() {
        return imagen_carta;
    }

    public void setImagen_carta(int imagen_carta) {
        this.imagen_carta = imagen_carta;
    }

    public double getPrecio_grande() {
        return precio_grande;
    }

    public void setPrecio_grande(double precio_grande) {
        this.precio_grande = precio_grande;
    }

    public double getPrecio_familiar() {
        return precio_familiar;
    }

    public void setPrecio_familiar(double precio_familiar) {
        this.precio_familiar = precio_familiar;
    }

    public double getPrecio_super_familiar() {
        return precio_super_familiar;
    }

    public void setPrecio_super_familiar(double precio_super_familiar) {
        this.precio_super_familiar = precio_super_familiar;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
