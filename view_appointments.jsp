<%@ page import="java.util.List" %>
<%@ page import="com.appointment.model.Appointment" %>
<%@ page import="com.appointment.dao.AppointmentDAO" %>
<%@ page import="com.appointment.dao.AppointmentDAOImpl" %>
<%
String keyword = request.getParameter("keyword");
AppointmentDAO dao = new AppointmentDAOImpl();
List<Appointment> list;

if (keyword != null && !keyword.isEmpty()) {
    list = dao.searchAppointment(keyword);
} else {
    list = dao.getAllAppointments();
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Appointments</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<header>
    <h1>View Appointments</h1>
    <nav>
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="<%= request.getContextPath() %>/view/add_appointment.jsp">Add Appointment</a>
    </nav>
</header>

<form method="get" class="search-form">
    <input type="search" name="keyword" placeholder="Search by client name or date" value="<%= (keyword!=null)?keyword:"" %>">
    <input type="submit" value="Search">
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Client Name</th>
        <th>Service</th>
        <th>Date</th>
        <th>Time</th>
        <th>Action</th>
    </tr>
    <%
        for (Appointment a : list) {
    %>
    <tr>
        <td><%= a.getAppointmentId() %></td>
        <td><%= a.getClientName() %></td>
        <td><%= a.getService() %></td>
        <td><%= a.getDate() %></td>
        <td><%= a.getTime() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/UpdateAppointmentServlet?id=<%= a.getAppointmentId() %>">Update</a> |
            <a href="<%= request.getContextPath() %>/DeleteAppointmentServlet?id=<%= a.getAppointmentId() %>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<footer>
    &copy; 2026 Appointment Booking System
</footer>
</body>
</html>
