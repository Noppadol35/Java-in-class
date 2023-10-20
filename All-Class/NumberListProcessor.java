import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberListProcessor {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = readNumbers();

        printAverage(numberList);
        printMax(numberList);
        printMin(numberList);

        removeEvenNumbers(numberList);

        printNumberList(numberList);
    }

    public static ArrayList<Integer> readNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");

            for (String num : nums) {
                numbers.add(Integer.parseInt(num));
            }
        }

        return numbers;
    }

    public static void printAverage(ArrayList<Integer> numbers) {
        double average = calculateAverage(numbers);
        System.out.println(average);
    }

    public static void printMax(ArrayList<Integer> numbers) {
        int max = findMax(numbers);
        System.out.println(max);
    }

    public static void printMin(ArrayList<Integer> numbers) {
        int min = findMin(numbers);
        System.out.println(min);
    }

    public static double calculateAverage(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }

    public static int findMax(ArrayList<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void removeEvenNumbers(ArrayList<Integer> numbers) {
        numbers.removeIf(num -> num % 2 == 0);
    }

    public static void printNumberList(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
