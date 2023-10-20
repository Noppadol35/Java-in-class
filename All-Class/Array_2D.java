// import java.util.Scanner;

// public class Array_2D
// {
//     // public static void main(String[] args) {
//     //     Scanner input = new Scanner(System.in);
//     //     int n = input.nextInt();
//     //     int m = input.nextInt();
//     //     int [][] x= new int [n][m];

//     //     for(int i = 0; i < x.length;i++)
//     //     {
//     //         for(int j = 0; j < x[i].length; j++){
//     //             x[i][j] = input.nextInt();
//     //         }
//     //     }
//     //     int sum = sum2DimArray(x);
//     //     // int sum = 0;
//     //     // for(int i = 0; i < x.length; i++){
//     //     //     for(int j = 0; j < x[i].length; j++){
//     //     //         sum += x[i][j];
//     //     //     }
//     //     // }

//     //     System.out.println("sum: " + sum);
//     // }

//     // public static int sum2DimArray(int[][] arr) {
//     //     int sum = 0;
//     //     for(int i =0 ; i < arr.length ; i++){
//     //         for(int j = 0; j < arr[i].length;j++)
//     //         {
//     //             sum += arr[i][j];
//     //         }
//     //     }
//     //     return sum;
//     // }

//     public static void main(String[] args) {
//         Scanner input =new Scanner(System.in );
//         Studen[] arrStd = new Studen[10];
//         for(int i = 0; i < arrStd.length ; i++){
//             String name = input.next();
//             String surname = input.next();
//             int id = input.nextInt();
//             Double gpa = input.nextDouble();

//             Student objStd = new Student();
//             arrStd[i] = objStd;
//             arrStd[i].name = name;
//         }
//     }

//     class Student{
//         String name;
//         String surname;
//         int id;
//         double gpa;

//         Student();
//         Student(String name, String surname, int id){
//             this.name = name;
//             this.surname = surname;
//             this.id = id;
//         }
//     }
// }