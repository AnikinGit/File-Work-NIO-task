package app;

import app.service.FileReadService;
import app.service.FileWriteService;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) throws IOException {
        handleChoice(getChoice());
    }

    private static int getChoice() {
        scanner = new Scanner(System.in);

        try {
            System.out.println("""
                    Make a choice:
                    1) Create and write in file.
                    2) Read file.
                    3) Close the app.
                    """);

            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid value. Enter 1, 2 or 3.");
            return getChoice();
        }
    }

    private static void handleChoice(int choice) throws IOException {
        switch (choice) {
            case 1 -> getOutput(writeFile(getWriteData()));
            case 2 -> getOutput(readFile(getReadData()));
            case 3 -> {
                System.out.println("App closed");
                System.exit(0);
            }
            default -> System.out.println("Wrong value " + choice);
        }
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }

    private static String readFile(String fileName) throws IOException {
        return FileReadService.readBuffer(fileName);
    }

    private static String writeFile(String[] data) {
        return FileWriteService.writeBuffer(data[0], data[1]);
    }

    private static String getReadData() {
        scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        return scanner.nextLine();
    }

    private static String[] getWriteData() {
        scanner = new Scanner(System.in);
        System.out.println("Enter you content: ");
        String content = scanner.nextLine();
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        return new String[]{content, fileName};
    }
}
