package com.routecrafter.controller;

import com.routecrafter.dao.RouteDAO;
import com.routecrafter.model.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/routes")
public class RouteServlet extends HttpServlet {
    private RouteDAO routeDAO;

    @Override
    public void init() {
        routeDAO = new RouteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cityIdParam = request.getParameter("cityId");
        if (cityIdParam != null && !cityIdParam.isEmpty()) {
            int cityId = Integer.parseInt(cityIdParam);
            List<Route> routes = routeDAO.getRoutesByCity(cityId);
            request.setAttribute("routes", routes);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int cityId = Integer.parseInt(request.getParameter("cityId"));

        Route newRoute = new Route(name, description, cityId);
        routeDAO.insertRoute(newRoute);

        response.sendRedirect("routes?cityId=" + cityId);
    }
}