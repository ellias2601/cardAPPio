<%-- 
    Document   : teste.jsp
    Created on : 12/09/2018, 17:13:53
    Author     : ellias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/formulario.css">
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
                        <a class="nav-link" href="/CardAPPio">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="entradas">Entradas</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link " href="pratosPrincipais">Pratos Principais</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="sobremesas">Sobremesas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="bebidas">Bebidas</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <!-- Fecha o menu principal-->
        
        <!-- Abre o formulario -->
        
        <div class="container">
            <form action="entradas" method="post">
            <h3> Faça seu cadastro!! </h3>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail">Email</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputSenha">Senha</label>
                    <input type="password" class="form-control" id="inputSenha" placeholder="Senha" name="senha">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEndereco">Endereço</label>
                <input type="text" class="form-control" id="inputEndereco" placeholder="Endereço" name="endereco">
            </div>
            <div class="form-group">
                <label for="inputBairro">Bairro</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Bairro" name="bairro">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCidade">Cidade</label>
                    <input type="text" class="form-control" id="inputCidade" placeholder="Cidade" name="cidade">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEstado">Estado</label>
                    <select id="inputEstado" class="form-control">
                        <option selected>Escolha</option>
                        <option>Goiás</option>
                        <option>Brasília</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputCep">Cep</label>
                    <input type="text" class="form-control" id="inputCep" name="cep">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Deseja receber informativos no seu e-mail?
                    </label>
                </div>
            </div>
            <button type="submit" name="confirmar" class="btn btn-primary">Confirmar</button>
        </form>
      </div>
        
       <!-- Fecha o formulario -->
       
    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</html>
