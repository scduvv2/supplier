<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form class="form" method="post" modelAttribute="addProductForm">
	<h2 class="form-heading">Add to Catalog</h2>
	<form:errors path="" element="p" class="text-error" />
	<p>Product Details</p>
	<form:input path="product.name" class="input-block-level" placeholder="Name" />
	<form:errors path="product.name" element="p" class="text-error"/> 
	<form:input path="product.brand" class="input-block-level" placeholder="Brand Name" />
	<form:errors path="product.brand" element="p" class="text-error"/> 
	<form:input path="product.barCode" class="input-block-level" placeholder="Bar Code" />
	<form:errors path="product.barCode" element="p" class="text-error"/> 
	<button class="btn btn-large btn-primary" type="submit">Add Product</button>
</form:form>