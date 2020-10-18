package Task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    HashMap<String, TouristPlace> map = new HashMap<>();

    public void show() throws Exception {

        showPlacesFromFile();

        do {

            int choice = showMenuAndGetChoice();
            switch (choice) {
                case 1:
                    addAPlace();
                    break;

                case 2:
                    removeAPlace();
                    break;

                case 3:
                    rateAPlace();
                    break;

                case 4:
                    findAPlace();
                    break;

                default:
                    System.out.println("Invalid Choice !!");
                    break;
            }

            showPlaces();
            if (wantToExit()) {
                saveToFile();
                break;
            }

        } while (true);
    }

    private void saveToFile() throws Exception {
        String path = "C:\\Users\\mohit\\JavaPracticeProblems\\src\\Task3\\data.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(map);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private void showPlacesFromFile() throws Exception {
        String path = "C:\\Users\\mohit\\JavaPracticeProblems\\src\\Task3\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        HashMap<String, TouristPlace> hashMap = (HashMap<String, TouristPlace>) objectInputStream.readObject();
        System.out.println(hashMap.values().toString());
    }

    private void showPlaces() {
        System.out.println(map.values().toString());
    }

    private boolean wantToExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to continue (y / n) ? ");
        String input = scanner.next();
        return input.equals("n");
    }

    private void addAPlace() {
       TouristPlace newPlace = TouristPlace.newFromUserInput();
       map.put(newPlace.name, newPlace);
        System.out.println("Place successfully added");
    }

    private void removeAPlace() {
        System.out.println("Enter place name : ");
        Scanner scanner = new Scanner(System.in);
        String placeName = scanner.next();
        if(map.containsKey(placeName)) {
            map.remove(placeName);
            System.out.println("Removed Successfully");
        } else {
            System.out.println("Place not found");
        }
    }

    private void rateAPlace() {
        System.out.println("Enter place name : ");
        Scanner scanner = new Scanner(System.in);
        String placeName = scanner.next();
        if(map.containsKey(placeName)) {
            System.out.println("Enter Rating range from 1 to 5 : ");
            int rating = scanner.nextInt();
            if(rating >= 1 && rating <= 5) {
                TouristPlace findPlace = map.get(placeName);
                findPlace.rate(rating);
                System.out.println("Rate Successfully");
            }
        } else {
            System.out.println("Place not found");
        }
    }

    private void findAPlace() {
        System.out.println("Enter place name : ");
        Scanner scanner = new Scanner(System.in);
        String placeName = scanner.next();
        if(map.containsKey(placeName)) {
            System.out.println("Place Found");
            TouristPlace findPlace = map.get(placeName);
            System.out.println("Place : " + findPlace);
        } else {
            System.out.println("Place not found");
        }
    }

    private int showMenuAndGetChoice() {
        System.out.println("\n --------MENU---------");
        System.out.println("1. Add a place");
        System.out.println("2. Remove a place");
        System.out.println("3. Rate a place");
        System.out.println("4. Find a place");
        System.out.println();
        System.out.print("Enter your choice : ");
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//        return choice;
        return new Scanner(System.in).nextInt();
    }

}
