import java.util.ArrayList;
//import scanner
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // START THE LIST
        list list = new list();

        Scanner scanner = new Scanner(System.in);
        int x = 1;
        // start the menu Loop
        while (x == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("0.- exit");
            System.out.println("1.- add");
            System.out.println("2.- remove");
            System.out.println("3.- remove at index");
            System.out.println("4.- show list");
            System.out.println("5.- update");
            System.out.println("6.- search");

            System.out.println("----------------------------------------------------");

            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye");
                    x = 0;
                    break;
                case 1:
                    System.out.println("===========================");
                    System.out.println("what to add?");
                    String text = scanner.next();
                    list.add(text);
                    System.out.println("===========================");
                    break;
                case 2:
                    System.out.println("===========================");
                    list.remove_by_word();
                    System.out.println("===========================");
                    break;
                case 3:
                    list.remove_at_index();
                    break;
                case 4:
                    list.showList();
                    break;
                case 5:
                    list.update();
                    break;
                case 6:
                    list.search();
                    break;
            }

        }
        scanner.close();
    }

}

// Language: java
class list {

    private ArrayList<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(String text) {
        list.add(text);
        System.out.println(text + " added to list");
    }

    public void remove_by_word() {
        System.out.println("===========================");
        System.out.println("Items in List");
        System.out.println(" ");
        if (list.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i+1 + "- " + list.get(i));
            }
            System.out.println(" ");
            System.out.println("Enter the word of the item you want to remove");
            System.out.println(" ");
            String word = scanner.next();
            boolean error = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).contains(word)){
                    list.remove(i);
                    System.out.println("Item removed from list");
                    System.out.println("===========================");
                    error = false;
                    break;
                }
                else{
                    error = true;
                }
                if(error){
                    System.out.println("Item does not exist, try again.");
                }
            }
            
            
        }
    }

    public void update(){
        System.out.println("===========================");
        System.out.println("Items in List");
        System.out.println(" ");
        if (list.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + "- " + list.get(i));
            }
            System.out.println(" ");
            System.out.println("Enter the index of the item you want to update");
            System.out.println(" ");
            int index = scanner.nextInt();
            System.out.println(" ");
            System.out.println("Enter the new value of the item.");
            System.out.println(" ");
            String value = scanner.next();
            list.set(index, value);
            System.out.println("Item has been updated");
            System.out.println("===========================");
        }
    }
    public void search(){
        System.out.println("===========================");
        System.out.println("Items in List");
        System.out.println(" ");
        if (list.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + "- " + list.get(i));
            }
            System.out.println(" ");
            System.out.println("Enter the name of the item you are looking for");
            System.out.println(" ");
            String word = scanner.next();
            //error handling
            boolean error = false;
            for(int i=0;i<list.size();i++){
                if(list.get(i).contains(word)){
                    
                    System.out.println("the item's index is "+i);
                    System.out.println("===========================");
                     error = false;
                    break;
                }
                else{
                    error = true;
                }
            }
            if(error){
            System.out.println("Item does not exist, try again.");
        }
        }
    }

    public void remove_at_index() {
        System.out.println("===========================");
        System.out.println("Items in List");
        System.out.println(" ");
        if (list.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + "- " + list.get(i));
            }
            System.out.println(" ");
            System.out.println("Enter the index of the item you want to remove");
            System.out.println(" ");
            int index = scanner.nextInt();
            if(index<list.size()){
            list.remove(index);
            System.out.println("Item removed from list");
            System.out.println("===========================");
            }
            else{
                System.out.println("the index specified does not exist.");
            }
        }
    }

    public void showList() {
        System.out.println("===========================");
        System.out.println("Items in List");
        System.out.println(" ");
        if (list.size() == 0) {
            System.out.println("List is empty");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + "- " + list.get(i));
        }
        System.out.println(" ");
        System.out.println("===========================");
    }

    

}


