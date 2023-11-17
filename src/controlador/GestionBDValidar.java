/*
 * Gestion de las consultas de la tabla JEFES
 * Panel Validar y Panel Resumen
 */
package controlador;

import java.sql.*;
import modelo.Jefe;

/**
 *
 * @author Di Qi
 */
public class GestionBDValidar {
    
    private Connection conexion;
    private Jefe jefe;

    public GestionBDValidar(Connection conexion) {
        this.conexion = conexion;
        this.jefe = null;
    }
    
    public boolean validar(String u, String p) throws SQLException {
        String sql = "select * "
                + "from jefes "
                + "where usuario = '" + u + "' "
                + "and password = '" + p + "'";
        
        PreparedStatement stm = conexion.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            String usuario = rs.getString(3);
            String password = rs.getString(4);
            String imagen = rs.getString(5);
            double sueldoAPagar = rs.getDouble(6);
            
            this.jefe = new Jefe(id, nombre, usuario, password, imagen, sueldoAPagar);
            return true;
        }
        
        return false;
    }
    
    public Jefe getJefe() {
        return this.jefe;
    }
}
