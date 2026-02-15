package com.appointment.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.appointment.dao.*;
import com.appointment.model.*;

@WebServlet("/AddAppointmentServlet")
public class AddAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Call doPost from doGet (safe fallback)
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String clientName = request.getParameter("clientname");
        String service = request.getParameter("service");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        System.out.println("DEBUG: " + clientName + " " + service + " " + date + " " + time);

        Appointment appointment = new Appointment();
        appointment.setClientName(clientName);
        appointment.setService(service);
        appointment.setDate(date);
        appointment.setTime(time);

        AppointmentDAO dao = new AppointmentDAOImpl();
        dao.addAppointment(appointment);

        response.sendRedirect(request.getContextPath() + "/view/view_appointments.jsp");
    }
}
