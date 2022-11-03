package org.example.strategies;

import org.example.gildedrose.Item;

public class ConjuredItem extends GildedRoseItem {
    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canIDecreaseSellIn() {
        return true;
    }

    protected void evolveQuality() {
        if (item.quality > 1) {
            item.quality = item.quality - 2;
        } else if (item.quality > 0) {
            item.quality--;
        }
    }

}
