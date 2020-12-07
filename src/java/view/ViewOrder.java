/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crud.dao.EmpleadoDao;
import crud.dao.OrderDao;
import crud.model.Empleado;
import crud.model.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgarrenderos
 */
@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Order> list = OrderDao.getOrders();
        req.setAttribute("listOrder", list);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/order/viewOrder.jsp");
        view.forward(req, resp);
    }
    
}
