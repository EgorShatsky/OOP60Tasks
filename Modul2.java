package modul2;

import java.util.Scanner;
import java.util.SplittableRandom;

public class Modul2 {
    public static void main(String[] args) {
        //double[]mas={1,3};                                         //Для активации необходимо убрать комментарий
        //int[]mas1={3,3,-2,408,3,3};                                //Для активации необходимо убрать комментарий
        //differenceMaxMin(mas1);                                    //Для активации необходимо убрать комментарий
        //System.out.println(isAvgWhole(mas));                       //Для активации необходимо убрать комментарий
        //repeat("java",3);                                          //Для активации необходимо убрать комментарий
        //cumulativeSum(mas1);                                       //Для активации необходимо убрать комментарий
        //getDecimalPlaces("400");                                   //Для активации необходимо убрать комментарий
        //Fibonacci(15);                                             //Для активации необходимо убрать комментарий
        //System.out.println(isValid("12345"));                      //Для активации необходимо убрать комментарий
        //System.out.println(isStrangePair("ratio","orator"));       //Для активации необходимо убрать комментарий
        //System.out.println(isPrefix("automation","auto"));;        //Для активации необходимо убрать комментарий
        //System.out.println(isSuffix("arachnophobia","phobia"));    //Для активации необходимо убрать комментарий
        //boxSeq(6);                                                 //Для активации необходимо убрать комментарий
    }


    /*
    1.
        Функция, которая повторяет каждый символ в строке n раз.
     */
    public static String repeat(String world,int n){
        String newworld="";// Создание пустой строки
        for (int i=0;i<world.length();i++){
            for (int j=0;j<n;j++){
                newworld=newworld+world.charAt(i);// Добавление символа к строке
            }
        }
        System.out.println(newworld);
        return world;
    }


    /*
    2.
        Функция, которая принимает массив и возвращает разницу
        между самыми большими и самыми маленькими числами.
     */
    public static void differenceMaxMin(int[]mas){
        int max=-10001;
        int min=10001;
        for (int i=0;i<mas.length;i++){
            if (mas[i]>max){
                max=mas[i];
            }
            if (mas[i]<min){
                min=mas[i];
            }
        }
        System.out.println(max-min);
    }


    /*
    3.
        Функция, которая принимает массив в качестве аргумента
        и возвращает true или false в зависимости от того, является ли
        среднее значение всех элементов массива целым числом или нет.
     */
    public static boolean isAvgWhole(double[]mas){
        double sum=0;
        for (int i=0;i<mas.length;i++){
            sum=mas[i]+sum;
        }
        if ((sum/mas.length)%1==0){ //Проверка на целове число
            return true;
        }
        return false;
    }


    /*
    4.
        Метод, который берет массив целых чисел
        и возвращает массив, в котором каждое целое число
        является суммой самого себя + всех предыдущих чисел в массиве.
     */
    public static void cumulativeSum(int[]mas){
        int sum=0;
        for (int i=0;i< mas.length;i++){
            sum=mas[i]+sum;
            System.out.println(sum);
        }
    }


    /*
    5.
        Функция, которая возвращает число десятичных знаков,
        которое имеет число (заданное в виде строки). Любые нули после
        десятичной точки отсчитываются в сторону количества десятичных знаков.
     */
    public static void getDecimalPlaces (String number){
       char[]mas=number.toCharArray();// Преобразование строки с чаровый массив
       int c=0;
       for (int i=number.length()-1;i>=0;i--){
           if (mas[i]=='.'){ //Проверка на точку
               System.out.println(c);
               c=0;
               i=-1;
           }
           else {
               c=c+1;
           }
       }
       if (c!=0){
           System.out.println(0);
       }
    }


    /*
    6.
    	Функция, которая при заданном числе возвращает
        соответствующее число Фибоначчи.
     */
    public static void Fibonacci(int number){
        int[]mas=new int[100];
        mas[0]=0;// Для того,чтобы числа Фибоначчи начинались с первого, а не с нулевого как массив.
        mas[1]=1;
        mas[2]=1;
        for (int i=3;i<=number;i++){
            mas[i]=mas[i-1]+mas[i-2];// Формула Фибоначчи
        }
        System.out.println(mas[number]);
    }


    /*
    7.
        Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
        напишите функцию, чтобы определить, является ли вход действительным
        почтовым индексом. Действительный почтовый индекс выглядит следующим образом:
        – Должно содержать только цифры (не допускается использование нецифровых цифр).
        – Не должно содержать никаких пробелов.
        – Длина не должна превышать 5 цифр.
     */

    public static boolean isValid(String index){
        int k=0;
        if (index.length()==5){
            for (int i=0;i<5;i++){
                if (Character.isDigit(index.charAt(i))==true){ // Проверка цифра или нет
                    k=k+1;
                }
            }
        }
        if (k==5){
            return true;
        }
        return false;
    }


    /*
    8.
        Пара строк образует странную пару, если оба из следующих условий истинны:
        – Первая буква 1-й строки = последняя буква 2-й строки.
        – Последняя буква 1-й строки = первая буква 2-й строки.
        – Создайте функцию, которая возвращает true, если пара строк представляет
         собой странную пару, и false в противном случае.
     */
    public static boolean isStrangePair(String word1,String word2){
        int length1=word1.length();
        int length2=word2.length();

        char f1=word1.charAt(0);
        char f2=word2.charAt(0);
        char l1=word1.charAt(length1-1);
        char l2=word2.charAt(length2-1);

        if ((f1==l2)&&(l1==f2)){
            return true;
        }
        return false;
    }


    /*
    9.
        Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
        – isPrefix должен возвращать true, если он начинается с префиксного аргумента.
        – isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
        – В противном случае верните false.
     */
    public static boolean isPrefix(String word,String prefix){
        for (int i=0;i<prefix.length()-1;i++){
            if (word.charAt(i)!=prefix.charAt(i)){ // Проверка слова word начиная с элемента с которого начинается prefix
                return false;
            }
        }
        return true;
    }

    public static boolean isSuffix(String word,String suffix){
      int k=1;
      for (int i=word.length()-suffix.length()+1;i<word.length();i++){
          if (word.charAt(i)!=suffix.charAt(k)){
              return false;
          }
          k++;
      }
      return true;
    }

    /*
    10.
        Создайте функцию, которая принимает число (шаг)
        в качестве аргумента и возвращает количество полей
        на этом шаге последовательности.
     */
    public static void boxSeq(int n){
        int[]mas=new int[]{0,3,2,5,4,7,6};
        System.out.println(mas[n]);
    }
}
