/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.product.ra201701;

import crud.dao.EmpleadoDao;
import crud.dao.ProductDao;
import crud.model.Empleado;
import crud.model.Product;
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
@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //To change body of generated methods, choose Tools | Templates.
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String stockStr = req.getParameter("stock");
        String dateAdded = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setDateadded(dateAdded);
        int status = ProductDao.save(p);
        if(status > 0){
            out.print("<p style='color: red;'>Se guardo correctamente</p>");
            req.setAttribute("refListProduct", "ViewProduct");
            req.getRequestDispatcher("product/index.jsp").include(req, resp);
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
