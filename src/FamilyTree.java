import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FamilyTree{

    HashMap<Integer, Person> treeMap;
    private int counter = 1;

    FamilyTree() {
        treeMap = new HashMap();
    }



    public void addPerson() {
        int id = counter++;
        Person newPerson = new Person(id);

    }

    public void addPerson(int id) {
        if (!this.containsPerson(id)) {
            Person newPerson = new Person(id);
            this.refreshCounter(id);
            treeMap.put(id,newPerson);
        }
    }

    public void addPerson(String name, String surname, int mother, int father) {
        int id = counter++;
        createIfAbsent(mother);
        createIfAbsent(father);
        Person newPerson = new Person(id, name, surname, mother, father);
        this.treeMap.put(id, newPerson);
    }

    public void addPerson(int id, String name, String surname, int mother, int father) {
        createIfAbsent(id);
        this.getPerson(id).setName(name);
        this.getPerson(id).setSurname(surname);
        createIfAbsent(mother);
        createIfAbsent(father);
        this.getPerson(id).setFather(father);
        this.getPerson(id).setMother(mother);
        getPerson(father).addChild(id);
        getPerson(mother).addChild(id);

    }

    public HashMap<Integer, Person> getFullTree() {
        return treeMap;
    }


//    public void printPerson(Person person) {
////        System.out.println(String.format("Id: %d", person.getId()));
////        System.out.println(String.format("%s %s", person.getName(), person.getSurname()));
////        System.out.println(String.format("Отец: %s", familyTree.getRelativeName(person.getFather())));
////        System.out.println(String.format("Мать: %s", familyTree.getRelativeName(person.getMother())));
//    }





    public String getRelativeName(int id) {
        if (id != -1 && this.containsPerson(id)) {
            Person person = treeMap.get(id);
            return String.format("%s %s", person.getName(), person.getSurname());
        }
        else {
            return "Неизвестно";
        }
    }


    private void createIfAbsent(int person) {
        if (!containsPerson(person)) {
            addPerson(person);}
    }

    private void refreshCounter(int id) {
        if (counter < id) {
                counter = ++id;
            };
    }

    public boolean containsPerson(int id) {
        if (treeMap.containsKey(id)){
            return true;
        }
        else {
            return false;
        }
    }

    public Person getPerson(int id) {
        if (this.containsPerson(id)) {
            return treeMap.get(id);
        }
        else {
        return null;
        }
    }

    public boolean checkParent(int parent) {
        if (parent == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Person getMother(int id) {
        int mother = treeMap.get(id).getMother();
        if (checkParent(mother)) {
            return treeMap.get(mother);
        }
        else {
            return null;
        }
    }

    public Person getFather(int id) {
        int father = treeMap.get(id).getFather();
        if (checkParent(father)) {
            return treeMap.get(father);
        }
        else {
            return null;
        }
    }

    public ArrayList<Integer> getParents(int questionPerson) {
        ArrayList<Integer> parents = new ArrayList<>(2);
        parents.add(this.getPerson(questionPerson).getMother());
        return parents;
    }

    public HashSet<Person> getChildren(int parent) {
      HashSet<Person> children = new HashSet<>();
        for (int child:treeMap.get(parent).getChildren()
             ) {
            children.add(getPerson(child));
        }
        return children;
    };

    public HashSet<Person> getBrothersAndSisters(int person) {
        HashSet broAndSys = new HashSet();
        for (int parent:this.getParents(person)
             ) {
            broAndSys.addAll(getChildren(parent));
        }
        broAndSys.remove(getPerson(person));
        return broAndSys;
    }




    //    private ArrayList<Person> getBrothersOrSisters(String gender) {
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person relative:this.getBrothersAndSisters()
//             ) {
//            if (relative.getGender() == gender) {
//                result.add(relative);
//            }
//        }
//        return result;
//    }
//
//    public ArrayList<Person> getBrothers() {
//        return getBrothersOrSisters("male");
//    }
//
//    public ArrayList<Person> getSisters() {
//        return getBrothersOrSisters("female");
//    }


//
//    public ArrayList<Person> getBrothersAndSisters(int id){
//        ArrayList<Person> result = new ArrayList<>();
//        for (int parent:getPerson(id).getParents()
//        ) {
//            for (Person child:parent.getChildren()
//            ) {
//                if (child.getId() != this.getId()) {
//                    result.add(child);
//                }
//            }
//        }
//        return result;
//    }
//



}
