package Different_themes.Serialization;

import java.io.*;


class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 3501985421273354783L;

    public int age;
    public transient String name, lastName;

    public Person(int age, String name, String lastName) {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName + " " + age;
    }
}

class Test {
    public static void main(String[] args) {
        File file = new File("file.txt");
        Person p1 = new Person(123, "Dima", "Petrov");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) { //file.createNewFile() ? file : file
            oos.writeObject(p1);
        } catch (IOException e) {
            System.out.println(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Person pRead = (Person) ois.readObject();
            System.out.println(pRead);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
