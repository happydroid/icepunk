package frostpunk.model;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    public static final Random RANDOM = new Random();

    public static <T> T randomElement(List<T> objectList) {
        return objectList.get(RANDOM.nextInt(objectList.size()));
    }
}
