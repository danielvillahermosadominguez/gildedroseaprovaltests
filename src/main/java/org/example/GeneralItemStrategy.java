package org.example;

public class GeneralItemStrategy implements ItemStrategy {
    public static final int MAXIMUM_QUALITY = 50;
    public void execute(Item item) {
        evolveQuality(item);

        decreaseDaysToSell(item);

        accelerateQualityDegradation(item);
    }

    protected void decreaseDaysToSell(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected boolean isLessThanMaxQuality(Item item) {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected void accelerateQualityDegradation(Item item) {
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void evolveQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
