package modul4;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.sun.media.jfxmediaimpl.HostUtils;
import org.w3c.dom.ls.LSOutput;
import javax.sql.rowset.spi.SyncResolver;

public class Modul4 {
    public static void main(String[] args) {
        //System.out.println(TextEditor(10,7,"hello my name is Bessie and this is my essay"));
        //System.out.println(split("()()()"));
        //System.out.println(toCamelCase("hello_edabit"));
        //System.out.println(toSnakeCase("helloEdabit"));
        //System.out.println(overTime(9,17,30,1.5));
        //BMI(56,185);
        //System.out.println(bugger(39));
        //toStarShorthand("abbccc");//Не работает
        //System.out.println(doesRhyme("and frequently do?", "you gotta move.") );
        //System.out.println(truoble(1222345, 12345));
        //System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

    }
    /*
    1.
    Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох,
    она решает напечатать эссе с помощью текстового процессора. Эссе содержит N слов (1≤N≤100),
    разделенных пробелами. Каждое слово имеет длину от 1 до 15 символов включительно и состоит только
    из прописных или строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано
    очень специфическим образом: каждая строка должна содержать не более K (1≤K≤80) символов,
    не считая пробелов. К счастью, текстовый процессор Бесси может справиться с этим требованием,
    используя следующую стратегию:
– Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку.
    В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке.
    Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом.
    В конце любой строки не должно быть места.
–	К сожалению, текстовый процессор Бесси только что сломался. Пожалуйста, помогите ей правильно оформить свое эссе!
     */

    public static String TextEditor(int n,int k,String esse){ // n - количество слов, k - количество символов в строке
        String Line="";//Создание пустой строки
        String s="";//Создание пустой строки
        String[]words=esse.split(" ");//Разбиение строки на слова и запись этих слов в массив
        for (int i=0;i<words.length;i++){//Цикл
            String word=words[i]; //Присвоение слова с индексом i
            if (Line.replaceAll(" ","").length()+word.length()>k){
                s=s+Line.trim()+'\n';//Переход на другую строку
                Line=word+ " ";//Добавление пробела
            }
            else{
                Line=Line+word+" ";//Добавление пробела
            }
        }
        s=s+Line.trim();// в Line удаляются пробелы в начале и в конце строки с помощью trim
        return s;
    }
    /*
    2.
    Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.
     */

    public static String[] split(String string1){
        int k=0;// Счетчик скобочек
        String str="";// Пустая строка
        for (int i=0;i<string1.length();i++){ //Цикл
            str=str+string1.charAt(i);//Прибавление к строке по одному символу чарового массива
            if (string1.charAt(i)=='('){ //Если элемент чарового массива равен (
                k=k+1;//Увеличение счетчика
            }
            else{
                k=k-1;// Уменьшение счетчика
            }
            if (k==0){
                str=str+" ";
            }
        }
        return str.split(" ");
    }

    /*
    3.
    Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет одну строку
    и преобразует ее либо в camelCase, либо в snake_case.
     */

    public static String toCamelCase(String s){
        String str="";//Создание пкстой строки
        for (int i=0;i<s.length();i++){//Цикл
            if (s.charAt(i)=='_'){ //Если элемент строки равен _
                String str1=""+s.charAt(i+1);// Присваивается следующий после _ символ
                str=str+str1.toUpperCase();//Символ после _ переводится в верхний регистр и складывеется с основной строкой
                i++;
            }
            else{
                str=str+""+s.charAt(i);//Строка без изменений
            }
        }
        return str;
    }
    public static String toSnakeCase(String s){
        String str="";//Пустая строка
        for (int i=0;i<s.length();i++){//Цикл
            String str1=""+s.charAt(i);//Присваивание символа с индексом i
            if (str1==str1.toUpperCase()){ //Если символ в верхнем регистре
                str=str+"_"+str1.toLowerCase();//Понижаем регистр символа
            }
            else{
                str=str+""+s.charAt(i);//Оставляем без изменений
            }
        }
        return str;
    }

    /*
    4.
    Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.
    Работа с 9 до 5: обычные часы работы
    После 5 вечера это сверхурочная работа
    Ваша функция получает массив с 4 значениями:
    – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
    – Конец рабочего дня. (Тот же формат)
    – Почасовая ставка
    – Множитель сверхурочных работ
     */

    public static double  overTime(double n,double k,double st,double mn){
        double salary=0;
        for (double i=n;i<17;i++){
            salary=salary+st;
        }
        if (k>17){
            for (double i=17;i<k;i++){
                salary=salary+(st*mn);
            }
        }
        return salary;
    }

    /*
    5.
    Индекс массы тела (ИМТ) определяется путем измерения вашего веса в килограммах и деления
    на квадрат вашего роста в метрах. Категории ИМТ таковы:
    Недостаточный вес: <18,5
    Нормальный вес: 18.5-24.9
    Избыточный вес: 25 и более
    Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах, метрах или дюймах)
    и возвращать ИМТ и связанную с ним категорию. Округлите ИМТ до ближайшей десятой.
     */

    public static void BMI(double w,double h){//Необходимо доработать ИМТ
        double bmi=(w/((h/100.0)*(h/100.0)));
        if (bmi<18.5){
            String str = String.format("%.1f",bmi);
            System.out.println("ИМТ-"+str+" Underweight");
        }
        else if (bmi>=18.5&&bmi<24.9){
            String str = String.format("%.1f",bmi);
            System.out.println("ИМТ-"+str+" Normal weight");
        }
        else {
            String str = String.format("%.1f",bmi);
            System.out.println("ИМТ-"+str+" Overweight");
        }
    }

