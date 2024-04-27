/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
/**
 *
 * @author User
 */
public class ModeloProducto {

    String NombreProducto;
    Double PrecioProducto;
    private final Conexion conexion;

    public ModeloProducto() {
        conexion = new Conexion();
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public Double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(Double PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }
 
    public String InsertarProducto(ModeloProducto producto){
        Connection cx = conexion.conectar();
        if (cx != null){
            try {
                String SPInsertarProducto = "{call InsertarProducto(?, ?)}";
                CallableStatement statement = cx.prepareCall(SPInsertarProducto);
                statement.setString(1, producto.getNombreProducto());
                statement.setDouble(2, producto.getPrecioProducto());
                statement.execute();
                return "El Registro se insertó con exito";
            } catch (SQLException ex) {
                return ex.getMessage();
            }finally {
                conexion.desconectar();
            }
        }else {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
}

