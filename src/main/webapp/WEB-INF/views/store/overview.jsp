<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<body>
	<div id="account" >
		<div id="name">${catalogPage.account.firstName } ${account.lastName } </div>
	</div>
	<div id="stores">
	<c:forEach var="store" items="${catalogPage.account.stores}">
		<div id="store">
			<p>${store.name }</p>
			<div id="address">
				<div id="adressLine1">${catalogPage.store.address.addressLine1}</div>
				<div id="adressLine2">${catalogPage.store.address.addressLine2}</div>
				<div id="city">${catalogPage.store.address.city}</div>
				<div id="state">${catalogPage.store.address.state}</div>
				<div id="country">${catalogPage.store.address.country}</div>
			</div>
			<c:forEach var="product" items="${store.catalog.products}">
				<div id="product"> 
					<div id="product-name">${product.name}</div>
					<div id="product-brand">${product.brand}</div>
				</div>
			</c:forEach>
			<div><a href="catalog/${store.catalog.id}/products/">add to Catalog</a></div>
	</c:forEach>
	</div>
</body>