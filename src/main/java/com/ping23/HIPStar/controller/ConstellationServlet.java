package main.java.com.ping23.HIPStar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.ping23.HIPStar.HeavenlyData;
import main.java.com.ping23.HIPStar.model.Constellation;

/**
 * Servlet implementation class ConstellationServlet
 */
@WebServlet(description = "A servlet to serve up Constellations.",
    urlPatterns = { "/constellations" })
public class ConstellationServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConstellationServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGetX(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    } // doGet()

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Constellation> constellations = HeavenlyData.getConstellations();

        // pass the message along with the request object
        request.setAttribute("constellations", constellations);
        
        // pass control to destination URL
        // url for response component
        String url = "constellations.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {

        // retrieve the data

        
        String iau_con = request.getParameter("iau_con");


        // url for response component
        String url = "response.jsp";
        
        String constellationFullname = HeavenlyData.getConstellationFullname(iau_con);
        
        // pass the message along with the request object
        request.setAttribute("constellationFullname", constellationFullname);
        
        // pass control to destination URL
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    } // doPost()

}
