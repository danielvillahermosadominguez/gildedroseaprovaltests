package org.example.strategies;

import org.example.gildedrose.Item;

public class AgedBrie extends GeneralItem {

    protected void outOfDateQualityEvolution(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality++;
        }
    }

    protected void evolveQuality(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality++;
        }
    }

    @Override
    public String getId() {
        return "Aged Brie";
    }
}
