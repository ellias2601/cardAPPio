/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.controller;

import cms.ado.FornecedorADO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

/**
 *
 * @author ellias
 */
@WebServlet(name = "FornecedorServlet", urlPatterns = {"/cms/fornecedor"})
public class FornecedorServlet extends HttpServlet {

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
       
        String despachadorURL = "";
        String acao = request.getParameter("acao");
        String msg = "";
        Boolean status;
        
        acao = (acao==null) ? "listar" : acao;
        
        switch(acao){
                
             case "excluir":
                 
                 status = excluiFornecedor(request);
                 msg = (status) ? "Fornecedor Excluido com Sucesso !!" : "Erro ao Excluir o Fornecedor !!";
                 despachadorURL="fornecedor";
                 acao="listar";
                 break;
                 
             case "incluir":
                 
                 despachadorURL="incluirFornecedor.jsp";
                 break;
                 
             case "salvaInclusao":
                 
                 status = incluiFornecedor(request);
                 msg = (status)? "Fornecedor Incluido com Sucesso !!": "Erro ao Incluir Fornecedor !!";
                 despachadorURL="fornecedor";
                 acao="listar";
                 break;
                 
             case "alterar":
                 
                 Integer id = Integer.parseInt(request.getParameter("id"));
                 request.setAttribute("dadosFornecedor", buscaDadosDo(id));
                 despachadorURL = "alteraFornecedor.jsp";
                 break;
                 
             case "salvaAlteracao": 
                 
                 status = alteraFornecedor(request);
                 msg = (status)? "Fornecedor Alterado com Sucesso!!" : "Erro ao Alterar Fornecedor!!";
                 despachadorURL="fornecedor";
                 acao="listar";
                 break;
                    
        }
        
        if(acao.equals("listar")) {
            
            FornecedorADO fornecedor = new FornecedorADO();
            try {
                List<Fornecedor> fornecedores = (List<Fornecedor>) fornecedor.listaTodos();
                request.setAttribute("listaFornecedores", fornecedores);
                despachadorURL = "mostraFornecedores.jsp";
            } catch (Exception ex) {
                Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        request.setAttribute("msg", msg);
        RequestDispatcher despachador = request.getRequestDispatcher(despachadorURL);
        despachador.forward(request, response);
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

    private Boolean excluiFornecedor(HttpServletRequest request) {
        
        Boolean checa = true;
        FornecedorADO fornAdo = new FornecedorADO();
       
        Integer idFornecedor = Integer.parseInt(request.getParameter("id"));
        Fornecedor forn = new Fornecedor(idFornecedor);
        try {
            fornAdo.excluir(forn);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
            checa=false;
        }
      
        return checa;
    }

    private Boolean incluiFornecedor(HttpServletRequest request) {
        
        Boolean checa = true;
        FornecedorADO fornAdo = new FornecedorADO();
        
        
        String  nomeFornecedor = request.getParameter("nome");
        String  endFornecedor = request.getParameter("endereco");
        String  telefoneFornecedor = request.getParameter("telefone");
        
        Fornecedor forn = new Fornecedor(null, nomeFornecedor, endFornecedor, telefoneFornecedor);
        try {
            fornAdo.salvar(forn);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
            checa=false;
        }
        
        return checa;
        
        
    }

    private Boolean alteraFornecedor(HttpServletRequest request) {
        
        Boolean checa = true;
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        String  nomeFornecedor = request.getParameter("nome");
        String  endFornecedor = request.getParameter("endereco");
        String  telefoneFornecedor = request.getParameter("telefone");
        
        Fornecedor forn  = new Fornecedor(id, nomeFornecedor, endFornecedor, telefoneFornecedor);
        
        FornecedorADO fornAdo = new FornecedorADO();
        try {
            fornAdo.atualizar(forn);
            
        } catch (Exception ex) {
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
            checa=false;
        }
        
        
        return checa;
    }

    private Object buscaDadosDo(Integer id) {
       
        Fornecedor fornId = new Fornecedor(id, null, null, null);
        FornecedorADO forn = new FornecedorADO();
        List<Fornecedor> dados = null;
        
        try {
            dados = forn.procura(fornId);
        } catch (Exception ex) {
            Logger.getLogger(FornecedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

}
