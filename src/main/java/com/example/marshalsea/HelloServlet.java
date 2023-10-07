package com.example.marshalsea;

import java.io.*;
import java.util.Collection;

import added.Added;
import artist.Artist;
import artist.IArtistDAO;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import playlist.IPlaylistDAO;
import playlist.Playlist;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    private IArtistDAO artistDAO;
    @EJB
    private IPlaylistDAO playlistDAO;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        Collection<Artist> artists = artistDAO.getAll();
        for(Artist artist: artists)
            out.println("<h1>" + artist + "</h1>");

        Collection<Playlist> playlists = playlistDAO.getAll();
        for(Playlist playlist: playlists)
            for(Added added: playlist.getTracklist())
                out.println("<h1>" + added.getTrack() + " - " + added.getUser() + "</h1>");

        out.println("</body></html>");

    }

    public void destroy() {}
}