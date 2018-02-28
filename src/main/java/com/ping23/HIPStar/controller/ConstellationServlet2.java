package main.java.com.ping23.HIPStar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import main.java.com.ping23.HIPStar.HeavenlyData;
import main.java.com.ping23.HIPStar.model.Constellation;

/**
 * Servlet implementation class
 */
@WebServlet(description = "A servlet to serve a list of constellations.",
    urlPatterns = { "/constellations2" })
public class ConstellationServlet2 extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConstellationServlet2()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    } // doGet()

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {

        List<Constellation> constellations = HeavenlyData.getConstellations();
        String jsonConstellations = new Gson().toJson(constellations);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonConstellations);        

    } // doPost()

}
