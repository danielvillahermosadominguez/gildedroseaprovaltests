package org.example;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;
import org.example.strategies.GildedRoseItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UseReporter(DiffReporter.class)
public class GildedRoseShould {

    private GildedRoseItemFactory factory;
    private GildedRose gildedRose;

    @BeforeEach
    void beforeEach() {
        if (this.factory == null) {
            this.factory = new GildedRoseItemFactory();
        }
        this.gildedRose = new GildedRose(factory);
    }

    @Test
    void updateQuality_with_one_item() {
        gildedRose.addItem(new Item("foo", 0, 0));

        gildedRose.updateQuality();

        Approvals.verify(gildedRose.get(0).toString());
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
        gildedRose.clear();
        Item item = new Item(name, sellIn, quality);
        gildedRose.addItem(item);

        gildedRose.updateQuality();

        String response = gildedRose.get(0).toString();
        return response;
    }

    @Test
    public void decrease_quality_2_with_conjured_items() {
        gildedRose.addItem(new Item("Conjured Mana Cake", 10, 10));

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.size());
        assertEquals("Conjured Mana Cake, 9, 8", gildedRose.get(0).toString());
    }

    @Test
    public void maintain_quality_zero_as_minimum_with_conjured_items() {
        gildedRose.addItem(new Item("Conjured Mana Cake", 10, 1));
        gildedRose.updateQuality();

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.size());
        assertEquals("Conjured Mana Cake, 8, 0", gildedRose.get(0).toString());
    }
}
