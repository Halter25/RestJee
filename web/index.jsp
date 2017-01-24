<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 21/01/2017
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
    <title>RestJee - Movie Ceremony</title>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css" media="screen,projection"/>
    <style>body {
        background-color: lightblue;
        margin: 30px;
    }

    main {
        padding: 10px;
        background-color: snow;
    }

    .input-field label {
        color: #000;
    }
    </style>
</head>
<body>
<main class="z-depth-2">
    <div class="row">

        <c:import var="directors" url="http://localhost:8080/RestJee_war_exploded/rest/directors" charEncoding="UTF-8"/>
        <x:parse xml="${directors}" var="output"/>
        <c:import var="movies" url="http://localhost:8080/RestJee_war_exploded/rest/movies" charEncoding="UTF-8"/>
        <x:parse xml="${movies}" var="outputmovie"/>

        <h1 class="center">Movie WebService</h1>
        <hr>

        <!-- MOVIES -->
        <div class="col l4 m12 s12">

            <h5 class="center">Add Movie</h5>
            <hr>
            <br>

            <form action="./rest/movies" method="POST">
                <p class="input-field">
                    <input id="title" type="text" name="title"/>
                    <label for="title">Title</label>
                </p>

                <p class="input-field">
                    <select name="directorId">
                        <option value="" disabled selected>Choose a director</option>
                        <x:forEach select="$output/directors/director" var="item">
                            <option value="<x:out select="$item/id" />">
                                <x:out select="$item/firstname"/> <x:out select="$item/lastname"/>
                            </option>
                        </x:forEach>
                    </select>
                    <label>Director</label>
                </p>

                <p class="input-field">
                    <input type="number" id="year" class="valid" name="year"/>
                    <label for="year">Year</label>
                </p>

                <p>
                    <input type="checkbox" class="filled-in" id="laureate" name="laureate" value="true">
                    <label for="laureate"> Laureate </label>
                </p>

                <p class="center">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        Add new movie <i class="material-icons right">movie</i>
                    </button>
                </p>
            </form>

        </div>

        <!-- DIRECTORS -->
        <div class="col l4 m12 s12">

            <h5 class="center">Add Director</h5>
            <hr>
            <br>

            <form action="./rest/directors" method="POST">

                <p class="input-field">
                    <input type="text" id="firstName" name="firstName"/>
                    <label for="firstName">First Name</label>
                </p>

                <p class="input-field">
                    <input type="text" id="lastName" name="lastName"/>
                    <label for="lastName">Last Name</label>
                </p>

                <p class="center">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        Add new director <i class="material-icons right">people</i>
                    </button>
                </p>
            </form>

        </div>

        <!-- COMMENTARIES -->
        <div class="col l4 m12 s12">

            <h5 class="center">Add Commentary</h5>
            <hr>
            <br>

            <form action="./rest/commentaries" method="POST">

                <p class="input-field">
                    <input type="text" id="author" name="author"/>
                    <label for="author">Author</label>
                </p>

                <p class="input-field">
                    <select id="movieId" name="movieId">
                        <option value="" disabled selected>Choose a movie</option>
                        <x:forEach select="$outputmovie/movies/movie" var="mov">
                            <option value="<x:out select="$mov/id" />"><x:out select="$mov/title"/></option>
                        </x:forEach>
                    </select>
                    <label for="movieId">Movie Id</label>
                </p>

                <p class="input-field">
                    <textarea id="content" class="materialize-textarea" name="content" length="200"></textarea>
                    <label for="content">Content</label>
                </p>

                <p class="center">
                    <button class="btn waves-effect waves-light" type="submit" name="action">
                        Send commentary <i class="material-icons right">send</i>
                    </button>
                </p>
            </form>

        </div>

    </div>
</main>

<script type="text/javascript" src="assets/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="assets/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('select').material_select();
        $('#content').trigger('autoresize');
        $('input#input_text, textarea#content').characterCounter();
    });
</script>
</body>
</html>
