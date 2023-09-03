package frostpunk.model.building;

import frostpunk.model.LightInteger;
import frostpunk.model.ResourceType;

import java.util.HashMap;
import java.util.Map;

public class Home extends Building {

    public Home(int level) {
        super(level);
    }

    @Override
    public double createResourcesByTime(double time) {
        return getLevel();
    }

    @Override
    protected Map<ResourceType, LightInteger> resourcesForUpgrade() {
        Map<ResourceType, LightInteger> resourceTypeLightIntegerMap = new HashMap<>();

        resourceTypeLightIntegerMap.put(ResourceType.WOOD, new LightInteger(getLevel() * getLevel() * 50));
        resourceTypeLightIntegerMap.put(ResourceType.IRON, new LightInteger(getLevel() * getLevel() * 10));
        return resourceTypeLightIntegerMap;
    }

}
