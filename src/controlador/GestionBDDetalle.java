/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Jefe;
import java.sql.*;

/**
 *
 * @author AndJe
 */
public class GestionBDDetalle {
    
    private Connection conexion;
    private Jefe jefe;

    public GestionBDDetalle(Connection conexion, Jefe jefe) {
        this.conexion = conexion;
        this.jefe = jefe;
    }
    
    /**
     * Inicializa los empleados desde la primera posicion para recorrer
     * @return ResultSet / null
     * @throws SQLException 
     */
    public ResultSet inicializar()throws SQLException{
        String sql = "SELECT * FROM EMPLEADOS WHERE Id_jefe ="+jefe.getId();
        Statement stm = GestionBDComun.getStatementDetalle(conexion);
        ResultSet res = stm.executeQuery(sql);
        
        if(res.next()){
            res.first();
            return res;
        }else{
            return null;
        }
    }
    
    public void actualizarSueldo(int id, double sueldo)throws SQLException{
        String sql = "UPDATE EMPLEADOS SET sueldo = "+sueldo+" WHERE Id = "+id;
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    
    public void actualizarFecha()throws SQLException{
        
    }
}
