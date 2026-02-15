package com.appointment.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.appointment.dao.AppointmentDAO;
import com.appointment.dao.AppointmentDAOImpl;

@WebServlet("/DeleteAppointmentServlet")
public class DeleteAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String idParam = request.getParameter("id");

    	if (idParam != null && !idParam.isEmpty()) {
    	    int id = Integer.parseInt(idParam);

    	    AppointmentDAO dao = new AppointmentDAOImpl();
    	    dao.deleteAppointment(id);
    	}


        response.sendRedirect(request.getContextPath() + "/view/view_appointments.jsp");
    }
}
