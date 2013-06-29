<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<body>
	<div id="account" >
		<div id="name">${account.firstName } ${account.lastName } </div>
	</div>
	<div id="stores">
	<c:forEach var="store" items="${account.stores}">
		<div id="store">
			<p>${store.name }</p>
			<div id="address">
				<div id="adressLine1">${store.address.addressLine1}</div>
				<div id="adressLine2">${store.address.addressLine2}</div>
				<div id="city">${store.address.city}</div>
				<div id="state">${store.address.state}</div>
				<div id="country">${store.address.country}</div>
			</div>
			<div id="catalog">
				<c:choose>
					<c:when test="not empty ${store.catalog}">
					<table>
						<c:forEach var="product" items="${store.catalog.products}">
							<tr>
								<td>${product.name }</td>
								<td>${product.productId}</td>
							</tr>
						</c:forEach>
					</table>
					</c:when>
					<c:otherwise>
						<div id= "add-products">
							<form:form class="form" method="post" modelAttribute="addProductsForm" action="/catalog/${store.catalog.id}/product">
							<table>
								    <tr>
								        <th>Product Name</th>
								        <th></th>
								    </tr>
								    <c:forEach items="${addProductsForm.products}" var="product" begin="0" end="5" varStatus="status">
								        <tr>
								            <td align="center">${status.count}</td>
								            <td><input name="products[${status.index}].name" value="${product.name}"/></td>
								            <td><input name="products[${status.index}].brand" value="${product.brand}"/></td>
								        </tr>
								    </c:forEach>
								</table>
							</form:form>
							
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			
		</div>
	</c:forEach>
	</div>
</body>