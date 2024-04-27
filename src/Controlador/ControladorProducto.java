/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloProducto;
/**
 *
 * @author User
 */
public class ControladorProducto {
    private ModeloProducto Modelo;

    public ControladorProducto() {
         Modelo = new ModeloProducto();
    }

    public String InsertarProducto(String NombreProducto, Double PrecioProducto) {
        Modelo.setNombreProducto(NombreProducto);
        Modelo.setPrecioProducto(PrecioProducto);
        String Mensaje =Modelo.InsertarProducto(Modelo);
        return Mensaje;
}    
}
