package org.example.strategies;

import org.example.gildedrose.Item;

public class GeneralItem extends GildedRoseItem {
    public GeneralItem(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canIDecreaseSellIn() {
        return true;
    }

    protected void evolveQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
