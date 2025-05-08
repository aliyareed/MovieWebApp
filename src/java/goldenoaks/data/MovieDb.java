package goldenoaks.data;

import goldenoaks.business.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDb {

    public static int addMovie(Movie movie) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "INSERT INTO Movies "
                + "(Title, Actors, Directors, Genre) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getActors());
            ps.setString(3, movie.getDirectors());
            ps.setString(4, movie.getGenre());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static List<Movie> selectAllMovies() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movies";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setCheckoutNumber(rs.getLong("CheckoutNumber"));
                movie.setTitle(rs.getString("Title"));
                movie.setActors(rs.getString("Actors"));
                movie.setDirectors(rs.getString("Directors"));
                movie.setGenre(rs.getString("Genre"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

        return movies;
    }

    public static int deleteMovie(long checkoutNumber) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM Movies WHERE CheckoutNumber = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, checkoutNumber);
             return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}