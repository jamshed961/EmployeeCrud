<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file= "./base.jsp"%>
</head>
<body>
<h1> this is add product</h1>
<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-centre mb-3">Change product details</h1>
<form action="${pageContext.request.contextPath}/handle-product" method="post">
<input type="text" value="${product.pid}" name="id"/>

<div class= "form-group">
<label for="name">Product Name</label> <input type="text"
 class="form-control" id="name" aria-describedby="emailHelp"
  name="name" placeholder="Enter product name here" value="${product.name}">
</div>

<div class= "form-group">
<label for="description">Product Description</label>
 <textarea class="form-control" name="name" id="description" 
   rows="5" placeholder="Enter product description here">${product.description}</textarea>
</div>

<div class="form-group">
    <label for="price">Product Price</label>
    <input type="text" class="form-control" id="price" name="price" placeholder="Enter product price here" value="${product.price}">
</div>

<div class="container text-centre">
<a href="${pageContext.request.contextPath}"
 class="btn btn-outline-danger">Back</a>
 <button type="submit" class="btn btn-primary">Update</button>
</div>


</form>

</div>
</div>
</div>

</body>
</html>