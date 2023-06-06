<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="container">
		<h1>Welcome ${name}</h1>
		<a href="list-tasks">List tasks</a>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />