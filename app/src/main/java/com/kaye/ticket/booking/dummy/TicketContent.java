package com.kaye.ticket.booking.dummy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TicketContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TicketDummyItem> ITEMS = new ArrayList<TicketDummyItem>();


    static {
        addTicketsBooking("1");
        addTicketsBooking("2");
        addTicketsBooking("3");
    }


    public static void addTicketsBooking(String eventID) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        ITEMS.add(new TicketDummyItem(eventID, String.valueOf(System.currentTimeMillis()), strDate));
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class TicketDummyItem {
        public final String eventID, ticketID, regisDate;

        public TicketDummyItem(String eventID, String ticketID, String regisDate) {
            this.eventID = eventID;
            this.ticketID = ticketID;
            this.regisDate = regisDate;
        }


        public String getRegisDate() {
            return regisDate;
        }

        public String getTicketID() {
            return ticketID;
        }


    }
}