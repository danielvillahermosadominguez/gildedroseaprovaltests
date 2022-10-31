package org.example;

public class GeneralItem implements UpdateStrategy {
    public static final int MAXIMUM_QUALITY = 50;
    public void update(Item item) {
        evolveQuality(item);
        decreaseDaysToSell(item);
        if(isOutOfDate(item)) {
            outOfDateQualityEvolution(item);
        }
    }

    protected void decreaseDaysToSell(Item item) {
        item.sellIn--;
    }

    protected boolean isLessThanMaxQuality(Item item) {
        return item.quality < MAXIMUM_QUALITY;
    }

    protected void outOfDateQualityEvolution(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected boolean isOutOfDate(Item item) {
        return item.sellIn < 0;
    }

    protected void evolveQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
