<%@ page import="com.appointment.model.Appointment" %>
<%
Appointment a = (Appointment) request.getAttribute("appointment");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Appointment</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<header>
    <h1>Update Appointment</h1>
    <nav>
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="<%= request.getContextPath() %>/view/view_appointments.jsp">View Appointments</a>
    </nav>
</header>

<form action="<%= request.getContextPath() %>/UpdateAppointmentServlet" method="post">
    <input type="hidden" name="appointmentid" value="<%= a.getAppointmentId() %>">

    Client Name:
    <input type="text" name="clientname" value="<%= a.getClientName() %>" required>

    Service:
    <input type="text" name="service" value="<%= a.getService() %>" required>

    Date:
    <input type="date" name="date" value="<%= a.getDate() %>" required>

    Time:
    <input type="time" name="time" value="<%= a.getTime() %>" required>

    <input type="submit" value="Update Appointment">
</form>

<footer>
    &copy; 2026 Appointment Booking System
</footer>
</body>
</html>
