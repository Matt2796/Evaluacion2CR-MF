/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.CiudadDAO;
import dao.EstadioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Ciudad;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorCiudad", urlPatterns = {"/ControladorCiudad"})
public class ControladorCiudad extends HttpServlet {

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
             response.sendRedirect("ciudades.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")){
                response.sendRedirect("ciudades.jsp?msj=Valores no permitidos");
            }else{
                CiudadDAO ciu = new CiudadDAO();
                Ciudad c = new Ciudad(nombre);
                if(ciu.obtenerCiudad(c.getId())==null){
                    int respuesta = ciu.registrar(c);
                    if(respuesta==1){
                    response.sendRedirect("ciudades.jsp?msj=Ciudad registrada");
                    }else{
                    response.sendRedirect("ciudades.jsp?msj=Ciudad no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("ciudades.jsp?msj=Ciudad ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("ciudades.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            
            if(id<1||nombre.equals("")){
                response.sendRedirect("modciudad.jsp?msj=valores erroneos");
            }else{
                CiudadDAO ciu = new CiudadDAO();
                Ciudad c = new Ciudad(id,nombre);
                
                if(ciu.obtenerCiudad(c.getId())==null){
                    response.sendRedirect("ciudades.jsp?msj=Ciudad no existe");
                }else{
                   int respuesta = ciu.modificar(c);
                   if(respuesta>0){
                       response.sendRedirect("ciudades.jsp?msj=Ciudad modificada");
                   }else{
                       response.sendRedirect("ciudades.jsp?msj=Ciudad no se pudo modificar");
                   }
                }
            }
         }catch(Exception e){
                  response.sendRedirect("modciudad.jsp?msj="+e.getMessage());          
         }
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id =Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")||id<1){
                response.sendRedirect("delciudad.jsp?msj=Opcion no valida");
            }else{
                CiudadDAO ciu = new CiudadDAO();
                Ciudad c = new Ciudad(id,nombre);

                if(ciu.obtenerCiudad(c.getId())!=null){
                    EstadioDAO es = new EstadioDAO();
                    
                    if(es.existeCiudad(c)){
                        response.sendRedirect("ciudades.jsp?msj=No se puede eliminar Ciudad por estar asociada a un estadio o equipo");
                    }else{
                    int respuesta = ciu.eliminar(c);
                    if(respuesta==1){
                    response.sendRedirect("ciudades.jsp?msj=Ciudad eliminada");
                    }else{
                    response.sendRedirect("ciudades.jsp?msj=Ciudad no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("ciudades.jsp?msj=Ciudad no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("delciudad.jsp?msj="+e.getMessage());
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
