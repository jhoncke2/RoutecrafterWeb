package com.routecrafter.dao;

import com.routecrafter.config.DatabaseConnection;
import com.routecrafter.model.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAO {

    public List<Route> getRoutesByCity(int cityId) {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT * FROM routes WHERE city_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cityId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Route r = new Route();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setDescription(rs.getString("description"));
                r.setCityId(rs.getInt("city_id"));
                routes.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public boolean insertRoute(Route route) {
        String sql = "INSERT INTO routes (name, description, city_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, route.getName());
            stmt.setString(2, route.getDescription());
            stmt.setInt(3, route.getCityId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}