/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.employee.ra201701;

import crud.dao.EmpleadoDao;
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
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);//To change body of generated methods, choose Tools | Templates.
    
        EmpleadoDao.delete(id);
        resp.sendRedirect("ViewEmployee");
    }
    
    
}
