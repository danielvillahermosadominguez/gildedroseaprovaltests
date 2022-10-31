package org.example.strategies;

import org.example.gildedrose.Item;

public class ConjuredItem extends GeneralItem {
     protected void evolveQuality(Item item) {
        if (item.quality > 1) {
            item.quality = item.quality - 2;
        } else if (item.quality > 0){
            item.quality--;
        }
    }

    @Override
    public String getId() {
        return "Conjured Mana Cake";
    }
}
