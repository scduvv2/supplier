<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<form:form class="form" method="post" modelAttribute="profileForm">
	<h2 class="form-heading">Profle</h2>
	<form:errors path="" element="p" class="text-error" />
	<form:input path="firstName" class="input-block-level" placeholder="First Name" />
	<form:errors path="firstName" element="p" class="text-error"/> 
	<form:input path="lastName" class="input-block-level" placeholder="Last Name" />
	<form:errors path="lastName" element="p" class="text-error"/> 
	<form:input path="email" class="input-block-level" placeholder="Email address" /> 
	<form:errors path="email" element="p" class="text-error"/> 
	<form:input path="phoneNumber.phoneNumber" class="input-block-level" placeholder="Phone Number" />
	<form:errors path="phoneNumber.phoneNumber" element="p" class="text-error"/> 
	<p>Address:</p>
	<form:input path="address.addressLine1" class="input-block-level" placeholder="Address Line 1" />
	<form:errors path="address.addressLine1" element="p" class="text-error"/> 
	<form:input path="address.addressLine2" class="input-block-level" placeholder="Address Line 2" />
	<form:errors path="address.addressLine2" element="p" class="text-error"/> 
	<form:input path="address.city" class="input-block-level" placeholder="City" />
	<form:errors path="address.city" element="p" class="text-error"/> 
	<form:input path="address.state" class="input-block-level" placeholder="State" />
	<form:errors path="address.state" element="p" class="text-error"/> 
	<form:input path="address.country" class="input-block-level" placeholder="Country" />
	<form:errors path="address.country" element="p" class="text-error"/>
	<form:input path="address.zipCode" class="input-block-level" placeholder="Zip Code" />
	<form:errors path="address.zipCode" element="p" class="text-error"/>
	<security:authorize access="hasRole('merchant')">
		<c:if test="${ not empty store }">
   			<p>Shop Details:</p>
		   	<form:input path="store.name" class="input-block-level" placeholder="Store Name" />
			<form:errors path="store.name" element="p" class="text-error"/> 
			<form:input path="store.phoneNumber.phoneNumber" class="input-block-level" placeholder="Store Phone Number" />
			<form:errors path="store.phoneNumber.phoneNumber" element="p" class="text-error"/>
			<p>Shop Address</p>
			<form:input path="store.address.addressLine1" class="input-block-level" placeholder="Address Line 1" />
			<form:errors path="store.address.addressLine1" element="p" class="text-error"/> 
			<form:input path="store.address.addressLine2" class="input-block-level" placeholder="Address Line 2" />
			<form:errors path="store.address.addressLine2" element="p" class="text-error"/> 
			<form:input path="store.address.city" class="input-block-level" placeholder="City" />
			<form:errors path="store.address.city" element="p" class="text-error"/> 
			<form:input path="store.address.state" class="input-block-level" placeholder="State" />
			<form:errors path="store.address.state" element="p" class="text-error"/> 
			<form:input path="store.address.country" class="input-block-level" placeholder="Country" />
			<form:errors path="store.address.country" element="p" class="text-error"/>
			<form:input path="store.address.zipCode" class="input-block-level" placeholder="Zip Code" />
			<form:errors path="store.address.zipCode" element="p" class="text-error"/>
		</c:if> 
	</security:authorize>
	<button class="btn btn-large btn-primary" type="submit">Update</button>
</form:form>