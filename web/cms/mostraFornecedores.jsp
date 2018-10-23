<%-- 
    Document   : mostraFornecedores
    Created on : 18/09/2018, 16:01:14
    Author     : ellias
--%>

<%@page import="model.Fornecedor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/principal.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
    </head>
    <body>
        
        <!-- Abre o menu principal-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">

                <div class="logo">CardAPPio </div>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/CardAPPio/cms">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="fornecedor">Manter Fornecedores</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="ingrediente">Manter Ingredientes</a>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <!-- Fecha o menu principal-->

    <center>
        <div class="corpo">

            <h3>Manutenção de Fornecedores</h3>

            <%
                String msg = (String) request.getAttribute("msg").toString();
                out.println("<h2>" + msg + "</h2>");

            %>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Endereço</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Alterar</th>
                        <th scope="col">Excluir</th>

                    </tr>
                    </thead>
                    <tbody>

                    <%    
                        List<Fornecedor> listaFornecedor = (List<Fornecedor>) request.getAttribute("listaFornecedores");

                        for (Fornecedor f : listaFornecedor) {
                    %>

                    <tr>
                        <th scope="row"><%= f.getIdFornecedor()%></th> 
                        <td scope="row"><%= f.getFornecedorNm()%></td>
                        <td><%= f.getFornecedorEnd()%></td>
                        <td><%= f.getFornecedorTel()%></td>

                        <td><a href="fornecedor?id=<%=f.getIdFornecedor()%>&acao=alterar">Alterar</a></td>
                        <td><a href="fornecedor?id=<%=f.getIdFornecedor()%>&acao=excluir">Excluir</a></td>

                        <%
                            }
                        %>

                    </tr>
                </tbody>
            </table>
        </div>
       <a href="fornecedor?acao=incluir">Incluir Novo Fornecedor</a>
    </center>
</body>
<script src="js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</html>
