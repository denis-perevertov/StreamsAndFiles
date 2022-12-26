package Files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final String FILE_NAME = "C:\\Users\\OneSmiLe\\IdeaProjects\\StreamsAndFiles\\src\\main\\folder1";

    public static void main(String[] args) {

        File dir = new File(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input text: ");
        String textToFind = scanner.nextLine();
        List<File> matchingNameFiles = checkFiles(dir, textToFind.toLowerCase());

        for(File file : matchingNameFiles) {
            System.out.println(file);
        }


    }

    public static List<File> checkFiles(File dir, String textToFind) {
        File[] files = dir.listFiles();
        List<File> matchingNameFiles = new ArrayList<>();

        if(files != null && files.length > 0) {
            for(File file : files) {
                if(file.isDirectory()){
                    List<File> tempList = checkFiles(file, textToFind);
                    if(tempList.size() != 0) matchingNameFiles.addAll(tempList);
                } else if(file.getName().toLowerCase().contains(textToFind)) {
                    matchingNameFiles.add(file);
                }
            }
        }

        return matchingNameFiles;
    }

}
