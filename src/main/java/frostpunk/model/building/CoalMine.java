package frostpunk.model.building;

import frostpunk.model.LightInteger;
import frostpunk.model.ResourceType;

import java.util.HashMap;
import java.util.Map;

public class CoalMine extends Building {

    public CoalMine(int level) {
        super(level);
    }

    @Override
    public double createResourcesByTime(double time) {
        return 3 * getLevel() * time;
    }

    @Override
    protected Map<ResourceType, LightInteger> resourcesForUpgrade() {
        Map<ResourceType, LightInteger> resourceTypeLightIntegerMap = new HashMap<>();

        resourceTypeLightIntegerMap.put(ResourceType.WOOD, new LightInteger(getLevel() * getLevel() * 60));
        resourceTypeLightIntegerMap.put(ResourceType.IRON, new LightInteger(getLevel() * getLevel() * 80));

        // для апгрейда с 4 на 5 уровень требуется супер уникальный ресурс
        if (getLevel() == 4) {
            resourceTypeLightIntegerMap.put(ResourceType.STEAM_CORE, new LightInteger(1));
        }
        return resourceTypeLightIntegerMap;
    }

}
