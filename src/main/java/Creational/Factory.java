package Creational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Mobile {
    private int price;
    private int cpu;
    private int ram;

    abstract void show();
}
class Samsung extends Mobile {

    @Override
    public void show() {
        System.out.println("Samsung Mobile!!!");
    }
}

class Panasonic extends Mobile {
    @Override
    public void show() {
        System.out.println("Panasonic Mobile!!!");
    }
}

class MobileFactory {
    public static Mobile getInstance(String mobileName) {
        if (mobileName.equals("Samsung")) {
            return new Samsung();
        } else if (mobileName.equals("Panasonic")) {
            return new Panasonic();
        }
        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        Mobile samsungMobile = MobileFactory.getInstance("Samsung");
        samsungMobile.show();
        Mobile panansonicMobile = MobileFactory.getInstance("Panasonic");
        panansonicMobile.show();
    }
}
