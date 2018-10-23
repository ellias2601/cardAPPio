<%-- 
    Document   : index
    Created on : 18/09/2018, 15:23:40
    Author     : ellias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel ="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/cssprincipal.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>CMS - Gerenciamento de Conteúdos</title>

    </head>
    <body>

        <div class="container formLogin">

            <h2>Acesso ao Sistema</h2>
            <form method="POST" action="login">

                
                <div class="form-group">
                    
                    <input type="hidden" name="id" value="autenticacao" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email">
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email">
                </div>

                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input type="password" name="senha" class="form-control" id="exampleInputPassword1" placeholder="Senha">
                    <small id="dica" class="form-text text-muted">Nunca compartilhe seu e-mail ou senha com ninguém</small>
                </div>

                <center>
                    <button type="submit" class="btn btn-primary">Acessar</button>
                </center>
                
                 <%

                    if (request.getAttribute("msg") != null) {

                        String msg = (String) request.getAttribute("msg").toString();
                        out.println("<h2>" + msg + "</h2>");
                    }

                %>

            </form>
        </div>

    </body>
    <script src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</html>
