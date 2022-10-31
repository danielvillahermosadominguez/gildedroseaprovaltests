package org.example.gildedrose;

import org.example.container.StrategyContainer;

public class GildedRose {
    private final StrategyContainer container;
    Item[] items;

    public GildedRose(Item[] items, StrategyContainer container) {
        this.container = container;
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }
    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = container.getById(item.name);
            strategy.update(item);
        }
    }
}