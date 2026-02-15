package com.appointment.dao;

import java.util.List;
import com.appointment.model.Appointment;

public interface AppointmentDAO {
    void addAppointment(Appointment a);
    List<Appointment> getAllAppointments();
    void deleteAppointment(int id);  
    Appointment getAppointmentById(int id);
    void updateAppointment(Appointment appointment);
    
     List<Appointment> searchAppointment(String keyword);

}
