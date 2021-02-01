<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 30/01/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Insert title here</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Saisie des Produits
        </div>
        <div class="card-body">
            <form action="save.do" method="post">
                <div class="form-group">
                    <label class="control-label">Nom Produit :</label>

                    <input type="text" name="nom" class="form-control"/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="prix" class="form-control"/>
                </div>
                <div class="form-group">
                    <label class="control-label">fournisseurProduit :</label>
                    <input type="text" name="fournisseurProduit" class="form-control"/>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">Ajouter</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
