package org.example;

public class AgedBrie {
    protected void execute(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if ((item.sellIn < 0) && (item.quality < 50)) {
            item.quality = item.quality + 1;
        }
    }
}
