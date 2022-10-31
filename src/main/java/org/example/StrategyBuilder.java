package org.example;

public class StrategyBuilder {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public ItemStrategy getStrategy(String name) {
        switch (name) {
            case AGED_BRIE: return new AgedBrie();
            case BACKSTAGE_PASSES: return new TafKal80etcConcertStrategy();
            case SULFURAS: return new LegendaryStrategy();
        }
        return new GeneralItemStrategy();
    }
}
