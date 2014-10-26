/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import model.CoffeeExpert;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class CoffeeSelect extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String c = request.getParameter("type");

        // Now use our Coffee Model above 
        CoffeeExpert ce = new CoffeeExpert();

        List result = ce.getTypes(c);

        // Use the below code to debug the program if you get problems 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Coffee Selection Advise<br>");

        Iterator it = result.iterator();
        while(it.hasNext()) {
          out.print("<br>try: " + it.next());
        }

        // The results will be passed back (as an attribute) to the JSP view
        // The attribute will be a name/value pair, the value in this case will be a List object 
        request.setAttribute("styles", result);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response); 
    }
}
