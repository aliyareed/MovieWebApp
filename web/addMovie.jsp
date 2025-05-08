<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href="styles/main.css">
    </head>
    <h1>Create Your Own List!</h1>
    <nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="actors.jsp">Actors</a></li>
        <li><a href="directors.jsp">Directors</a></li>
        <li><a href="genre.jsp">Genre</a></li>
        <li><a href="addMovie.jsp">Create List</a></li>
    </ul>
    </nav>
    <br>
    <section>
    <form action="goldenoaks" method="post">
        <input type="hidden" name="action" value="add"/>
        
        <label>Title</label>
        <input type="text" name="title"
               value="${movie.title}" required/><br>
        
        <label>Actors</label>
        <input type="text" name="actors"
               value="${movie.actors}" required/><br>
        
        <label>Directors</label>
        <input type="text" name="directors"
               value="${movie.directors}" required/><br>
        
        <label>Genre</label>
        <input type="text" name="genre" class="title"
               value="${movie.genre}" required/><br>
        <label>&nbsp;</label>
        <input type="submit" value="Add Movie"/>
        <a href="goldenoaks?action=manage">Review List</a>
    </form>
</section>
</html>
