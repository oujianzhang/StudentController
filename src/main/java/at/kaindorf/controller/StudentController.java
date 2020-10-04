/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.controller;

import at.kaindorf.beans.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oujia
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    private List<Student> studentlist = new LinkedList<Student>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Path path = Path.of(this.getServletContext().getRealPath("/students_2020.csv"));
        try {
            /*
            Klasse;Familienname;Vorname;Geschlecht;2001-08-27
4AHIF;      ADAM;Florian;m;2002-04-25
            String nachname, String vorname, int katalognummer, String klasse, char gender, LocalDate birthdat
             */
            Files.lines(path).collect(Collectors.toList());

        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("studentView.jsp").forward(request, response);
        }
    }

    /*
    <%
                ArrayList<String> list1 = (ArrayList<String>) request.getAttribute("res1");
                list1.add("sup");
            %>
            <select name="schueler">
                <%
                    for (String list : list1) {%>
                <option><%=list%></option>

                <% }
                %>
            </select>
     */
    //to get path this.getServletContext().getRealPath("/");
    /*
        Filtern, beim ersten mal nicht
        filter nur für nachnamen
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("student-entries", studentlist);

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /*
     <c:forEach items="${student-entries}" var="student">
                    <option value="${student.nachname}">${student.nachname} + " " +${student.vorname}</option>
                </c:forEach>
     */
}
