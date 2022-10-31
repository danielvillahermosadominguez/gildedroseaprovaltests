package org.example;

public class AgedBrie extends GeneralItemStrategy {

    protected void accelerateQualityDegradation(Item item) {
        if ((item.sellIn < 0) && (isLessThanMaxQuality(item))) {
            item.quality = item.quality + 1;
        }
    }

    protected void evolveQuality(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality = item.quality + 1;
        }
    }
}
