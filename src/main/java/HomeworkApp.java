import java.util.Arrays;
import java.util.Scanner;

public class HomeworkApp {
    public static void main(String[] args) {
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        changeArray01(array);
        System.out.println(Arrays.toString(array)); // вывод в консоль решения первого задания
        System.out.println(Arrays.toString(fillArray1to100())); //вывод в консоль решения второго задания
        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(multiplyBelow6InArray(array2))); //вывод в консоль решения третьего задания
        Scanner scanner = new Scanner(System.in); // для следующего задания использую сканнер для практики
        System.out.println("Введите размер двумерного квадратного массива");
        int n = scanner.nextInt();
        int[][] array3 = new int[n][n];
        determineDiagonals(array3); /* deepToString печатает в строчку, поэтому решил печатать прям в методе
        это решение четвертого задания */
        System.out.println("Введите длину одномерного массива");
        int len = scanner.nextInt();
        System.out.printf("Введите число для заполнения массива длиною %d\n", len);
        int initialValue = scanner.nextInt();
        System.out.println(Arrays.toString(fillValueArray(len, initialValue))); // решение пятого задания
        System.out.println("Введите размер случайного массива"); // это для дальнейших заданий со звездочкой
        int size = scanner.nextInt();
        maxMinValue(randomArray(size)); // решение шестого задания
        System.out.println(checkBalance(randomArray(size))); // решение седьмого задания с случайным массивом
        int[] array4 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("Массив из примера");
        System.out.println(checkBalance(array4)); // решение седьмого задания с массивом из примера
        System.out.println(Arrays.toString(displaceArrayNumbers(randomArray(10), 2))); // решение восьмого задания
    }
    public static byte[] changeArray01(byte[] array) { //тут выбрал байт, потому что значения только 0 или 1
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else array[i] = 1;
        }
        return array;
    }
    public static int[] fillArray1to100() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
    public static int[] multiplyBelow6InArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }
    public static void determineDiagonals(int[][] array){
        int k = array.length-1;
        for (int i = 0; i < array.length; i++, k--) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j == k) {
                    array[i][j] = 1;
                } else array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] fillValueArray(int len, int initialValue){
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    public static int[] randomArray(int size){ // дополнительный метод для решения задач с * и **.
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) Math.round(Math.random() * 100);// делаем случайный массив
        }
        return array;
    }
    public static void maxMinValue(int[] array) {
        int max = array[0], min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
            if (min > array[i]) min = array[i];
        }
        System.out.println("Сгенерированный массив");
        System.out.println(Arrays.toString(array));
        System.out.println("Максимальное число = " + max);
        System.out.println("Минимальное число = " + min);
    }
    public static boolean checkBalance(int[] array){
        System.out.println("Используемый массив: " + Arrays.toString(array)); // Чтобы было видно случайный массив
        boolean check = false;
        int sumL = 0, sumR = array[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            sumL += array[i];
        }
        for (int i = 0, n = array.length - 2; i < array.length - 1; i++, n--) {
            if (sumL == sumR) {
                check = true;
                break;
            } else {
                sumL -= array[n];
                sumR += array[n];
            }
        }
        return check;
    }
    public static int[] displaceArrayNumbers(int[] array, int n){
        System.out.println(Arrays.toString(array));
        if (n == 0) return array;
        int buffer = 0;
        if (n < 0) { // крутим налево
            n = Math.abs(n); // берем модуль числа
            for (int j = 1; j <= n; j++) {
                for (int i = 0; i < array.length - 1; i++) {
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        } else { // крутим направо
            for (int j = 1; j <= n; j++){
                for (int i = array.length - 1; i > 0; i--) {
                    buffer = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buffer;
                }
            }
        }
        return array;
    }
}
