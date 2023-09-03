package frostpunk.server;

import frostpunk.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private World world = new World();

    @GetMapping("/connect-to-town")
    public ResponseEntity<?> connectPlayerToTown(@RequestParam("playername") String playerName) {

        Town town = RandomUtil.randomElement(world.getTownList());
        Player player = new Player(playerName, town);
        world.addPlayer(player);

        return ResponseEntity.ok("Подключение завершенно");
    }

    @GetMapping("/get-world-state")
    public ResponseEntity<?> getWorldState(@RequestParam("playername") String playerName) {
        world.update();
        return ResponseEntity.ok("Всё стабильно");
    }

    @GetMapping("/apply-command")
    public ResponseEntity<?> applyCommand(@RequestParam("playername") String playerName,
                                          @RequestParam("command") Command command) {
        world.update();
        return ResponseEntity.ok("Будет выполненно");
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Подключение завершенно");
    }

    @GetMapping("/weather")
    public ResponseEntity<?> weather(@RequestParam("day") String day) {
        return ResponseEntity.ok("В этот день " + day + " будет хорошая погода");
    }

    @GetMapping("/time")
    public ResponseEntity<?> time() {
        return ResponseEntity.ok("Текущее время " + System.currentTimeMillis());
    }
}
