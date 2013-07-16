<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form class="form" method="post" modelAttribute="addMultipleProductsForm" enctype="multipart/form-data" >
	<h2 class="form-heading">Add to Catalog</h2>
	<form:errors path="" element="p" class="text-error" />
	<p>Products Details</p>
	<form:label for="file" path="file">File</form:label><br/>
    <form:input path="file" type="file"/>
	<button class="btn btn-large btn-primary" type="submit">Add Product</button>
</form:form>

sarat