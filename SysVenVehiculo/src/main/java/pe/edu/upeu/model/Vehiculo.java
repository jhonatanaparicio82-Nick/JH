package pe.edu.upeu.model;

import lombok.Data;
import pe.edu.upeu.enums.TipoVehiculo;

@Data
public class Vehiculo {
    private String id;
    private String marca;
    private String modelo;
    private int anho;
    private double precioBase;
    private boolean disponible;
    private TipoVehiculo tipo;

    public Vehiculo(String id, TipoVehiculo tipo, double precioBase,
                    int anho, String modelo, String marca) {
        this.id = id;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.anho = anho;
        this.modelo = modelo;
        this.marca = marca;
        this.disponible=true;
    }
}
