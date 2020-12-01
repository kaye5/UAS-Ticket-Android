package com.kaye.ticket.events.dummy;

import com.kaye.ticket.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListEventsContent {
    public static final List<ListEventsContent.EventsDummy> ITEMS = new ArrayList<>();

    static {
        // Add some sample items.
        for (int i = 0; i <= 10; i++) {
            String title = "Event " + i;
            String description = "Description Events " + i;
            String time = "2020-11-28";
            Random rand = new Random();
            Integer temp = rand.nextInt(3);
            if(temp == 1)
                temp = R.drawable.ic_event_1;
            else if(temp == 2)
                temp = R.drawable.ic_event_2;
            else
                temp = R.drawable.ic_event_3;
            ITEMS.add(new EventsDummy(String.valueOf(i), title, time, description, temp));
        }
    }


    public static class EventsDummy {

        public final String time, description, title, eventID;
        public final Integer img;

        public EventsDummy(String id, String title, String time, String description, Integer img) {
            this.img = img;
            this.eventID = id;
            this.title = title;
            this.time = time;
            this.description = description;
        }

        public String getEventID() {
            return eventID;
        }

        public String getTime() {
            return time;
        }

        public String getTitle() {
            return title;
        }

        public Integer getImg() {
            return img;
        }

        public String getDescription() {
            return description;
        }
    }
}
