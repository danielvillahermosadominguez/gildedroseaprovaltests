package org.example;

public class TafKal80etcConcertStrategy extends GeneralItemStrategy {
    protected void accelerateQualityDegradation(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    protected void evolveQuality(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11 && isLessThanMaxQuality(item)) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && isLessThanMaxQuality(item)) {
                item.quality = item.quality + 1;
            }
        }
    }
}
