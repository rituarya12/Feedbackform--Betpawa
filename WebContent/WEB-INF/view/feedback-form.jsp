<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Customer Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
</head>
<body>

<i>Fill out the form. Asterisk (*) means required.</i>
<br><br>

	<form:form action="processForm" modelAttribute="feedback">
	
		Name: <form:input path="name" />
		
		<br><br>
		
		Description: <form:input path="description" />

		Rate:<form:input path="rate" />
		Date:<form:input path="date" />
		
		<br><br>

		<input type="submit" value="Submit" />
				
	</form:form>

</body>

</html>










