import java.util.ArrayList;
import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        ArrayList<String> words = new ArrayList<>();

        while(true)
        {
            System.out.print("input words : ");
            String word = input.next();

            if(word.equals("stop")){
                break ;
            }

            words.add(word);
        }

        while(true){
            // 1 =adds=Star 2= removeStar
            System.out.println("intput 1 = addStars, 2 = removeStars, 0 = Exit");
            int command = input.nextInt();

            if(command == 0){
                break;
            }

            if(command == 1){
                addStars(words);
            }
            else if (command == 2){
                removeStars(words);
            }
        }

        System.out.println(words);
    }

    public static void addStars(ArrayList<String> list) {
        for(int i = 0; i < list.size(); i += 2){
            list.add(i+1, "*");
        }
    }

    public static void removeStars(ArrayList<String> list) {
        list.removeIf(s -> s.equals("*"));
    }
}
