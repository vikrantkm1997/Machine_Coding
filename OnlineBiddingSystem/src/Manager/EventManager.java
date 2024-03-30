package Manager;

import Entity.Event;

import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private Map<Integer, Event> idToEventMap;
    private static EventManager eventManager;

    private EventManager() {
        this.idToEventMap = new HashMap<>();
    }

    public static EventManager getInstance() {
        if(eventManager == null)
        {
            eventManager = new EventManager();
        }
        return eventManager;
    }

    public Event addEvent(int id, String eventName, String eventPrize) {
        Event event = new Event(id, eventName, eventPrize);
        return idToEventMap.put(id,event);
    }

    public Map<Integer, Event> getIdToEventMap() {
        return idToEventMap;
    }

    public Event getEvent(int id) {
        return idToEventMap.get(id);
    }
}
