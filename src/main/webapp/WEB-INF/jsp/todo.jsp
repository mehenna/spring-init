<%@ include file="commun/header.jspf"%>
<%@ include file="commun/navigation.jspf"%>
<div class="container">
	<f:form method="post" modelAttribute="todo">
		<f:hidden path="id" />
		<fieldset class="form-group">
			<f:label path="desc">Description </f:label>
			<f:input path="desc" type="text" class="form-control"
				required="required" />
			<f:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<f:label path="targetdate">Target date </f:label>
			<f:input path="targetdate" type="text" class="form-control"
				required="required" />
			<f:errors path="targetdate" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Add</button>
	</f:form>
</div>
<%@ include file="commun/footer.jspf"%>
