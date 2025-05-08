<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="movieList">
    <h1>Current Movie List</h1>
    
    <table>
        <tr>
            <th>Title</th>
            <th>Actors</th>
            <th>Directors</th>
            <th>Genre</th>
            <th>Action</th>
        </tr>
        
        <c:forEach var="movie" items="${movieList}">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.actors}</td>
                <td>${movie.directors}</td>
                <td>${movie.genre}</td>

                <td>
                    <form action="goldenoaks/deleteMovie" method="post">
                        <input type="hidden" name="id" value="${movie.checkoutNumber}"/>
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <p><a href="index.jsp">Return to front page</a></p>
</section>
</body>
</html>
