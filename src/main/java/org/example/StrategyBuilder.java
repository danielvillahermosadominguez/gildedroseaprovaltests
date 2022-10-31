package org.example;

public class StrategyBuilder {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public ItemStrategy getStrategy(String name) {
        if (name.equals(AGED_BRIE)) {
            return new AgedBrie();
        } else if (name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            return new TafKal80etcConcertStrategy();
        } else if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return new SulfurasHandRagnarosStrategy();
        }
        return null;
    }
}
