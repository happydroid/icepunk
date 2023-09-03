package frostpunk.model;

import java.util.Objects;

// игроки уникальны по имени
public class Player {

    private String name;
    private Town town;

    public Player(String name, Town town) {
        this.name = name;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Town getTown() {
        return town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
