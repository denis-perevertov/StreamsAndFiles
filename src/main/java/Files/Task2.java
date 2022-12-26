package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    private static final String FILE_PATH = "C:\\Users\\OneSmiLe\\IdeaProjects\\StreamsAndFiles\\" +
            "src\\main\\java\\Files\\task2.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input names: ");

        String[] namesList = scanner.nextLine().split(" ");

        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            for(int i = 0; i < namesList.length; i++) {
                fileWriter.write(namesList[i] + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
