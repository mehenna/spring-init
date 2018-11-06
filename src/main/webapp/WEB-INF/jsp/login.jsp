<%@ include file="commun/header.jspf"%>
<%@ include file="commun/navigation.jspf"%>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post">
		Name : <input type="text" name="name" /> Pw :<input type="password"
			name="pw" /> <input type="submit">
	</form>
</div>
<%@ include file="commun/footer.jspf"%>