/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.EquipoDAO;
import dao.EstadioDAO;
import dao.JugadorDAO;
import dao.PosicionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Jugador;
import modelos.Posicion;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorJugador", urlPatterns = {"/ControladorJugador"})
public class ControladorJugador extends HttpServlet {

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
             response.sendRedirect("jugadores.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            String apellido = request.getParameter("apellido").trim();
            int sueldo = Integer.parseInt(request.getParameter("sueldo").trim());
            String fecha_nacimiento = request.getParameter("feha_nacimiento").trim();
            int posicion = Integer.parseInt(request.getParameter("posicion").trim());
            int equipo = Integer.parseInt(request.getParameter("equipo").trim());
           
            if(id<1 || nombre.equals("") || apellido.equals("") || sueldo<1 || fecha_nacimiento.equals("") || posicion<1 || equipo<1){
                response.sendRedirect("modJugador.jsp?msj=Valores incompletos");
            }else{
                Date date = new Date();
                date.setTime(Integer.parseInt(fecha_nacimiento));
                
                PosicionDAO p = new PosicionDAO();
                EquipoDAO e = new EquipoDAO();
                
                JugadorDAO jug = new JugadorDAO();
                Jugador j = new Jugador(id,nombre,apellido,date, p.obtenerPosicion(posicion),sueldo,e.obtenerEquipo(equipo));
                
                if(jug.obtenerJugador(id)==null){
                    int respuesta = jug.registrarJugador(j);
                    if(respuesta==1){
                    response.sendRedirect("modJugador.jsp?msj=Jugador registrada");
                    }else{
                    response.sendRedirect("modJugador.jsp?msj=Jugador no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("modJugador.jsp?msj=Jugador ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("modposicion.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            String apellido = request.getParameter("apellido").trim();
            int sueldo = Integer.parseInt(request.getParameter("sueldo").trim());
            String fecha_nacimiento = request.getParameter("feha_nacimiento").trim();
            int posicion = Integer.parseInt(request.getParameter("posicion").trim());
            int equipo = Integer.parseInt(request.getParameter("equipo").trim());
            
            if(id<1 || nombre.equals("") || apellido.equals("") || sueldo<1 || fecha_nacimiento.equals("") || posicion<1 || equipo<1){
                response.sendRedirect("modJugador.jsp?msj=Valores incompletos");
            }else{
                Date date = new Date();
                date.setTime(Integer.parseInt(fecha_nacimiento));
                
                PosicionDAO p = new PosicionDAO();
                EquipoDAO e = new EquipoDAO();
                
                JugadorDAO jug = new JugadorDAO();
                Jugador j = new Jugador(id,nombre,apellido,date, p.obtenerPosicion(posicion),sueldo,e.obtenerEquipo(equipo));
                
                if(jug.obtenerJugador(j.getId())==null){
                    response.sendRedirect("modJugador.jsp?msj=Jugador no existe");
                }else{
                   int respuesta = jug.modificar(j);
                   if(respuesta>0){
                       response.sendRedirect("modJugador.jsp?msj=Jugador modificado");
                   }else{
                       response.sendRedirect("modJugador.jsp?msj=Jugador no se pudo modificar");
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
            String apellido = request.getParameter("apellido").trim();
            int sueldo = Integer.parseInt(request.getParameter("sueldo").trim());
            String fecha_nacimiento = request.getParameter("feha_nacimiento").trim();
            int posicion = Integer.parseInt(request.getParameter("posicion").trim());
            int equipo = Integer.parseInt(request.getParameter("equipo").trim());
           
            if(id<1 || nombre.equals("") || apellido.equals("") || sueldo<1 || fecha_nacimiento.equals("") || posicion<1 || equipo<1){
                response.sendRedirect("delJugador.jsp?msj=Opcion no valida");
            }else{
                Date date = new Date();
                date.setTime(Integer.parseInt(fecha_nacimiento));
                
                PosicionDAO p = new PosicionDAO();
                EquipoDAO e = new EquipoDAO();
                
                JugadorDAO jug = new JugadorDAO();
                Jugador j = new Jugador(id,nombre,apellido,date, p.obtenerPosicion(posicion),sueldo,e.obtenerEquipo(equipo));

                if(jug.obtenerJugador(j.getId())!=null){      
                    int respuesta = jug.eliminar(j);
                    if(respuesta==1){
                    response.sendRedirect("deljugador.jsp?msj=Jugador eliminado");
                    }else{
                    response.sendRedirect("deljugador.jsp?msj=Jugador no se pudo eliminar");
                    }
                }else{
                    response.sendRedirect("deljugador.jsp?msj=Jugador no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("delposicion.jsp?msj="+e.getMessage());
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
