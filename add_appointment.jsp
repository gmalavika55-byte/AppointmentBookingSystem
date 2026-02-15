<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Appointment</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<header>
    <h1>Add Appointment</h1>
    <nav>
        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
        <a href="<%= request.getContextPath() %>/view/view_appointments.jsp">View Appointments</a>
    </nav>
</header>

<form action="<%= request.getContextPath() %>/AddAppointmentServlet" method="post">
    Client Name:
    <input type="text" name="clientname" required><br>

    Service:
    <input type="text" name="service" required><br>

    Date:
    <input type="date" name="date" required><br>

    Time:
    <input type="time" name="time" required><br>

    <input type="submit" value="Add Appointment">
</form>

<footer>
    &copy; 2026 Appointment Booking System
</footer>
</body>
</html>
