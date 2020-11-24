package edu.gmu.datacorrelation.event;

import edu.gmu.datacorrelation.DataCorrelation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author junio
 */
public class EventManager {
    private static final List<Event> event = Arrays.asList(
            new Event("Regional", new Date(1575332540513L)),
            new Event("County", new Date(1575332540511L)));

    public EventManager() {
        event.get(0).getThrowEvents().add(DataCorrelation.throwManager.getAllThrows().get(0));
        event.get(1).getThrowEvents().add(DataCorrelation.throwManager.getAllThrows().get(1));
    }

    public List<Event> getEvent() {
        return event;
    }

    public Optional<Event> getEvent(String name) {
        return getEvent().stream()
                .filter(eventName -> eventName.getName().equals(name))
                .findFirst();
    }
}