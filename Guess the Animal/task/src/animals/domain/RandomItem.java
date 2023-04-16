package animals.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomItem<T> {

    private final T[] items;

    public RandomItem(T[] items) {
        this.items = items;
    }

    public T next() {
        int idx = ThreadLocalRandom.current().nextInt(0, items.length - 1);

        return items[idx];
    }
}
