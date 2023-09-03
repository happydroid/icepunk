package frostpunk.model;

import java.util.HashMap;
import java.util.Map;

public class ResourcesStore {
    private Map<ResourceType, LightInteger> resourceTypeToValue;

    public ResourcesStore() {
        this.resourceTypeToValue = new HashMap<>();
        this.resourceTypeToValue.put(ResourceType.IRON, new LightInteger(100));
        this.resourceTypeToValue.put(ResourceType.COAL, new LightInteger(100));
        this.resourceTypeToValue.put(ResourceType.WOOD, new LightInteger(100));
        this.resourceTypeToValue.put(ResourceType.STEAM_CORE, new LightInteger(1));
    }

    public boolean isEnoughResourcesForUpgrade(Map<ResourceType, LightInteger> resourceTypeToSpend) {
        for (ResourceType resourceType : resourceTypeToSpend.keySet()) {
            int existResource = resourceTypeToValue.get(resourceType).data;
            int wannaSpend = resourceTypeToSpend.get(resourceType).data;
            // if we can spend this resources, than
            if (existResource < wannaSpend) {
                return false;
            }
        }
        return true;
    }

    public boolean spendResource(Map<ResourceType, LightInteger> resourceTypeToSpend) {
        for (ResourceType resourceType : resourceTypeToSpend.keySet()) {
            int existResource = resourceTypeToValue.get(resourceType).data;
            int wannaSpend = resourceTypeToSpend.get(resourceType).data;

            // set new value by this method
            resourceTypeToValue.get(resourceType).data = existResource - wannaSpend;
        }
        return true;
    }
}
