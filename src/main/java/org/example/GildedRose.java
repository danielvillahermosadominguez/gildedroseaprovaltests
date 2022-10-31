package org.example;

class GildedRose {
    private final ItemStrategy strategy;
    Item[] items;

    public GildedRose(Item[] items, ItemStrategy strategy) {
        this.strategy = strategy;
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            strategy.execute(item);
        }
    }
}