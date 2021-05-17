/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modele.Visiteur;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andrew
 */
@WebServlet(urlPatterns = {"/StatVisiteur"})
public class StatVisiteur extends HttpServlet {

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
        System.out.println("pass get");
        this.getServletContext().getRequestDispatcher("/WEB-INF/StatVisiteurJ.jsp").forward(request, response);
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
        try {
            HttpSession session = request.getSession();
            Visiteur visi = (Visiteur) session.getAttribute("session");
            cltClient clt  = new cltClient();
            String graph = request.getParameter("buttonGraph");
            int annee = Integer.parseInt(request.getParameter("annee"));
            System.out.println("pass post");
            switch(graph){
                case "parAnnee":
                    request.setAttribute("list", clt.getRapDAO().NbVisitAnnee(visi.getVis_id(), annee));
                    request.setAttribute("type", 1);
                    break;
                case "troisDer":
                    for(int i = 1; i <= 3;i++){
                        request.setAttribute("list" + i, clt.getRapDAO().NbVisitMois(visi.getVis_id(), i));
                        request.setAttribute("type", 2);
                    }
                    break;
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/StatVisiteurJ.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(StatVisiteur.class.getName()).log(Level.SEVERE, null, ex);
        }
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
