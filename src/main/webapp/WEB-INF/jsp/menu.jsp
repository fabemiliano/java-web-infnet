<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java"  contentType="text/html; UTF-8" pageEncoding="utf-8" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">apppetshop</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/usuario/lista">Usuários</a></li>
            <c:if test="${not empty user}">
                <li><a href="/cliente/lista">Cliente</a></li>
                <li><a href="/produto/lista">Produto</a></li>
                <li><a href="/pedido/lista">Pedidos</a></li>
                <li><a href="/racao/lista">Ração</a></li>
                <li><a href="/vacina/lista">Vacina</a></li>
                <li><a href="/ferramenta/lista">Ferramenta</a></li>
            </c:if>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty user}">
                <li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>

            <c:if test="${not empty user}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.email}</a></li>
            </c:if>
        </ul>
    </div>
</nav>
