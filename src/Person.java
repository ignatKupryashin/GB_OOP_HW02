import java.util.ArrayList;
import java.util.HashSet;

public class Person {

    private int id;
    private String gender = "male";
    private String name = "";
    private String surname = "";
    private int mother = -1;
    private int father = -1;
    private HashSet<Integer> children = new HashSet<>();


    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.children = new HashSet<>();
        this.gender = "male";
    }

    public Person(int id, String name, String surname, int mother, int father) {
        this.id = id;
        this.setName(name);
        this.setSurname(surname);
        this.children = new HashSet<>();
        this.gender = "male";
    }

    public Person(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        if (gender == "male" || gender == "female") {
            this.gender = gender;
        } else {
            System.out.println("Такого гендера не существует. Программа бинарна");
        }
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }

    public void setFather(int father) {
        this.father = father;
    }


    public void addChild(int child) {
        children.add(child);
    }


    public String getName() {
        if (name != "") {
            return name;
        }
        else {
            return "Имя неизвенстно";
        }
    }

    public String getSurname() {
        if (surname != "") {
            return surname;
        }
        else {
            return "Фамилия неизвестна";
        }
    }

    public int getMother() {
        return mother;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int getFather() {
        return father;
    }

    public HashSet<Integer> getChildren() {
        return children;
    }

    public ArrayList<Integer> getParents(){
        ArrayList<Integer> parents = new ArrayList<>(2);
        parents.add(this.getMother());
        parents.add(this.getFather());
        return parents;
    }


}
//
//
//


//
//
//    public void printRelatives(ArrayList<Person> relatives) {
//        for (Person relative:relatives
//             ) {
//            relative.printName();
//        }
//    }
//
////
//    @Override
//    public void printBrothers() {
//        printRelatives(this.getBrothers());
//    }
//
//    @Override
//    public void printSisters() {
//        printRelatives(this.getSisters());
//    }
//
//    @Override
//    public void printBrothersAndSisters() {
//        printRelatives(this.getBrothersAndSisters());
//    }
//
//    @Override
//    public void printParents() {
//        printRelatives(this.getParents());
//    }
//
//    @Override
//    public void printName() {
//
//    }
//}
