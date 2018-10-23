<%-- 
    Document   : IncluirFornecedor
    Created on : 18/09/2018, 20:14:01
    Author     : ellias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/principal.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
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

        <section class="container">
            <form action="fornecedor" method="post">
                <h1>Inclusão de Fornecedores</h1>
                <div class="form-group">
                    <input type="hidden" name="acao" value="salvaInclusao" class="form-control"></input>
                </div>

                <div class="form-group">
                    <label for ="nomeFornecedor">Nome do Fornecedor: </label>
                    <input type="text" name="nome" value="" class="form-control"></input>
                </div>

                <div class="form-group">
                    <label for="enderecoFornecedor">Endereço do Fornecedor: </label>
                    <input type="text" name="endereco" value="" class="form-control"></input>
                </div>

                <div class="form-group">
                    <label for="telefoneFornecedor">Telefone do Fornecedor: </label>
                    <input type="text" name="telefone" value="" class="form-control"></input>
                </div>
                
                <center>
                <button type="submit" value="Salvar" class="btn btn-danger">Salvar</button>
                </center>
            </form>
        </section>
    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</html>
