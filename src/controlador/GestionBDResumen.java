/*
 * Gestion de las consultas del panel resumen
 */
package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import modelo.Empleado;
import modelo.Jefe;

/**
 *
 * @author Di Qi
 */
public class GestionBDResumen {

    private Connection conexion;
    private Jefe jefe;

    public GestionBDResumen(Connection conexion, Jefe jefe) {
        this.conexion = conexion;
        this.jefe = jefe;
    }

    /**
     * Obterner una lista de empleados de un jefe
     * @return lista
     * @throws SQLException 
     */
    public List<Empleado> getListaEmpleados() throws SQLException {
        List<Empleado> res = new ArrayList<>();

        String sql = "select * from empleados where id_jefe = " + jefe.getId();
        Statement stm = conexion.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt(1);
            int idJefe = rs.getInt(2);
            String nombre = rs.getString(3);
            double sueldo = rs.getDouble(4);
            GregorianCalendar fechaIncorp = new GregorianCalendar();
            fechaIncorp.setTime(rs.getDate(5));

            Empleado e = new Empleado(id, idJefe, nombre, sueldo, fechaIncorp);
            res.add(e);
        }

        return res;
    }

    /**
     * Actualiza el sueldo a pagar de la base de datos
     * @param lista lista de empleados
     * @return sueldo a pagar
     * @throws SQLException 
     */
    public double actualizarSueldoAPagar(List<Empleado> lista) throws SQLException {
        double sueldoTotal = 0;
        for (Empleado e : lista) {
            sueldoTotal += e.getSueldo();
        }

        String sql = "update jefes set sueldo_a_pagar = ? where id = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setDouble(1, sueldoTotal); 
        preparedStatement.setInt(2, jefe.getId());
        preparedStatement.executeUpdate();
        
        return sueldoTotal;
    }

}
