package org.example;

public class BackStagePasses extends GeneralItem {
    protected void outOfDateQualityEvolution(Item item) {
        item.quality = 0;
    }

    protected void evolveQuality(Item item) {
        if (isLessThanMaxQuality(item)) {
            item.quality++;
        }
        if (isLessThanMaxQuality(item) && isLessThanDaysToShell(item.sellIn, 11)) {
            item.quality++;
        }
        if (isLessThanMaxQuality(item) && isLessThanDaysToShell(item.sellIn, 6)) {
            item.quality++;
        }
    }

    private boolean isLessThanDaysToShell(int days, int lessThanDays) {
        return days < lessThanDays;
    }

}
