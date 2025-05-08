package goldenoaks.controllers;

import goldenoaks.business.Movie;
import goldenoaks.data.MovieDb;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "add":
                url = addMovie(request, response);
                break;
            case "delete":
                url = deleteMovie(request, response);
                break;
            default:
                url = showMovieList(request, response);
                break;
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "";
        switch (action) {
            case "add":
                url = addMovie(request, response);
                break;
            case "delete":
                url = deleteMovie(request, response);
                break;
            default:
                url = showMovieList(request, response);
                break;
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    private String showMovieList(HttpServletRequest request, HttpServletResponse response) {
        List<Movie> movieList = MovieDb.selectAllMovies();
        request.setAttribute("movieList", movieList);
        return "/movieList.jsp";
    }
    
    private String addMovie(HttpServletRequest request, HttpServletResponse response) {
        Movie movie = new Movie();
        movie.setTitle(request.getParameter("title"));
        movie.setActors(request.getParameter("actors"));
        movie.setDirectors(request.getParameter("directors"));
        movie.setGenre(request.getParameter("genre"));

        MovieDb.addMovie(movie);
        return showMovieList(request, response);
    }

    private String deleteMovie(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        MovieDb.deleteMovie(id);
        return showMovieList(request, response);
    }
}
