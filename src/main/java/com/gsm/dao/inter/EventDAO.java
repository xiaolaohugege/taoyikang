package com.gsm.dao.inter;

import com.gsm.bean.Event;
import java.util.List;

public interface EventDAO {
    void createEvent(Event event) throws Exception;
    void updateEvent(Event event) throws Exception;
    void deleteEvent(int eventID) throws Exception;
    Event getEventById(int eventID) throws Exception;
    List<Event> getAllEventsByUser(int userID) throws Exception;
    List<Event> searchEvents(String keyword) throws Exception;

    List<Event> findAllByUser(int userID)  throws Exception;
    // 其他必要的方法
}
