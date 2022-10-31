package org.example;

public class ItemStrategy {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    protected final AgedBrie ageBrie;
    protected final SulfurasHandRagnaros sulfurasHandRagnarosStrategy;
    protected final TafKal80etcConcert tafKal80etcConcert;

    public ItemStrategy(AgedBrie agedBrie, SulfurasHandRagnaros sulfurasHandRagnaros, TafKal80etcConcert tafKal80etcConcert) {
        this.ageBrie = agedBrie;
        this.sulfurasHandRagnarosStrategy = sulfurasHandRagnaros;
        this.tafKal80etcConcert = tafKal80etcConcert;
    }

    protected void execute(Item item) {
        if (item.name.equals(ItemStrategy.AGED_BRIE)) {
            ageBrie.execute(item);
        } else if (item.name.equals(ItemStrategy.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            tafKal80etcConcert.execute(item);
        } else if (!item.name.equals(ItemStrategy.SULFURAS_HAND_OF_RAGNAROS)) {
            sulfurasHandRagnarosStrategy.execute(item);
        }
    }
}
