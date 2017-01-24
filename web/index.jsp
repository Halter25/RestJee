<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 21/01/2017
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>RestJee</title>
</head>
<body>
<!-- DIRECTORS -->
<h3>Add Director</h3>
<form action="http://localhost:8080/RestJee_war_exploded/rest/directors" method="POST"> <!-- TODO change URL -->
    <label for="firstName">First Name</label>
    <input id="firstName" name="firstName"/>
    <br/>
    <label for="lastName">Last Name</label>
    <input id="lastName" name="lastName"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
<hr>
<!-- MOVIES -->
<h3>Add Movie</h3>
<form action="http://localhost:8080/RestJee_war_exploded/rest/movies" method="POST"> <!-- TODO change URL -->
    <label for="title">Title</label>
    <input id="title" name="title"/>
    <br/>
    <label for="director">DirectorID</label> <!-- TODO Menu déroulant des réalisateurs -->
    <input id="director" name="director"/>
    <br/>
    <label for="year">Year</label>
    <input id="year" name="year"/>
    <br/>
    <label for="laureate"> Laureate </label>
    <input type="checkbox" id="laureate" name="laureate" value="true">
    <br/>
    <input type="submit" value="Submit"/>
</form>
<hr>
<!-- COMMENTARIES -->
<h3>Add Commentary</h3>
<form action="http://localhost:8080/RestJee_war_exploded/rest/commentaries" method="POST"> <!-- TODO change URL -->
    <label for="movieId">Movie Id</label> <!-- TODO Menu déroulant des films -->
    <input id="movieId" name="movieId"/>
    <br/>
    <label for="author">Author</label>
    <input id="author" name="author"/>
    <br/>
    <label for="content">Content</label>
    <input id="content" name="content"/>
    <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
