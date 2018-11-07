<%@ include file="commun/header.jspf"%>
<%@ include file="commun/navigation.jspf"%>
<div class="container">
<h1>Tour Todos</h1>
<table class="table table-striped">
	<caption>Your todos are</caption>
	<thead>
		<tr>
			<th>Description</th>
			<th>Target date</th>
			<th>Is it done ?</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td><fmt:formatDate value="${todo.targetdate}" pattern="dd/MM/yyy" /></td>
				<td>${todo.done}</td>
				<td><a type="button" class="btn btn-success"
					href="/update-todo?id=${todo.id}">Update</a></td>
				<td><a type="button" class="btn btn-warning"
					href="/delete-todo?id=${todo.id}">Delete</a></td>
			<tr>
		</c:forEach>
	</tbody>
</table>
<div class="button"><a href="/add-todo">Add a TODO</a></div>
</div>
<%@ include file="commun/footer.jspf"%>