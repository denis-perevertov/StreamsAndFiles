package Files;

import java.io.*;
import java.util.*;

public class Task4 {
    public static final String FILE_NAME = "C:\\Users\\OneSmiLe\\IdeaProjects\\StreamsAndFiles\\" +
            "src\\main\\java\\Files\\task4.txt";
}

class SerializeCats {

    public static void main(String[] args) {

        Cat cat1 = new Cat("TestName1", "TestBreed1", 100);
        Cat cat2 = new Cat("TestName2", "TestBreed2", 101);
        Cat cat3 = new Cat("TestName3", "TestBreed3", 104);

        List<Cat> catList = List.of(cat1, cat2, cat3);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Task4.FILE_NAME));
            oos.writeObject(catList);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

class DeserializeCats {

    //private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        List<Cat> catList;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Task4.FILE_NAME));
            catList = (List<Cat>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(catList != null) {
            for(Cat c : catList) {
                System.out.println(c);
            }
        }



    }
}

class Cat implements Serializable {

    private String name;
    private String breed;
    private int weight;

    public Cat(String name, String breed, int weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return weight == cat.weight && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, weight);
    }

    @Override
    public String toString() {
        return "SerializeCats{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }
}
