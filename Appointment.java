package com.appointment.model;

public class Appointment {

    private int appointmentId;
    private String clientName;
    private String service;
    private String date;
    private String time;

    // Getter and Setter for appointmentId
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    // Getter and Setter for clientName
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    // Getter and Setter for service
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    // Getter and Setter for date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getter and Setter for time
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
