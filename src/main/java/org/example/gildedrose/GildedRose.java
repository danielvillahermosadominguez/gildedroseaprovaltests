package org.example.gildedrose;

import org.example.strategies.GildedRoseItemFactory;

import java.util.ArrayList;

public class GildedRose extends ArrayList<Update> {
    private final GildedRoseItemFactory factory;

    public GildedRose(GildedRoseItemFactory factory) {
        this.factory = factory;
    }

    public boolean addItem(Item item) {
        return this.add(this.factory.of(item));
    }

    public void updateQuality() {
        this.stream().forEach(item -> item.update());
    }

    public void addItems(Item[] items) {
        for (Item item : items) {
            this.addItem(item);
        }
    }
}