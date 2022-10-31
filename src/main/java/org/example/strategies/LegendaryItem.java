package org.example.strategies;

import org.example.gildedrose.Item;

public class LegendaryItem extends GeneralItem {

    public static final int LEGENDARY_QUALITY = 80;

    protected void outOfDateQualityEvolution(Item item) {
        item.quality = LEGENDARY_QUALITY;
    }

    protected void evolveQuality(Item item) {
        item.quality = LEGENDARY_QUALITY;
    }

    protected void decreaseDaysToSell(Item item) {
        //we don't decrease the days. This item is always the same
    }

    @Override
    public String getId() {
        return "Sulfuras, Hand of Ragnaros";
    }
}
