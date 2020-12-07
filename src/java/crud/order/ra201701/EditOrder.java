/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.order.ra201701;

import crud.dao.OrderDao;
import crud.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/EditOrder")
public class EditOrder extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        Order o = OrderDao.getOrder(id);
        req.setAttribute("order", o);
        req.setAttribute("refListOrder", "ViewOrder");
        RequestDispatcher view = getServletContext().getRequestDispatcher("/order/editOrder.jsp");
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = req.getParameter("name");
        String totalStr = req.getParameter("total");
        
        double total = Double.parseDouble(totalStr);
        
        Order o = new Order();
        o.setID(id);
        o.setName(name);
        o.setTotal(total);
        
        int status = OrderDao.update(o);
        if(status > 0){
            resp.sendRedirect("ViewOrder");
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
