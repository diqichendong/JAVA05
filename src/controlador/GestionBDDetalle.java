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
import java.util.GregorianCalendar;
import modelo.Empleado;

/**
 *
 * @author AndJe
 */
public class GestionBDDetalle {
    
    private Connection conexion;
    private Jefe jefe;
    private ResultSet res;

    public GestionBDDetalle(Connection conexion, Jefe jefe) {
        this.conexion = conexion;
        this.jefe = jefe;
    }
    
    /**
     * Inicializa los empleados desde la primera posicion para recorrer
     * @return ResultSet / null
     * @throws SQLException 
     */
    public Empleado inicializar()throws SQLException{
        String sql = "SELECT * FROM EMPLEADOS WHERE Id_jefe ="+jefe.getId();
        Statement stm = GestionBDComun.getStatementDetalle(conexion);
        res = stm.executeQuery(sql);
        
        if(res.next()){
            res.first();
            return getCurrentEmpleado();
        }else{
            return null;
        }
    }
    
    public Empleado getCurrentEmpleado() throws SQLException{
        GregorianCalendar date = new GregorianCalendar();
        date.setTime(res.getDate(5));
        Empleado newEmpleado = new Empleado(res.getInt(1),res.getInt(2),res.getString(3),res.getDouble(4),date);
        return newEmpleado;
    }
    
    public void avanzar() throws SQLException{
        res.next();
    }
    
    public void retroceder() throws SQLException{
        res.previous();
    }
    
    public void setPrimero() throws SQLException{
        res.first();
    }
    
    public void setUltimo() throws SQLException{
        res.last();
    }
    
    public ResultSet getResultSet(){
        return res;
    }
    
    public void actualizarSueldo(double sueldo)throws SQLException{
//        String sql = "UPDATE EMPLEADOS SET sueldo = "+sueldo+" WHERE Id = "+id;
//        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
//        preparedStatement.executeUpdate();
        res.updateDouble("Sueldo",sueldo);
        res.updateRow();
    }
    
    public void actualizarFecha(Date fecha)throws SQLException{
        res.updateDate("Fecha_incorp",fecha);
        res.updateRow();
    }
}
