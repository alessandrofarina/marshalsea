package com.example.marshalsea;

import java.io.*;
import java.util.Collection;

import artist.Artist;
import artist.IArtistDAO;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    private IArtistDAO artistDAO;

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
        out.println("</body></html>");

        Collection<Artist> artists = artistDAO.getAll();

        for(Artist artist: artists)
            System.out.println(artist);
    }

    public void destroy() {
    }
}