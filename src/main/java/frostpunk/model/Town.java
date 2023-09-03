package frostpunk.model;

import frostpunk.model.building.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Town {

    private static final List<String> townNames = Arrays.asList(
            "Зимнегорск", "Зимовщик", "Дубоград", "Ледяная Гавань", "Снеголесье", "Белый Город", "Зимний Бриз",
            "Добровольск", "Северное Убежище", "Холодное Ущелье", "Малая полынья", "Криосити", "Глазгород", "Острокирск",
            "Снежинка", "Ледяная Долина", "Морозолесье", "Боброгорск", "Зимний Свет"
    );

    private String name;

    private List<People> peopleList;

    private List<Building> buildings;

    private WoodMine woodMine;
    private IronMine ironMine;
    private CoalMine coalMine;

    private ResourcesStore resourcesStore;

    // use random for all
    public Town() {
        Random random = RandomUtil.RANDOM;
        // выбираем имя города случайным образом, имена могут дублироваться, ничего страшного
        this.name = townNames.get(random.nextInt(townNames.size()));

        this.peopleList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(100); i++) {
            this.peopleList.add(new People());
        }

        this.buildings = new ArrayList<>();
        for (int i = 0; i < random.nextInt(5) + 5; i++) {
            this.buildings.add(new Home(random.nextInt(3)));
        }

        woodMine = new WoodMine(random.nextInt(3));
        this.buildings.add(woodMine);

        ironMine = new IronMine(random.nextInt(3));
        this.buildings.add(ironMine);

        coalMine = new CoalMine(random.nextInt(3));
        this.buildings.add(coalMine);

        this.resourcesStore = new ResourcesStore();
    }

    public boolean applyPlayerCommand(Command command) {
        switch (command) {
            case BUILD_HOME: {
                break;
            }
            case UPGRADE_HOME: {

                break;
            }
            case UPGRADE_WOOD_MINE: {
                woodMine.tryToUpdate(resourcesStore);
                break;
            }
            case UPGRADE_IRON_MINE: {
                ironMine.tryToUpdate(resourcesStore);
                break;
            }
            case UPGRADE_COAL_MINE: {
                coalMine.tryToUpdate(resourcesStore);
                break;
            }
            case ATTACK_OTHER_TOWN: {
                break;
            }
            case ABANDON_TOWN: {
                System.exit(228);
            }
        }
        return true;
    }

}
