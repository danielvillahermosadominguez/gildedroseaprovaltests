package org.example;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.name.equals(AGED_BRIE)) {
                agedBriedCase(item);
            } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                tafkal80etcConcert(item);
            } else if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                sulfurasHandRagnaros(item);
            }
        }
    }

    private void sulfurasHandRagnaros(Item item) {
        if (item.quality > 0) {
            item.quality = decreaseQuality(item);
        }

        item.sellIn = decreaseSellIn(item);

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = decreaseQuality(item);
        }
    }
    private void agedBriedCase(Item item) {
        if (item.quality < 50) {
            item.quality = increaseQuality(item);
        }

        item.sellIn = decreaseSellIn(item);

        if ((item.sellIn < 0) && (item.quality < 50)) {
            item.quality = increaseQuality(item);
        }
    }

    private void tafkal80etcConcert(Item item) {
        if (item.quality < 50) {
            item.quality = increaseQuality(item);

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality = increaseQuality(item);
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = increaseQuality(item);
            }
        }

        item.sellIn = decreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }


    private int decreaseQuality(Item item) {
        return item.quality - 1;
    }

    private int increaseQuality(Item item) {
        return item.quality + 1;
    }

    private int decreaseSellIn(Item item) {
        return item.sellIn - 1;
    }

}