/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.CiudadDAO;
import dao.EquipoDAO;
import dao.EstadioDAO;
import dao.DivisionDAO;
import dao.JugadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Equipo;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorEquipo", urlPatterns = {"/ControladorEquipo"})
public class ControladorEquipo extends HttpServlet {

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
            /*case "3": modificar(request,response);
            break;
            case "4": eliminar(request,response);
            break;*/
        }
         }else{
             response.sendRedirect("equipos.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int estadio = Integer.parseInt(request.getParameter("estadio").trim());
            int division = Integer.parseInt(request.getParameter("division").trim());
           
            if(id<1 || nombre.equals("") || ciudad<1 || estadio<1 || division<1){
                response.sendRedirect("delequipo.jsp?msj=Valores incompletos");
            }else{
                EquipoDAO eq = new EquipoDAO();
                CiudadDAO ci = new CiudadDAO();
                EstadioDAO es = new EstadioDAO();
                DivisionDAO di = new DivisionDAO();
                Equipo e = new Equipo(id,nombre,ci.obtenerCiudad(ciudad),es.obtenerEstadio(estadio),di.obtenerDivision(division));
                
                if(eq.obtenerEquipo(e.getId())==null){
                    int respuesta = eq.registrar(e);
                    if(respuesta==1){
                    response.sendRedirect("modequipo.jsp?msj=Equipo registrado");
                    }else{
                    response.sendRedirect("modequipo.jsp?msj=Equipo no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("modequipo.jsp?msj=Equipo ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("modequipo.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response){
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int estadio = Integer.parseInt(request.getParameter("estadio").trim());
            int division = Integer.parseInt(request.getParameter("division").trim());
            
            if(id<1 || nombre.equals("") || ciudad<1 || estadio<1 || division<1){
                response.sendRedirect("modequipo.jsp?msj=valores erroneos");
            }else{
                EquipoDAO eq = new EquipoDAO();
                CiudadDAO ci = new CiudadDAO();
                EstadioDAO es = new EstadioDAO();
                DivisionDAO di = new DivisionDAO();
                Equipo e = new Equipo(id,nombre,ci.obtenerCiudad(ciudad),es.obtenerEstadio(estadio),di.obtenerDivision(division));

                if(eq.obtenerEquipo(e.getId())==null){
                    response.sendRedirect("modequipo.jsp?msj=Equipo no existe");
                }else{
                   int respuesta = eq.modificar(e);
                   if(respuesta>0){
                       response.sendRedirect("modequipo.jsp?msj=Equipo modificado");
                   }else{
                       response.sendRedirect("modequipo.jsp?msj=Equipo no se pudo modificar");
                   }
                }
            }
         }catch(Exception e){
             
         }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            int ciudad = Integer.parseInt(request.getParameter("ciudad").trim());
            int estadio = Integer.parseInt(request.getParameter("estadio").trim());
            int division = Integer.parseInt(request.getParameter("division").trim());
           
            if(id<1 || nombre.equals("") || ciudad<1 || estadio<1 || division<1){
                response.sendRedirect("delequipo.jsp?msj=Opcion no valida");
            }else{
                EquipoDAO eq = new EquipoDAO();
                CiudadDAO ci = new CiudadDAO();
                EstadioDAO es = new EstadioDAO();
                DivisionDAO di = new DivisionDAO();
                Equipo e = new Equipo(id,nombre,ci.obtenerCiudad(ciudad),es.obtenerEstadio(estadio),di.obtenerDivision(division));

                if(eq.obtenerEquipo(e.getId())!=null){
                    JugadorDAO jug = new JugadorDAO();
                    if(jug.existeEquipo(e)){
                        response.sendRedirect("delequipo.jsp?msj=No se puede eliminar por tener jugadores");
                    }else{
                    int respuesta = eq.eliminar(e);
                    if(respuesta==1){
                    response.sendRedirect("delequipo.jsp?msj=Equipo eliminado");
                    }else{
                    response.sendRedirect("delequipo.jsp?msj=Equipo no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("delequipo.jsp?msj=Equipo no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("delEquipo.jsp?msj="+e.getMessage());
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
