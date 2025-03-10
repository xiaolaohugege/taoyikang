package com.gsm.dao.impl;

import com.gsm.bean.Event;
import com.gsm.dao.inter.EventDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {

    @Override
    public void createEvent(Event event) throws Exception {
        String sql = "INSERT INTO Events (ModuleID, Title, EventTime, Announcement, Description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, event.getModuleID());
            stmt.setString(2, event.getTitle());
            stmt.setTimestamp(3, new java.sql.Timestamp(event.getEventTime().getTime()));
            stmt.setString(4, event.getAnnouncement());
            stmt.setString(5, event.getDescription());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateEvent(Event event) throws Exception {
        String sql = "UPDATE Events SET ModuleID = ?, Title = ?, EventTime = ?, Announcement = ?, Description = ? WHERE EventID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, event.getModuleID());
            stmt.setString(2, event.getTitle());
            stmt.setTimestamp(3, new java.sql.Timestamp(event.getEventTime().getTime()));
            stmt.setString(4, event.getAnnouncement());
            stmt.setString(5, event.getDescription());
            stmt.setInt(6, event.getEventID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteEvent(int eventID) throws Exception {
        String sql = "DELETE FROM Events WHERE EventID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventID);
            stmt.executeUpdate();
        }
    }

    @Override
    public Event getEventById(int eventID) throws Exception {
        String sql = "SELECT * FROM Events WHERE EventID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractEvent(rs);
            }
        }
        return null;
    }

    @Override
    public List<Event> getAllEventsByUser(int userID) throws Exception {
        // 假设有一个关联表User_Events记录用户创建的活动
        // 需要根据实际需求调整
        String sql = "SELECT e.* FROM Events e JOIN User_Events ue ON e.EventID = ue.EventID WHERE ue.UserID = ?";
        List<Event> events = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                events.add(extractEvent(rs));
            }
        }
        return events;
    }

    @Override
    public List<Event> searchEvents(String keyword) throws Exception {
        String sql = "SELECT * FROM Events WHERE Title LIKE ? OR Description LIKE ?";
        List<Event> events = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                events.add(extractEvent(rs));
            }
        }
        return events;
    }

    @Override
    public List<Event> findAllByUser(int userID) throws Exception {
        return null;
    }

    private Event extractEvent(ResultSet rs) throws Exception {
        Event event = new Event();
        event.setEventID(rs.getInt("EventID"));
        event.setModuleID(rs.getInt("ModuleID"));
        event.setTitle(rs.getString("Title"));
        event.setEventTime(rs.getTimestamp("EventTime"));
        event.setAnnouncement(rs.getString("Announcement"));
        event.setDescription(rs.getString("Description"));
        return event;
    }
}
