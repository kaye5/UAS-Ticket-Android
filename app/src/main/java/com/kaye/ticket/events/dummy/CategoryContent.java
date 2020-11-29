package com.kaye.ticket.events.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CategoryContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CategoryDummy> ITEMS = new ArrayList<CategoryDummy>();


    static {
        // Add some sample items.

        ITEMS.add(new CategoryDummy("Party"));
        ITEMS.add(new CategoryDummy("Webminar"));
        ITEMS.add(new CategoryDummy("Bar"));
        ITEMS.add(new CategoryDummy("Seminar"));
        ITEMS.add(new CategoryDummy("Around You"));
        ITEMS.add(new CategoryDummy("Banyak Tugas"));
        ITEMS.add(new CategoryDummy("Susah Kali"));

    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class CategoryDummy {
        public final String content;


        public CategoryDummy(String content) {
            this.content = content;

        }

    }
}