package com.appointment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.appointment.model.Appointment;
import com.appointment.util.DBConnection;

public class AppointmentDAOImpl implements AppointmentDAO {

    // Add Appointment
    public void addAppointment(Appointment a) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO appointments(clientname, service, date, time) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, a.getClientName());
            ps.setString(2, a.getService());
            ps.setString(3, a.getDate());
            ps.setString(4, a.getTime());

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Appointments
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM appointments";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Appointment a = new Appointment();

                a.setAppointmentId(rs.getInt("appointmentid"));
                a.setClientName(rs.getString("clientname"));
                a.setService(rs.getString("service"));
                a.setDate(rs.getString("date"));
                a.setTime(rs.getString("time"));

                list.add(a);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    @Override
    public Appointment getAppointmentById(int id) {
        Appointment appointment = null;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM appointments WHERE appointmentid=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                appointment = new Appointment();
                appointment.setAppointmentId(rs.getInt("appointmentid"));
                appointment.setClientName(rs.getString("clientname"));
                appointment.setService(rs.getString("service"));
                appointment.setDate(rs.getString("date"));
                appointment.setTime(rs.getString("time"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointment;
    }

    @Override
    public void updateAppointment(Appointment appointment) {

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE appointments SET clientname=?, service=?, date=?, time=? WHERE appointmentid=?"
            );

            ps.setString(1, appointment.getClientName());
            ps.setString(2, appointment.getService());
            ps.setString(3, appointment.getDate());
            ps.setString(4, appointment.getTime());
            ps.setInt(5, appointment.getAppointmentId());

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Appointment> searchAppointment(String keyword) {

        List<Appointment> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM appointments WHERE clientname LIKE ? OR date LIKE ?"
            );

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointmentid"));
                a.setClientName(rs.getString("clientname"));
                a.setService(rs.getString("service"));
                a.setDate(rs.getString("date"));
                a.setTime(rs.getString("time"));

                list.add(a);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // Delete Appointment
    public void deleteAppointment(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM appointments WHERE appointmentid = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
