package org.example.strategies;

import org.example.gildedrose.Item;
import org.example.gildedrose.Update;

public class GildedRoseItemFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final String CONJURE = "Conjured Mana Cake";

    public Update of(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackStagePasses(item);
            case SULFURAS:
                return new LegendaryItem(item);
            case CONJURE:
                return new ConjuredItem(item);
            default:
                return new GeneralItem(item);
        }
    }
}
