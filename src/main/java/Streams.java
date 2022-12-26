import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Streams {

    public static void main(String[] args) {

        List<User> usersList = new ArrayList<>();

        usersList.add(new User("Anna", 10));
        usersList.add(new User("Oleg", 42));
        usersList.add(new User("Anton", 15));
        usersList.add(new User("Dima", 18));
        usersList.add(new User("Evgen", 51));
        usersList.add(new User("Denis", 25));
        usersList.add(new User("Andrey", 68));
        usersList.add(new User("Nikita", 10));
        usersList.add(new User("Maria", 65));
        usersList.add(new User("Nikolai", 70));

        usersList.stream()
                .sorted()
                .filter(u -> u.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .toList()
                .forEach(System.out::println);



    }

}

class User implements Comparable<User> {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}