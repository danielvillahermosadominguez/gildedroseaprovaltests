package org.example.strategies;

import org.example.gildedrose.Item;
import org.example.gildedrose.Update;

abstract class GildedRoseItem implements Update {
    static final int MAXIMUM_QUALITY = 50;
    protected Item item;

    public void update() {
        evolveQuality();
        decreaseDaysToSell();
        if (isOutOfDate()) {
            outOfDateQualityEvolution();
        }
    }

    protected abstract boolean canIDecreaseSellIn();

    protected void decreaseDaysToSell() {
        if (canIDecreaseSellIn()) {
            item.sellIn--;
        }
    }

    protected void outOfDateQualityEvolution() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected abstract void evolveQuality();

    protected boolean isOutOfDate() {
        return item.sellIn < 0;
    }

    protected boolean isLessThanMaxQuality() {
        return item.quality < GildedRoseItem.MAXIMUM_QUALITY;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
