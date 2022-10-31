package org.example;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UseReporter(DiffReporter.class)
public class GildedRoseShould {
    @Test
    void updateQuality_with_one_item() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        StrategyBuilder strategy =  new StrategyBuilder();
        GildedRose gildedRose = new GildedRose(items, strategy);

        gildedRose.updateQuality();

        Approvals.verify(gildedRose.items[0].toString());
    }

    @Test
    void updateQuality_with_several_items_and_several_combinations() {
        Integer[] sellInList = {-10,0, 6, 10, 11};
        Integer[] qualityList = {0, 1, 49, 50};
        String[] nameList = {"foo",
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros"};

        CombinationApprovals.verifyAllCombinations(this::updateQuality,
                nameList,
                sellInList,
                qualityList);
    }

    private String updateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        StrategyBuilder strategy = new StrategyBuilder();
        GildedRose gildedRose = new GildedRose(items, strategy);

        gildedRose.updateQuality();

        String response = gildedRose.items[0].toString();
        return response;
    }

    @Test
    public void decrease_quality_2_with_conjured_items() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 10)};
        StrategyBuilder strategy = new StrategyBuilder();
        GildedRose gildedRose = new GildedRose(items, strategy);

        gildedRose.updateQuality();

        assertEquals(1, items.length);
        assertEquals(9, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    public void maintain_quality_zero_as_minimum_with_conjured_items() {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 1)};
        StrategyBuilder strategy = new StrategyBuilder();
        GildedRose gildedRose = new GildedRose(items, strategy);
        gildedRose.updateQuality();

        gildedRose.updateQuality();

        assertEquals(1, items.length);
        assertEquals(8, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
