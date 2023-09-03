package frostpunk.model;

import java.util.List;
import java.util.Objects;

public class World {

    private List<Player> playerList;

    private List<Town> townList;

    // обновить состояние всего мира
    public void update() {

    }

    // необходимо проверить, что этот игрок уже подключался
    public boolean addPlayer(Player player) {
        playerList.add(player);
        return true;
    }

    public boolean applyPlayerCommand(Player player, Command command) {
        for (Player player1 : playerList) {
            if (Objects.equals(player1.getName(), player.getName())) {
                player1.getTown().applyPlayerCommand(command);
            }
        }
        return true;
    }

    public List<Town> getTownList() {
        return townList;
    }

    public List<Player> getPlayer() {
        return playerList;
    }
}
