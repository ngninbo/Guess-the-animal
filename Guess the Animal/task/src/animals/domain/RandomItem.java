package animals.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomItem<T> {

    private final List<T> items;

    public RandomItem(List<T> items) {
        this.items = items;
    }

    public T next() {
        int idx = ThreadLocalRandom.current().nextInt(0, items.size() - 1);

        return items.get(idx);
    }
}
