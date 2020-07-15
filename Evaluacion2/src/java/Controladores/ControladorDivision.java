/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import dao.DivisionDAO;
import dao.EquipoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Division;

/**
 *
 * @author mfaun
 */
@WebServlet(name = "ControladorDivision", urlPatterns = {"/ControladorDivision"})
public class ControladorDivision extends HttpServlet {

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
             response.sendRedirect("divisiones.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")){
                response.sendRedirect("deldivision.jsp?msj=Valores no permitidos");
            }else{
                DivisionDAO di = new DivisionDAO();
                Division d = new Division(id,nombre);
                
                if(di.obtenerDivision(d.getId())==null){
                    int respuesta = di.registrar(d);
                    if(respuesta==1){
                    response.sendRedirect("moddivision.jsp?msj=Division registrada");
                    }else{
                    response.sendRedirect("moddivision.jsp?msj=Division no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("moddivision.jsp?msj=Division ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("moddivision.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response){
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
            
            if(id<1||nombre.equals("")){
                response.sendRedirect("moddivision.jsp?msj=valores erroneos");
            }else{
                DivisionDAO di = new DivisionDAO();
                Division d = new Division(id,nombre);
                
                if(di.obtenerDivision(d.getId())==null){
                    response.sendRedirect("moddivision.jsp?msj=Division no existe");
                }else{
                   int respuesta = di.modificar(d);
                   if(respuesta>0){
                       response.sendRedirect("moddivision.jsp?msj=Division modificada");
                   }else{
                       response.sendRedirect("moddivision.jsp?msj=Division no se pudo modificar");
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
                response.sendRedirect("deldivision.jsp?msj=Opcion no valida");
            }else{
                DivisionDAO di = new DivisionDAO();
                Division d = new Division(id,nombre);

                if(di.obtenerDivision(d.getId())!=null){
                    EquipoDAO eq = new EquipoDAO();
                    
                    if(eq.existeDivision(d)){
                        response.sendRedirect("deldivision.jsp?msj=No se puede eliminar la division por tener equipos");
                    }else{
                    int respuesta = di.eliminar(d);
                    if(respuesta==1){
                    response.sendRedirect("deldivision.jsp?msj=Division eliminada");
                    }else{
                    response.sendRedirect("deldivision.jsp?msj=Division no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("deldivision.jsp?msj=Division no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("deldivision.jsp?msj="+e.getMessage());
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
