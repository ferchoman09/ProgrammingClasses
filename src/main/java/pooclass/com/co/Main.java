package pooclass.com.co;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList();
        Animal burro = new Perro("Burro", 13);
        animales.add(burro);
        Animal jupiter = new Gato("Jupiter", 5);
        animales.add(jupiter);
        Animal jonas = new Perro("Jonas", 14);
        animales.add(jonas);
        Animal luna = new Animal("Luna", 3);
        animales.add(luna);
        emitirSonidosTodosAnimales(animales);
    }

    private static void emitirSonidosTodosAnimales(List<Animal> animales) {
        for (Animal animal : animales) {
            System.out.println(animal.emitirSonido());
        }
    }
}
