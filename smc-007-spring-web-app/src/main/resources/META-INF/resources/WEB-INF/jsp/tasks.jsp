<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="container">
		<h1>${name}'s&nbsp;tasks</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.id}</td>
						<td>${task.description }</td>
						<td>${task.targetDate}</td>
						<td>${task.done}</td>
						<td>
						<a href="update-task?id=${task.id}" class="btn btn-secondary" style="width: 5rem;">Edit</a>
							<a href="delete-task?id=${task.id}" class="btn btn-warning" style="width: 5rem;">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="add-task" class="btn btn-success" style="width: 8rem;">Add Task</a>
	</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />