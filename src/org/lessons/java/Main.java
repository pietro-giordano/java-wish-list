package org.lessons.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Benvenuto nella tua lista dei regali!");
        List<String> gifts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        do {
            System.out.println("Inserisci il nome del regalo che vuoi inserire in lista o scrivi 'esci' per chiudere:");
            String gift = scanner.nextLine();
            switch (gift) {
                case "esci" -> exit = true;
                default -> {
                    gifts.add(gift);
                    System.out.println("La lista regali è composta da " + gifts.size() + " elementi.");

                    boolean choice = false;
                    do {
                        System.out.println("Vuoi continuare ad inserire regali? ('si' per continuare e 'no' per uscire)");
                        String response = scanner.nextLine();
                        switch (response) {
                            case "si" -> choice = true;
                            case "no" -> {
                                choice = true;
                                exit = true;
                            }
                            default -> System.out.println("Non hai risposto correttamente alla domanda");
                        }
                    } while (!choice);
                }
            }
        } while (!exit);

        Collections.sort(gifts);
        System.out.println("Questa è la lista ordinata:");
        System.out.println(gifts);
    }
}
