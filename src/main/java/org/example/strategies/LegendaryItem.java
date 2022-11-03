package org.example.strategies;

import org.example.gildedrose.Item;

public class LegendaryItem extends GildedRoseItem {
    public LegendaryItem(Item item) {
        this.item = item;
    }

    public static final int LEGENDARY_QUALITY = 80;

    @Override
    protected boolean canIDecreaseSellIn() {
        return false;
    }

    protected void outOfDateQualityEvolution() {
        item.quality = LEGENDARY_QUALITY;
    }

    protected void evolveQuality() {
        item.quality = LEGENDARY_QUALITY;
    }
}
