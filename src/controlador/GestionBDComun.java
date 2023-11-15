/*
 * Administra parte comón de la conexión con la base de datos
 */
package controlador;

import java.sql.*;

/**
 *
 * @author Di Qi
 */
public class GestionBDComun {

    private static GestionBDComun ref = new GestionBDComun();

    private GestionBDComun() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: exception loading driver class");
        }
    }

    /**
     * Abre una nueva conexión
     * @return conexion
     * @throws SQLException 
     */
    public static Connection getConexion() throws SQLException {
        String url = "jdbc:derby://localhost:1527/empresa";
        return DriverManager.getConnection(url, "empresa", "empresa");
    }
    
    /**
     * Crear un statement para el panel detalle
     * @param conexion conexion del statement
     * @return Statement scrolleable y updatable
     * @throws SQLException 
     */
    public static Statement getStatementDetalle(Connection conexion) throws SQLException {
        return conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    /**
     * Crear un statement para el panel resumen
     * @param conexion conexion del statement
     * @return Statement scrolleable y readonly
     * @throws SQLException 
     */
    public static Statement getStatementResumen(Connection conexion) throws SQLException {
        return conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (Exception ignored) {
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (Exception ignored) {
        }
    }
}
