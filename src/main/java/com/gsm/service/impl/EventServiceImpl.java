package com.gsm.service.impl;

import com.gsm.bean.Event;
import com.gsm.dao.impl.EventDAOImpl;
import com.gsm.dao.inter.EventDAO;
import com.gsm.service.inter.EventService;
import java.util.List;

public class EventServiceImpl implements EventService {
    private EventDAO eventDAO = new EventDAOImpl();

    @Override
    public void createEvent(Event event) throws Exception {
        eventDAO.createEvent(event);
    }

    @Override
    public void updateEvent(Event event) throws Exception {
        eventDAO.updateEvent(event);
    }

    @Override
    public void deleteEvent(int eventID) throws Exception {
        eventDAO.deleteEvent(eventID);
    }

    @Override
    public Event getEventById(int eventID) throws Exception {
        return eventDAO.getEventById(eventID);
    }

    @Override
    public List<Event> getAllEventsByUser(int userID) throws Exception {
        return eventDAO.findAllByUser(userID);
    }

    @Override
    public List<Event> searchEvents(String keyword) throws Exception {
        return eventDAO.searchEvents(keyword);
    }
}
