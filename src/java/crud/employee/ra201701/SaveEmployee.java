/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.employee.ra201701;

import crud.dao.EmpleadoDao;
import crud.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgarrenderos
 */
@WebServlet("/SaveEmployee")
public class SaveEmployee extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //To change body of generated methods, choose Tools | Templates.
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        
        Empleado e = new Empleado();
        e.setName(name);
        e.setPassword(pass);
        e.setEmail(email);
        e.setCountry(country);
        int status = EmpleadoDao.save(e);
        if(status > 0){
            out.print("<p style='color: red;'>Se guardo correctamente</p>");
            req.setAttribute("refListEmployee", "ViewEmployee");
            req.getRequestDispatcher("employee/index.jsp").include(req, resp);
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
