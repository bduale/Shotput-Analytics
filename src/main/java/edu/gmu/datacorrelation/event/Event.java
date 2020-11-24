package edu.gmu.datacorrelation.event;

import edu.gmu.datacorrelation.toss.Throw;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Event {

    private String name;
    private Date occurred;
    private List<Throw> throwEvents;

    /**
     * Creates an Event.
     *
     * @param name     the name for the event
     * @param occurred the date the event occurred on
     */
    public Event(String name, Date occurred) {
        this.name = name;
        this.occurred = occurred;
        this.throwEvents = new ArrayList<>();
    }

    /**
     * Creates an event with null attributes (only with event name)
     */
    public Event(String name) {
        this.name = name;
    }
}
