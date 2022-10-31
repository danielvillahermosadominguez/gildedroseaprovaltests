package org.example;

class GildedRose {
    private final StrategyBuilder strategyBuilder;
    Item[] items;

    public GildedRose(Item[] items, StrategyBuilder strategyBuilder) {
        this.strategyBuilder = strategyBuilder;
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            ItemStrategy strategy = strategyBuilder.getStrategy(item.name);
            if (strategy != null) {
                strategy.execute(item);
            }
        }
    }
}