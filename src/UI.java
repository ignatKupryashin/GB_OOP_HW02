import java.util.Scanner;

public class UI {

    String command;
    Scanner scan = new Scanner(System.in);
    FamilyTree familyTree;


    UI(FamilyTree inputTree) {
        familyTree = inputTree;
    }


    public void run() {
        boolean flag = true;
        while (flag) {
            printMenu();
            command = scan.nextLine();
            switch (command) {
                case("1"):{
                    printAllPersons();
                    break;
                }
                case("2"):{
                    printResearch();
                    break;
                }
                case("9"):{
                    flag = false;
                    System.out.println("До новых встреч");
//                    Тут можно прописать сохранение дерева в БД
                    break;
                }
            }
        }
    }


    private void printMenu() {
        System.out.println("");
        System.out.println("Меню");
        System.out.println("1.Вывести весь список людей в дереве");
        System.out.println("2.Узнать информацию о конкретном челоеке");
        System.out.println("9.Выход");
        System.out.println("Введите команду:");
    }



    private String printPersonOneline(Person person) {
        return String.format("%d - %s %s", person.getId(), person.getName(), person.getSurname());
    }



    private void printAllPersons(){

        for (Person person: familyTree.getFullTree().values()
        ) {
            System.out.println(printPersonOneline(person));
            System.out.println("");
        }
    }



    private void printResearch() {
        System.out.println("Введите ID человека, по которому хотите получить информацию: ");
        int personChoise = Integer.valueOf(scan.nextLine());
        if (familyTree.containsPerson(personChoise)) {
            Person currentPerson = familyTree.getPerson(personChoise);
            System.out.println(String.format("ID:%d\n" +
                            "Фамилия: %s\n" +
                            "Имя: %s"
                    , personChoise, currentPerson.getSurname(), currentPerson.getName()));
            System.out.print("Мать: ");
            System.out.println(familyTree.getRelativeName(currentPerson.getMother()));
            System.out.print("Отец: ");
            System.out.println(familyTree.getRelativeName(currentPerson.getFather()));
            System.out.println("Дети: ");
            for (Person child:familyTree.getChildren(personChoise)
                 ) {
                System.out.println(printPersonOneline(child));
            }
            System.out.println("Братья и сёстры: ");
            for (Person broOrSys:familyTree.getBrothersAndSisters(personChoise)
            ) {
                System.out.println(printPersonOneline(broOrSys));
            }
//            System.out.print("Братья и сёстры: --- ");
//            for (:
//                 ) {
//
//            }
        }
//            System.out.println("Дети: ");
//            if (currentPerson.getChildren().size() > 0) {
//                for (String child:currentPerson.getChildren()){
//                    printPersonOneline(familyTree.getPerson(child));
//                }
//            }
//            else {
//                System.out.print("Нет");
//            }
        }

    }

