package org.example.container;

import org.example.gildedrose.UpdateStrategy;

import java.util.HashMap;
import java.util.List;

public class StrategyContainer {
    private final String defaultId;
    HashMap<String, UpdateStrategy> strategies;

    public StrategyContainer(List<UpdateStrategy> strategies, String defaultId) {
        this.strategies = new HashMap<>();
        for (UpdateStrategy strategy : strategies) {
            this.strategies.put(strategy.getId(), strategy);
        }
        this.defaultId = defaultId;
    }

    public UpdateStrategy getById(String id) {
        if (!strategies.containsKey(id)) {
            return strategies.get(defaultId);
        }
        return strategies.get(id);
    }
}
