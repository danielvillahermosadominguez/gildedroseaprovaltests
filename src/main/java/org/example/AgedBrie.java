package org.example;

public class AgedBrie extends GeneralItem {

    protected void outOfDateQualityEvolution(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality++;
        }
    }

    protected void evolveQuality(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality++;
        }
    }
}
