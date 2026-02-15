<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Appointment Booking System</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>
<header>
    <h1>Appointment Booking System</h1>
    <nav>
        <a href="<%= request.getContextPath() %>/view/add_appointment.jsp">Add Appointment</a>
        <a href="<%= request.getContextPath() %>/view/view_appointments.jsp">View Appointments</a>
    </nav>
</header>

<div style="text-align:center; margin-top:50px;">
    <h2>Welcome to Appointment Booking System</h2>
    <p>Use the navigation above to manage your appointments.</p>
</div>

<footer>
    &copy; 2026 Appointment Booking System
</footer>
</body>
</html>
