<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>T-Shirt Store</title>
</head>
<body>
<h2 align="center">My T-Shirt Store</h2>
 <form action="MyServlet" method="POST">
  	  <label>Choose Accessories: </label><br>
	  <input type="checkbox" name="accessories" value="belt">Belt<br>
	  <input type="checkbox" name="accessories" value="cap">Cap<br>
	  <input type="checkbox" name="accessories" value="hairband">Hair Band<br>
	  <input type="checkbox" name="accessories" value="glasses">Glasses<br>
  	
  	<label>Enter Tagline: </label><br>
  	<input type="text" name="tagline" placeholder="Enter tagline"><br>
  	
  	<label>Choose Shirt Type: </label><br>
  	<input type="radio" name="pocket" value="with"> With Pocket<br>
  	<input type="radio" name="pocket" value="without"> Without Pocket <br>
  	
  	<label>Choose Shirt Color: </label><br>
  	<select name="color">
		  <option value="blue">Blue</option>
	  	<option value="red">Red</option>
	  	<option value="black">Black</option>
	  	<option value="white">White</option>
  	</select>
  <br><br>
  <input type="submit" value="Click Me">
 </form> 
</body>
</html>