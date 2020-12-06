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
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        Empleado e = EmpleadoDao.getEmployee(id);
        req.setAttribute("employee", e);
        req.setAttribute("refListEmployee", "ViewEmployee");
        RequestDispatcher view = getServletContext().getRequestDispatcher("/employee/editEmployee.jsp");
        view.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        
        Empleado e = new Empleado();
        e.setId(id);
        e.setName(name);
        e.setPassword(pass);
        e.setEmail(email);
        e.setCountry(country);
        
        int status = EmpleadoDao.update(e);
        if(status > 0){
            resp.sendRedirect("ViewEmployee");
        } else {
            out.println("No se pudo guardar");
        }
        out.close();
    }
    
}
