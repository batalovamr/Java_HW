package hw_6;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Laptop> set = new HashSet<>();
        set.add(new Laptop("Notebook1", "Asus", "Windows", 256, 8, "i3", 50000));
        set.add(new Laptop("Notebook2", "Asus", "Linux", 512, 16, "i5", 50000));
        set.add(new Laptop("Notebook3", "Asus", "DOS", 256, 8, "i5", 45000));
        set.add(new Laptop("Notebook4", "Lenovo", "Linux", 1024, 16, "i3", 70000));
        set.add(new Laptop("Notebook5", "Lenovo", "Windows", 256, 8, "i7", 170000));
        set.add(new Laptop("Notebook6", "HP", "DOS", 2048, 32, "i7", 150000));
        set.add(new Laptop("Notebook7", "HP", "Windows", 128, 4, "i3", 30000));
        set.add(new Laptop("Notebook8", "MSI", "DOS", 1024, 16, "i5", 50000));
        set.add(new Laptop("Notebook9", "MSI", "Windows", 256, 8, "i7", 120000));
        
        FilterLaptops operation = new FilterLaptops(set);
        operation.start();

    }
}
