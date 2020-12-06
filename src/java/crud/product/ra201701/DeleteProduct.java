/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.product.ra201701;

import crud.dao.EmpleadoDao;
import crud.dao.ProductDao;
import crud.model.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author edgarrenderos
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);//To change body of generated methods, choose Tools | Templates.
    
        ProductDao.delete(id);
        resp.sendRedirect("ViewProduct");
    }
    
    
}
