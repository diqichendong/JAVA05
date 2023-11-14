/*
 * Clasa Empleado
 */
package modelo;

import java.util.GregorianCalendar;

public class Empleado {
    
    private int id;
    private int id_jefe;
    private String nombre;
    private double sueldo;
    private GregorianCalendar fecha_incorp;

    public Empleado(int id, int id_jefe, String nombre, double sueldo, GregorianCalendar fecha_incorp){
        this.id = id;
        this.id_jefe = id_jefe;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fecha_incorp = fecha_incorp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(int id_jefe) {
        this.id_jefe = id_jefe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public GregorianCalendar getFecha_incorp() {
        return fecha_incorp;
    }

    public void setFecha_incorp(GregorianCalendar fecha_incorp) {
        this.fecha_incorp = fecha_incorp;
    }
    
    @Override
    public String toString(){
        return id+" - "+nombre+" - "+sueldo;
    }
}
