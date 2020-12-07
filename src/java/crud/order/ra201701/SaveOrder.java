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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgarrenderos
 */
@WebServlet("/SaveOrder")
public class SaveOrder extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //To change body of generated methods, choose Tools | Templates.
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String name = req.getParameter("name");
        String totalStr = req.getParameter("total");
        String dateOrdered = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        double total = Double.parseDouble(totalStr);
        
        Order o = new Order();
        o.setName(name);
        o.setTotal(total);
        o.setDateordered(dateOrdered);
        
        int status = OrderDao.save(o);
        if(status > 0){
            out.print("<p style='color: red;'>Se guardo correctamente</p>");
            req.setAttribute("refListOrder", "ViewOrder");
            req.getRequestDispatcher("order/index.jsp").include(req, resp);
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
