package com.appointment.servlet;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.appointment.dao.*;
import com.appointment.model.*;

@WebServlet("/UpdateAppointmentServlet")
public class UpdateAppointmentServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        AppointmentDAO dao = new AppointmentDAOImpl();
        Appointment appointment = dao.getAppointmentById(id);

        request.setAttribute("appointment", appointment);
        RequestDispatcher rd = request.getRequestDispatcher("/view/update_appointment.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("appointmentid"));
        String clientName = request.getParameter("clientname");
        String service = request.getParameter("service");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(id);
        appointment.setClientName(clientName);
        appointment.setService(service);
        appointment.setDate(date);
        appointment.setTime(time);

        AppointmentDAO dao = new AppointmentDAOImpl();
        dao.updateAppointment(appointment);

        response.sendRedirect(request.getContextPath() + "/view/view_appointments.jsp");
    }
}
