<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />

<title>Register</title>
</head>
<body>
	<div id="content">
		<div>
			<h3>Register and account</h3>
			<form action="#" id="register">
				<div class="first">
					<fieldset>
						<label for="name"><strong>Name:</strong></label><input type="text"
							maxlength="55" id="name" class="inputtext"> <label
							for="email"><strong>Email:</strong></label><input type="text"
							maxlength="55" id="email" class="inputtext"> <label
							for="password"><strong>Password:</strong></label><input
							type="text" maxlength="55" id="password" class="inputtext">
						<label for="confirmpass"><strong>Confirm
								Password:</strong></label><input type="text" maxlength="55" id="confirmpass"
							class="inputtext"> <label for="address"><strong>Address:</strong></label><input
							type="text" maxlength="55" id="address" class="inputtext">
						<label for="status"><strong>Status:</strong></label><input
							type="text" maxlength="55" id="address" class="inputtext">
						<div>
							<label for="newsletter"><input type="checkbox"
								id="newsletter"><span>Subscribe to newsletter</span></label> <label
								class="terms" for="terms"><input type="checkbox"
								id="terms"><span>I agree to the Terms and
									Conditions</span></label>
						</div>
					</fieldset>
				</div>
				<input type="submit" value="" id="createaccount">
			</form>
		</div>
	</div>
</body>
</html>