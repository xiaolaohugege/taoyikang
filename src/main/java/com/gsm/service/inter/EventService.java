package com.gsm.service.inter;

import com.gsm.bean.Event;
import java.util.List;

public interface EventService {
    void createEvent(Event event) throws Exception;
    void updateEvent(Event event) throws Exception;
    void deleteEvent(int eventID) throws Exception;
    Event getEventById(int eventID) throws Exception;
    List<Event> getAllEventsByUser(int userID) throws Exception;
    List<Event> searchEvents(String keyword) throws Exception;
}
