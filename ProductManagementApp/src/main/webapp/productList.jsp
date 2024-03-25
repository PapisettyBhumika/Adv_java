<%@page import="com.sathya.servlet.ProductDao" import="java.util.Base64"%>
<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Product List</title>
<!--  BootStrap CDN Link to Get the Support of BootStrap -->
	<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></link> 
</head>

<body>
	<table class="table table-bordered table-stripped">
	<thead class="thread-dark">
	<tr>
		<th>Product proId</th>
		<th>Product  proName</th>
		<th>Product proPrice</th>
		<th>Product proBrand</th>
		<th>Product proMadeIn</th>
		<th>Product proMfgDate</th>
		<th>Product proExpDate</th>
		<th>Product proImage</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
	<tr>
	<td>${product.proId}</td> 
	<td>${product.proName}</td> 
	<td>${product.proPrice}</td> 
	<td>${product.proBrand}</td> 
	<td>${product.proMadeIn}</td> 
	<td>${product.proMfgDate}</td> 
	<td>${product.proExpDate}</td>
	<td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}"alt="Product image" style="max-width: 100px; max-height:100px;"> </td> 
	</tr>
	</c:forEach>
</tbody>
	</table>
</body>
</html>