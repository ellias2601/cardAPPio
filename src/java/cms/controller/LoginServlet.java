/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.controller;

import cms.ado.LoginADO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author ellias
 */
public class LoginServlet extends HttpServlet {

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

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Login login = new Login(email, senha);

        LoginADO loginADO = new LoginADO();

        try {
            
            List<Login> dados = loginADO.procura(login);
            
            
            if (dados.size() > 0) {
                
                //capturando a sessao ativa
                HttpSession sessao = request.getSession();
                sessao.setAttribute("idUsuario", dados.get(0).getKey());
                sessao.setAttribute("nmUsuario", dados.get(0).getNmUsuario());
                
                //redirecionando o usuario para a pagina principal
                response.sendRedirect("home.jsp");
                
            } else {

                request.setAttribute("msg", "Credenciais Inválidas");
                request.getRequestDispatcher("index.jsp").forward(request, response);
               
            }

        } catch (Exception ex) {

            Logger.getLogger(LoginServlet.class.getName()).log(null, ex);
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
