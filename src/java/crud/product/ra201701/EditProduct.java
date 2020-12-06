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
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        Product p = ProductDao.getProduct(id);
        req.setAttribute("product", p);
        req.setAttribute("refListProduct", "ViewProduct");
        RequestDispatcher view = getServletContext().getRequestDispatcher("/product/editProduct.jsp");
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String stockStr = req.getParameter("stock");
        
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        
        Product p = new Product();
        p.setID(id);
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        
        int status = ProductDao.update(p);
        if(status > 0){
            resp.sendRedirect("ViewProduct");
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
