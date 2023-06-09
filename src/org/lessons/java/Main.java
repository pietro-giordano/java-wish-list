package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Benvenuto nella tua lista dei regali!");
        List<String> gifts = new ArrayList<>();

        File newFile = new File("./gifts.txt");
        if (newFile.exists()){
            System.out.println("Lista regali già presente");
            try {
                Scanner reader = new Scanner(newFile);
                while (reader.hasNextLine()) {
                    gifts.add(reader.nextLine());
                }
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Nessuna lista presente");
        }

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

        scanner.close();

        Collections.sort(gifts);
        System.out.println("Questa è la lista ordinata:");
        System.out.println(gifts);

        // bonus file
        if (!newFile.exists()) {
            try {
                if (newFile.createNewFile()) {
                    System.out.println("File creato");
                } else {
                    System.out.println("File non creato");
                }
            } catch (IOException e) {
                System.out.println("Errore in fase di creazione");
            }
        }

        try {
            FileWriter writer = new FileWriter("gifts.txt");
            for (String gift : gifts) {
                writer.write(gift.toString() + "\n");
            }
            writer.close();
            System.out.println("Scrittura su file avvenuta correttamente");
        } catch (IOException e) {
            System.out.println("Errore scrittura su file");
        }
    }
}
