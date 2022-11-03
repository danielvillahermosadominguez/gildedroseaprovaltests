package org.example.strategies;

import org.example.gildedrose.Item;

public class BackStagePasses extends GildedRoseItem {

    public BackStagePasses(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canIDecreaseSellIn() {
        return true;
    }

    protected void outOfDateQualityEvolution() {
        item.quality = 0;
    }

    protected void evolveQuality() {
        if (isLessThanMaxQuality()) {
            item.quality++;
        }
        if (isLessThanMaxQuality() && isLessThanDaysToShell(11)) {
            item.quality++;
        }
        if (isLessThanMaxQuality() && isLessThanDaysToShell(6)) {
            item.quality++;
        }
    }

    private boolean isLessThanDaysToShell(int lessThanDays) {
        return item.sellIn < lessThanDays;
    }

}
