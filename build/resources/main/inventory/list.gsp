<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 2015-11-14
  Time: 20:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>



<html>
<head>
    <title>List of Products</title>
</head>

<body>

${allProducts.name} ${allProducts.sku} ${allProducts.price}

<table border="1">
    <g:each in="${allProducts}" var="thisProduct">
        <tr>
            <td>${thisProduct.name}</td>
            <td>${thisProduct.sku}</td>
            <td>${thisProduct.price}</td>
        </tr>
    </g:each>
</table>


</body>
</html>