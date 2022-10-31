package org.example;

public class ConjuredItem extends GeneralItem {
     protected void evolveQuality(Item item) {
        if (item.quality > 1) {
            item.quality = item.quality - 2;
        } else if (item.quality > 0){
            item.quality--;
        }
    }
}
