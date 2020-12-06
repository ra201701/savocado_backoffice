/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import crud.dao.EmpleadoDao;
import crud.dao.ProductDao;
import crud.model.Empleado;
import crud.model.Product;
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
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Product> list = ProductDao.getProducts();
        req.setAttribute("listProduct", list);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/product/viewProduct.jsp");
        view.forward(req, resp);
    }
    
}
