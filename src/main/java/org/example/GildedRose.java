package org.example;

class GildedRose {
    private final StrategyBuilder strategyBuilder;
    Item[] items;

    public GildedRose(Item[] items, StrategyBuilder strategyBuilder) {
        this.strategyBuilder = strategyBuilder;
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = strategyBuilder.getStrategy(item.name);
            strategy.update(item);
        }
    }
}