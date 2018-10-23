<%-- 
    Document   : index
    Created on : 11/09/2018, 07:53:31
    Author     : ellias
--%>

<%@page import="model.Produto"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/principal.css">
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
                        <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <%
                        List<Categoria> categorias = (List<Categoria>) request.getAttribute("listaCategoria");

                        for (Categoria c : categorias) {

                    %>
                    <li class="nav-item">
                        <a class="nav-link " href="<%=c.getCategoriaNm()%>"><%=c.getCategoriaNm()%></a>
                    </li>
                    <%  }
                    %>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <!-- Fecha o menu principal-->

        <!-- Abre o corpo do site-->

        <section class="corpo fotos-destaque ">

            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#next" data-slide-to="0" class="active"></li>
                    <li data-target="#next" data-slide-to="1"></li>
                    <li data-target="#next" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="img/bebidas.jpg" height="390">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/comida.jpg" height="390" >
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/sobremesas.jpg" height="390">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <div class="jumbotron">
                
                <h4>Bem-Vindo ao <span><div class="logo">CardAPPio </div></span> </h4>

                <%
                    List<Produto> produto = (List<Produto>) request.getAttribute("listaProduto");

                    for (Produto p : produto) {

                %>
                <li>
                    <a href="entradas">
                        
                        <div>
                        <h6><%=p.getProdutoNm()%></h6>
                        <span><%=p.getProdutoDesc()%></span> 
                        </div>
                    </a>
                </li>
                
                <%  }
                %>
                
                <div class="empurra"></div>

            </div>

        </section>
                
        <!-- rodape -->
        
        <footer>
            
            <li><a href="/CardAPPio">CardAPPio</a></li>
            <li>2018 - Todos os Direitos Reservados</li>
            <li>Feito por Zezim</li>
        </footer>
        
        <!-- //rodape -->
        <!-- media query -->

        <!-- Fecha o corpo do site-->
    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</html>
