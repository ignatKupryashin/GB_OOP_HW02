public class Main {
    public static void main(String[] args){
        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(1,"Петр","Петров", 4,3);
        familyTree.addPerson(2,"Зинаида","Петрова", 4,3);
        familyTree.addPerson(3,"Василий","Петров", 5,6);
        familyTree.addPerson(4,"Анастасия","Петрова", 7,8);
        UI ui = new UI(familyTree);
        ui.run();

    }
}
