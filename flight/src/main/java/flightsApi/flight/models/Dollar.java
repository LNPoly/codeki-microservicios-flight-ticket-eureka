package flightsApi.flight.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Dollar {

    public String moneda;

    public String casa;

    public String nombre;

    public double compra;

    public double venta;

    public LocalDateTime fechaActualizacion;

    public double getPromedio(){
        return ((getCompra() + getVenta())/2);
    }
}
