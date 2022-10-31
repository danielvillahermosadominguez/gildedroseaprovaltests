package org.example;

public class StrategyBuilder {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final String CONJURE = "Conjured Mana Cake";

    public UpdateStrategy getStrategy(String name) {
        switch (name) {
            case AGED_BRIE: return new AgedBrie();
            case BACKSTAGE_PASSES: return new BackStagePasses();
            case SULFURAS: return new LegendaryItem();
            case CONJURE: return new ConjuredItem();
            default: return new GeneralItem();
        }
    }
}
