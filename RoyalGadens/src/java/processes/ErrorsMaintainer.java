/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorsMaintainer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (statusCode == 404) {
            response.sendRedirect("not-found.jsp");
        }

//        if (servletName == null) {
//            servletName = "Unknown";
//        }
//        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
//        if (requestUri == null) {
//            requestUri = "Unknown";
//        }
//
//        // Set response content type
//        response.setContentType("text/html");
//        String title = "Error/Exception Information";
//        out.println("<html>\n"
//                + "<head><title>" + title + "</title></head>\n"
//                + "<body bgcolor=\"#f0f0f0\">\n");
//
//        if (throwable == null && statusCode == null) {
//            out.println("<h2>Error information is missing</h2>");
//            out.println("Please return to the <a href=\""
//                    + response.encodeURL("http://localhost:8080/")
//                    + "\">Home Page</a>.");
//        } else if (statusCode != null) {
//            out.println("The status code : " + statusCode);
//        } else {
//            out.println("<h2>Error information</h2>");
//            out.println("Servlet Name : " + servletName
//                    + "</br></br>");
//            out.println("Exception Type : "
//                    + throwable.getClass().getName()
//                    + "</br></br>");
//            out.println("The request URI: " + requestUri
//                    + "<br><br>");
//            out.println("The exception message: "
//                    + throwable.getMessage());
//        }
//        out.println("</body>");
//        out.println("</html>");
    }

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

}
