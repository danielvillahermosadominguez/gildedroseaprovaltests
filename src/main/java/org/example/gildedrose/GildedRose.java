package org.example.gildedrose;

import org.example.strategies.GildedRoseItemFactory;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private List<Update> list;
    private final GildedRoseItemFactory factory;

    public GildedRose(GildedRoseItemFactory factory) {
        this.factory = factory;
        this.list = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        return list.add(this.factory.of(item));
    }

    public void updateQuality() {
        list.stream().forEach(item -> item.update());
    }

    public void addItems(Item[] items) {
        for (Item item : items) {
            this.addItem(item);
        }
    }

    public int size() {
        return list.size();
    }

    public Update get(int index) {
        return list.get(index);
    }
}