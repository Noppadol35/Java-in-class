import java.util.Scanner;

class PrimeNumberFinder {
    private int maxPrime;
    private int count;

    public PrimeNumberFinder() {
        maxPrime = -1;
        count = 0;
    }

    public int getMaxPrime() {
        return maxPrime;
    }

    public int getCount() {
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void findMaxPrime(int[] numbers) {
        for (int num : numbers) {
            if (num == 0) {
                break;
            }
            if (isPrime(num)) {
                if (num > maxPrime) {
                    maxPrime = num;
                    count = 1;
                } else if (num == maxPrime) {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");

        int[] numbers = new int[100];
        int index = 0;
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            numbers[index] = num;
            index++;
        }

        PrimeNumberFinder finder = new PrimeNumberFinder();
        finder.findMaxPrime(numbers);

        int maxPrime = finder.getMaxPrime();
        int count = finder.getCount();

        if (maxPrime != -1) {
            System.out.println("MaxPrimeNumber: " + maxPrime);
            System.out.println("Count: " + count);
        } else {
            System.out.println("-1");
        }
    }


}