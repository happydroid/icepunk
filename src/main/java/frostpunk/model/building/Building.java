package frostpunk.model.building;

import frostpunk.model.LightInteger;
import frostpunk.model.ResourceType;
import frostpunk.model.ResourcesStore;

import java.util.Map;

public abstract class Building {

    // from 1 to 5
    private int level;

    public Building(int level) {
        this.level = level;
    }

    abstract public double createResourcesByTime(double time);

    public boolean tryToUpdate(ResourcesStore resourcesStore) {
        // max level of town is 5
        if (resourcesStore.isEnoughResourcesForUpgrade(resourcesForUpgrade()) && (level < 5)) {
            makeUpgrade();
            return true;
        }
        return false;
    }

    abstract protected Map<ResourceType, LightInteger> resourcesForUpgrade();

    private void makeUpgrade() {
        level++;
    }

    protected void makeDowngrade() {

    }

    public int getLevel() {
        return level;
    }

}
