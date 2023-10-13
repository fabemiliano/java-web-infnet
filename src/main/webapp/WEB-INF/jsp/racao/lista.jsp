<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"  contentType="text/html; UTF-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>apppetshop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu.jsp"/>

        <div class="container-fluid mt-3">
            <h3>Listagem de Rações:</h3>
            <h4><a href="/racao/cadastro">Novo Tipo de Ração</a></h4>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Código</th>
                        <th>Peso</th>
                        <th>Pacote</th>
                        <th>Validade</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="r" items="${listaRacao}">
                        <tr>
                            <td>${r.id}</td>
                            <td>${r.descricao}</td>
                            <td>${r.valor}</td>
                            <td>${r.codigo}</td>
                            <td>${r.peso}</td>
                            <td>${r.pacote}</td>
                            <td>${r.validade}</td>
                            <td><a href="/racao/excluir/${r.id}">Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>