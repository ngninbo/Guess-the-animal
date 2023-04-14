import java.util.List;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        /* write your code here */
        List<String> types = List.of("Chinese", "American", "Russian");
        BurgerFactory factory = new BurgerStore();

        for (String type: types) {
            Burger burger = factory.orderBurger(type);
        }
    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are unable to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println(burger.getName() + " ready" + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger("Chinese");
            case "American":
                return new AmericanBurger("American");
            case "Russian":
                return new RussianBurger("Russian");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private final String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name + " Burger";
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting patty");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    /* write your code here */
    ChineseBurger(String name) {
        super(name);
    }
}

class AmericanBurger extends Burger {
    /* write your code here */
    AmericanBurger(String name) {
        super(name);
    }

}

class RussianBurger extends Burger {
    /* write your code here */
    RussianBurger(String name) {
        super(name);
    }

}