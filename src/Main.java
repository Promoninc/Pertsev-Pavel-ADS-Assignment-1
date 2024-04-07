import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    // Task 1

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++){
            numArr[i] = sc.nextInt();
        }
        System.out.println(min(n, numArr));
    }

    //Linear complexity O(n)
    public static int min(int n, int[] numArr){
        if(n == 1){
            return numArr[0];
        }
        int prevNum = min(n-1, numArr);
        if(numArr[n-1] < prevNum){
            return numArr[n - 1];
        }
        else{
            return prevNum;
        }
    }

    // Task 2

    public static void task2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++){
            numArr[i] = sc.nextInt();
        }
        System.out.println(avr(n, numArr));
    }

    //Linear complexity O(n)
    public static double avr(int n, int[] numArr){
        return sum(n, numArr, 0) / n;
    }
    public static double sum(int n, int[] numArr, double sum){
        if(n == 0){
            return sum;
        }
        return sum(n-1, numArr, sum + numArr[n-1]);
    }

    // Task 3

    public static void task3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isPrime(n, n)){
            System.out.println("Prime");
        }
        else{
            System.out.println("Composite");
        }
    }

    // Linear complexity O(n)
    public static boolean isPrime(int n, int k){
        if(k == 1){
            return true;
        }
        if(n == k){
            return isPrime(n, k - 1);
        }
        return isPrime(n, k - 1) && n % k != 0;
    }

    // Task 4

    public static void task4(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }

    // Linear complexity O(n)
    public static int fact(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * fact(n-1);
    }

    // Task 5

    public static void task5(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    // Exponential complexity O(2^n)
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    // Task 6

    public static void task6(){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(deg(a, n));
    }

    // Linear complexity O(n)
    public static double deg(double a, int n){
        if(n == 0){
            return 1;
        }
        return deg(a, n - 1) * a;
    }

    // Task 7

    public static void task7(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        permutations(str.toCharArray(), 0, str.length() - 1);
    }

    //Factorial complexity O(n!)
    public static void permutations(char[] arr, int start, int end) {
        if (start == end) {
            System.out.println(arr);
        }
        else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permutations(arr, start + 1, end);
                swap(arr, start, i);
            }
        }
    }
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Task 8

    public static void task8(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isDigit(str.toCharArray(), str.length() - 1)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    // Linear complexity O(n)
    public static boolean isDigit(char[] arr, int n){
        if(n == 0){
            if(arr[n] < 57 && arr[n] > 48){
                return true;
            }
        }
        if(isDigit(arr, n - 1)){
            return (arr[n] < 57 && arr[n] > 48);
        }
        return false;
    }

    // Task 9

    public static void task9(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(binCoef(n, k));
    }

    //Exponential complexity O(2^n)
    public static int binCoef(int n, int k){
        if(k == 0 || n == k){
            return 1;
        }
        return binCoef(n - 1, k - 1) + binCoef(n - 1, k);
    }

    // Task 10

    public static void task10(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(gcd(n, k));
    }

    // Linear complexity O(n)
    public static int gcd(int n, int k){
        if(n == k){
            return n;
        }
        if(n > k){
            return gcd(n - k, k);
        }
        else{
            return gcd(n, k - n);
        }
    }
}