    /*
    6.
    Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство,
    которое представляет собой количество раз, которое вы должны умножать цифры в num,
    пока не достигнете одной цифры.
     */

    public static int bugger(int n){
        if (n<10){
            return 0;
        }
        int k=1;
        int num=0;
        while (n>9){
            k=1;
            int proizv=1;
            while (n>0){
                k=n%10;//Присвоение последнего числа
                n=n/10;//Удаление последнего числа
                proizv=k*proizv;//Высчитывание произведения
            }
            n=proizv;// присваиваем новое произведение
            num++;

        }
        return num;
    }

    /*
    7.
    Напишите функцию, которая преобразует строку в звездную стенографию.
    Если символ повторяется n раз, преобразуйте его в символ*n.
     */

    public static void toStarShorthand(String str){
        char A='*';
        String ka0=String.valueOf(A);// Перевод символа * в стринг
        char[]buk=str.toCharArray();// Создание чарового массива
        String stroka="";// Пустая строка
        String stroka1="";// Пустая строка
        char B=' ';// Пустая переменная чар
        for (int i=0;i<buk.length;i++){

        }

        //String ka=String.valueOf(k);
        //String ka1=String.valueOf(B);
        //stroka=ka1+ka0+ka;
        //stroka1=stroka1+stroka;
        System.out.println(stroka1);
    }

    /*
    8.
    Создайте функцию, которая возвращает true, если две строки рифмуются,
    и false в противном случае. Для целей этого упражнения две строки рифмуются,
    если последнее слово из каждого предложения содержит одни и те же гласные.
     */

    public static boolean doesRhyme(String str,String str1){

        char[]Vowel=new char[]{'a','e','i','o','u','y'};//Все гласные буквы английского алфавита
        String[]mas=str.split(" ");//Разбиваем строку на слова
        String[]mas1=str1.split(" ");//Разбиваем строку на слова

        String word=mas[mas.length-1];//Записываем последнее словов в переменную
        String word1=mas1[mas1.length-1];//Записываем последнее словов в переменную

        word=word.toLowerCase();//Понижаем регистры, тк по заданию они не важны
        word1=word1.toLowerCase();//Понижаем регистры, тк по заданию они не важны

        char[]wd=word.toCharArray();//Разбиение слова на символы
        char[]wd1=word1.toCharArray();////Разбиение слова на символы

       String vo="";//Создаем пустую строку
       String vo1="";//Создаем пустую строку

        for (int i=0;i<wd.length;i++){ //Цикл сравнения символа с гласной букой
            for (int j=0;j<Vowel.length;j++){
                if (wd[i]==Vowel[j]){
                    vo=vo+String.valueOf(wd[i]);// Записываем в пустую строку гласные буквы слова
                }
            }
        }

        for (int i=0;i<wd1.length;i++){ //Цикл сравнения символа с гласной букой
            for (int j=0;j<Vowel.length;j++){
                if (wd1[i]==Vowel[j]){
                    vo1=vo1+String.valueOf(wd1[i]);// Записываем в пустую строку гласные буквы слова
                }
            }
        }

        char[]maa=vo.toCharArray();//Строку получившихся гласных записываем в массив char
        char[]maa1=vo1.toCharArray();//Строку получившихся гласных записываем в массив char

        System.out.println(maa);
        System.out.println(maa1);
        int s=0;//Счетчик
        for (int i=0;i<maa.length;i++){
            for (int j=0;j<maa1.length;j++){
                if (maa[i]==maa1[j]){
                    s=s+1;//Считаем кол-во одинаковых гласных букв в чаровых массивах
                }
            }
        }
        if (s==maa.length&&s==maa1.length){//Если кол-во гласных совпадает с длинами массивов, то тру
             return true;
        }
        return false;
    }

    /*
    9.
    Создайте функцию, которая принимает два целых числа и возвращает true,
    если число повторяется три раза подряд в любом месте в num1 и то же самое
    число повторяется два раза подряд в num2.
     */

    public static boolean truoble(int num1,int num2){
        String nm1 = String.valueOf(num1);//Преобразуем целочисленный тип в строковый
        String nm2 = String.valueOf(num2);//

        char[]number1=nm1.toCharArray();//Преобразуем строку в массив элементов char
        char[]number2=nm2.toCharArray();
        char A=' ';//Пустая char переменная

        for (int i=0;i<number1.length-2;i++){
            if ((number1[i]==number1[i+1])&&(number1[i+1]==number1[i+2])){//проверка на 3 соседних одинаковых элемента
                A=number1[i];//Если 3 одинаковых элемента подряд, то запоминаем этот элемент
            }
        }
        int k=0;

        for (int j=0;j<number2.length;j++){
            if (number2[j]==A){ //Проверка встречается ли этот элемент во втором числе 2 раза
                k++;
            }
        }
        if (k==2){ //Если встречается, то тру
            return true;
        }

        return false;
    }

    /*
    10.
    Предположим, что пара одинаковых символов служит концами книги для всех символов между ними.
    Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать)
    между всеми парами концов книги.
    Эта функция будет выглядеть следующим образом:
     */

    public static int countUniqueBooks(String str, char c) {
        Map<Character, Integer> values = new HashMap<>();
        boolean start = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c && start) {
                i++;

                while (str.charAt(i) != c) {
                    Integer n = values.get(str.charAt(i));

                    if (n == null) values.put(str.charAt(i), 1);

                    i++;
                }

                start = false;
            }

            if (str.charAt(i) == c)
                start = true;
        }

        return values.size();
    }
}

