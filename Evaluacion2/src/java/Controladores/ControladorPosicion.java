/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.JugadorDAO;
import dao.PosicionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Posicion;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorPosicion", urlPatterns = {"/ControladorPosicion"})
public class ControladorPosicion extends HttpServlet {

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
            case "1": registrar(request,response);
                break;
            case "2": modificar(request,response);
            break;
            case "3": eliminar(request,response);
            break;
        }
         }else{
             response.sendRedirect("delposicion.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")){
                response.sendRedirect("delposicion.jsp?msj=Valores no permitidos");
            }else{
                PosicionDAO pos = new PosicionDAO();
                Posicion p = new Posicion(id,nombre);
                if(pos.obtenerPosicion(p.getId())==null){
                    int respuesta = pos.registrar(p);
                    if(respuesta==1){
                    response.sendRedirect("modposicion.jsp?msj=Posicion registrada");
                    }else{
                    response.sendRedirect("modposicion.jsp?msj=Posicion no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("modposicion.jsp?msj=Posicion ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("modposicion.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response){
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            
            if(id<1||nombre.equals("")){
                response.sendRedirect("modPosicion.jsp?msj=valores erroneos");
            }else{
                PosicionDAO pos = new PosicionDAO();
                Posicion p = new Posicion(id,nombre);
                
                if(pos.obtenerPosicion(p.getId())==null){
                    response.sendRedirect("modPosicion.jsp?msj=Posicion no existe");
                }else{
                   int respuesta = pos.modificar(p);
                   if(respuesta>0){
                       response.sendRedirect("modPosicion.jsp?msj=Posicion modificada");
                   }else{
                       response.sendRedirect("modPosicion.jsp?msj=Posicion no se pudo modificar");
                   }
                }
            }
         }catch(Exception e){
             
         }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id =Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")||id<1){
                response.sendRedirect("crudEstados.jsp?msj=Opcion no valida");
            }else{
                PosicionDAO pos = new PosicionDAO();
                Posicion p = new Posicion(id,nombre);
                if(pos.obtenerPosicion(p.getId())!=null){
                    JugadorDAO jug = new JugadorDAO();
                    if(jug.existePosicion(p)){
                        response.sendRedirect("delposicion.jsp?msj=No se puede eliminar por tener jugadores en esa posicion");
                    }else{
                    int respuesta = pos.eliminar(p);
                    if(respuesta==1){
                    response.sendRedirect("delposicion.jsp?msj=Posicion eliminada");
                    }else{
                    response.sendRedirect("delposicion.jsp?msj=Posicion no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("delposicion.jsp?msj=Posicion no existe");
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
