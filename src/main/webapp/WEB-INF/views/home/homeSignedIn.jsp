<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<p>
	Hello <security:authentication property="principal.username" /><s:message code="header.welcome.message"/> <a href="dashboard">Click here </a> to go to Dashboard
</p>