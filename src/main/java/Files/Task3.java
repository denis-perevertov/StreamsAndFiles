package Files;

import java.io.*;

public class Task3 {

    private static final String FILE_PATH = "C:\\Users\\OneSmiLe\\IdeaProjects\\StreamsAndFiles\\" +
            "src\\main\\java\\Files\\task2.txt";

    public static void main(String[] args) {

        String line;
        String names = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            while((line = reader.readLine()) != null) {
                names = names + line + " ";
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(!names.isBlank()) {
            String[] namesList = names.split(" ");
            for(int i = 0; i < namesList.length; i++) {
                System.out.println(namesList[i]);
            }
        }

    }

}
