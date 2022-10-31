package org.example;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@UseReporter(DiffReporter.class)
public class GildedRoseShould {
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void updateQuality_with_one_item() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);

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
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        String response = gildedRose.items[0].toString();
        return response;
    }
}
