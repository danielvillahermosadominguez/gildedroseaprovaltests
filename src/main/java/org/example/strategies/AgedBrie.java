package org.example.strategies;

import org.example.gildedrose.Item;

public class AgedBrie extends GildedRoseItem {

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canIDecreaseSellIn() {
        return true;
    }

    protected void outOfDateQualityEvolution() {
        if (isLessThanMaxQuality()) {
            item.quality++;
        }
    }

    protected void evolveQuality() {
        if (isLessThanMaxQuality()) {
            item.quality++;
        }
    }
}
