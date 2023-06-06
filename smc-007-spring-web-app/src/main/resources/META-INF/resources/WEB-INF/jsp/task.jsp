<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="container">
		<h1>Add Task</h1>

		<form:form action="add-task" method="post" modelAttribute="task">
			<form:input type="hidden" path="id" />
			<br />
			<form:input type="hidden" path="username" />
			<br />
			<fieldset class="my-1">
				<form:label path="description">Description</form:label>
				<form:input type="text" placeholder="Description" path="description"
					required="true" focus="true" />
				<br />
				<form:errors path="description" cssClass="text-danger" />
			</fieldset>

			<fieldset class="my-1">
				<form:label path="description">Target Date</form:label>
				<form:input type="text" path="targetDate" required="true"
					focus="true" />
				<br />
				<form:errors path="targetDate" cssClass="text-danger" />
			</fieldset>

			<form:input type="hidden" path="targetDate" />
			<br />
			<form:input type="hidden" path="done" />
			<br />
			<input type="submit" value="Submit" />
		</form:form>

	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />