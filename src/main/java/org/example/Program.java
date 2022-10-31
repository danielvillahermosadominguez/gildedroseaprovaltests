package org.example;


import org.example.container.StrategyContainer;
import org.example.gildedrose.GildedRose;
import org.example.gildedrose.Item;
import org.example.gildedrose.UpdateStrategy;
import org.example.strategies.*;

import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String... args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20), 
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), 
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };
		GeneralItem defaultItem = new GeneralItem();
		List<UpdateStrategy> strategies = Arrays.asList(
				defaultItem,
				new AgedBrie(),
				new BackStagePasses(),
				new ConjuredItem(),
				new LegendaryItem());
		StrategyContainer strategyBuilder =  new StrategyContainer(strategies,defaultItem.getId());
		GildedRose app = new GildedRose(items,strategyBuilder);

		for (int i = 0; i < 31; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (int j = 0; j < items.length; j++) {
				System.out.println(items[j]);
			}
			System.out.println("");
			app.updateQuality();
		}
	}
}
