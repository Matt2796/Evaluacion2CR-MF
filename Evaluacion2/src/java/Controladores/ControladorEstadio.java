/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.CiudadDAO;
import dao.EquipoDAO;
import dao.EstadioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Estadio;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorEstadio", urlPatterns = {"/ControladorEstadio"})
public class ControladorEstadio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "2": registrar(request,response);
                break;
            case "3": modificar(request,response);
            break;
            case "4": eliminar(request,response);
            break;
        }
         }else{
             response.sendRedirect("estadios.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int capacidad = Integer.parseInt(request.getParameter("capacidad").trim());
           
            if(nombre.equals("") || ciudad<1 || capacidad<1){
                response.sendRedirect("estadios.jsp?msj=Valores incompletos");
            }else{
                EstadioDAO es = new EstadioDAO();
                CiudadDAO ci = new CiudadDAO();
                Estadio e = new Estadio(nombre,ci.obtenerCiudad(ciudad),capacidad);
                
                if(es.obtenerEstadio(e.getId())==null){
                    int respuesta = es.registrar(e);
                    if(respuesta==1){
                    response.sendRedirect("estadios.jsp?msj=Estadio registrado");
                    }else{
                    response.sendRedirect("estadios.jsp?msj=Estadio no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("estadios.jsp?msj=Estadio ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("estadios.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int capacidad = Integer.parseInt(request.getParameter("capacidad").trim());
            
            if(id<1 || nombre.equals("") || ciudad<1 || capacidad<1){
                response.sendRedirect("modestadio.jsp?msj=Valores erroneos");
            }else{
                EstadioDAO es = new EstadioDAO();
                CiudadDAO ci = new CiudadDAO();
                Estadio e = new Estadio(id,nombre,ci.obtenerCiudad(ciudad),capacidad);
                
                if(es.obtenerEstadio(e.getId())==null){
                    response.sendRedirect("estadios.jsp?msj=Estadio no existe");
                }else{
                   int respuesta = es.modificar(e);
                   if(respuesta>0){
                       response.sendRedirect("estadios.jsp?msj=Estadio modificado");
                   }else{
                       response.sendRedirect("estadios.jsp?msj=Estadio no se pudo modificar");
                   }
                }
            }
         }catch(Exception e){
             response.sendRedirect("modestadio.jsp?msj="+e.getMessage());
         }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int capacidad = Integer.parseInt(request.getParameter("capacidad").trim());
            
            if(id<1 || nombre.equals("") || ciudad<1 || capacidad<1){
                response.sendRedirect("delestadio.jsp?msj=Opcion no valida");
            }else{
                EstadioDAO es = new EstadioDAO();
                CiudadDAO ci = new CiudadDAO();
                Estadio e = new Estadio(id,nombre,ci.obtenerCiudad(ciudad),capacidad);
                
                if(es.obtenerEstadio(e.getId())!=null){
                    EquipoDAO eq = new EquipoDAO();
                    if(eq.existeEstadio(e)){
                        response.sendRedirect("estadios.jsp?msj=No se puede eliminar por tener equipos");
                    }else{
                    int respuesta = es.eliminar(e);
                    if(respuesta==1){
                    response.sendRedirect("estadios.jsp?msj=Estadio eliminado");
                    }else{
                    response.sendRedirect("estadios.jsp?msj=Estadio no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("estadios.jsp?msj=Estadio no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("delestadio.jsp?msj="+e.getMessage());
           }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
