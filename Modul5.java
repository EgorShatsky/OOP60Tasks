package modul5;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import com.sun.org.apache.xml.internal.security.utils.SignerOutputStream;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;


public class Modul5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //System.out.println(Arrays.toString(encrypt("Hello")));
        //int[]mas=new int[]{ 72, 33, -73, 84, -12, -3, 13, -13, -68 };
        //System.out.println(decrypt(mas));
        //System.out.println(canMove("Ладья", "A8", "H8")  );
        //canComplete("butl", "beautiful");
        //int[]mas1=new int[]{0};
        //System.out.println(sumDigProd(mas1));
        //String[]mas2=new String[]{"toe", "ocelot", "maniac"};
        //System.out.println(Arrays.toString(sameVowelGroup(mas2)));
        //System.out.println(validateCard(1234567890123452l));
        //System.out.println(numToEng(919));
        //System.out.println(numToRus(919));
        //System.out.println(getSha256Hash("password123"));//Для этого метода потребовалось добавить throws NoSuchAlgorithmException
        //System.out.println( correctTitle("jOn SnoW, kINg IN thE noRth."));
        //System.out.println(haxLattice(15));
    }
    /*
    1.
    Пришло время отправлять и получать секретные сообщения.
    Создайте две функции, которые принимают строку и массив и возвращают
    закодированное или декодированное сообщение.
    Первая буква строки или первый элемент массива представляет собой символьный код этой буквы.
    Следующие элементы-это различия между символами: например, A +3 --> C или z -1 --> y.
     */

    public static int[] encrypt(String str){
        char[]book=str.toCharArray();
        int[]mas=new int[book.length];
        int diff=0;
        int pred=0;
        for (int i=0;i<book.length;i++){
            char A = book[i];// Присваиваем переменную массива
            int ascii = (int) A;// Присваем ascii код
            diff=ascii-pred;//Рзаность с предыдущем элементом массива
            pred=ascii;//Присваиваем предыдущий элемент
            mas[i]=diff;//Присваем ascii код массиву
        }
        return mas;
    }
    public static String decrypt(int[]mas){
        String stroka="";
        int sum=0;
        for (int i=0;i<mas.length;i++){
            sum=sum+mas[i];
            int ascii=sum;
            char A=(char) ascii;
            String str = String.valueOf(A);
            stroka=stroka+str;
        }
        return stroka;
    }
    /*
    2.
    Создайте функцию, которая принимает имя шахматной фигуры, ее положение и целевую позицию.
    Функция должна возвращать true, если фигура может двигаться к цели, и false, если она не может этого сделать.
    Возможные входные данные - "пешка", "конь", "слон", "Ладья", "Ферзь"и " король".
     */

    public static boolean canMove(String name, String start, String end) {
        char startLetter = start.charAt(0);
        int startNumber = Integer.parseInt(String.valueOf(start.charAt(1)));
        char endLetter = end.charAt(0);
        int endNumber = Integer.parseInt(String.valueOf(end.charAt(1)));

        if (startLetter == endLetter && startNumber == endNumber) return false;

        switch (name) {
            case "Пешка": {
                if (startLetter == endLetter && startNumber == 2 && endNumber == 4)
                    return true;
                return startLetter == endLetter && endNumber == (startNumber + 1);
            }
            case "Конь": {
                return (Math.abs(startLetter - endLetter) == 2 && Math.abs(startNumber - endNumber) == 1) || (Math.abs(startLetter - endLetter) == 1 && Math.abs(startNumber - endNumber) == 2);
            }
            case "Слон": {
                return Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber);
            }
            case "Ладья": {
                return (startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber);
            }
            case "Ферзь": {
                if ((startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber))
                    return true;
                if (Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber))
                    return true;
                break;
            }
            case "Король": {
                return Math.abs(startLetter - endLetter) < 2 && Math.abs(startNumber - endNumber) < 2;
            }
            default:
                return false;
        }

        return false;
    }

    /*
    3.
    Входная строка может быть завершена, если можно добавить дополнительные буквы,
    и никакие буквы не должны быть удалены, чтобы соответствовать слову. Кроме того,
    порядок букв во входной строке должен быть таким же, как и порядок букв в последнем слове.
    Создайте функцию, которая, учитывая входную строку, определяет, может ли слово быть завершено.
     */

    public static boolean canComplete(String str1, String str2) {
        char[] chars = str1.toCharArray();
        int startOfSearch = 0;
        for (char c : chars) {
            if (str2.indexOf(String.valueOf(c), startOfSearch) != -1)
                startOfSearch = str2.indexOf(String.valueOf(c), startOfSearch) + 1;
            else
                return false;
        }
        return true;
    }

    /*
    4.
    Создайте функцию, которая принимает числа в качестве аргументов,
    складывает их вместе и возвращает произведение цифр до тех пор,
    пока ответ не станет длиной всего в 1 цифру.
     */
    public static int  sumDigProd(int[]mas){
        int sum=0;
        for (int i=0;i<mas.length;i++){
            int first=mas[i];
            sum=sum+first;
        }
        while (sum>9){
            int k;
            int proizv=1;
            while (sum>0){
                k=sum%10;//Присвоение последнего числа
                sum=sum/10;//Удаление последнего числа
                proizv=k*proizv;//Высчитывание произведения
            }
            sum=proizv;
        }
        return sum;
    }

    /*
    5.
    Напишите функцию, которая выбирает все слова, имеющие все те же гласные
    (в любом порядке и / или количестве), что и первое слово, включая первое слово.
     */
    public static ArrayList<String> sameVowelGroup(String[] strs) {
        String[] allVowels = new String[]{"a", "e", "y", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < allVowels.length; i++) {
            if (strs[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) {
                vowels += allVowels[i];
            }
        }

        if (vowels.length() > 0) {
            result.add(strs[0]);
        } else {
            return result;
        }

        for (int i = 1; i < strs.length; i++) {
            boolean pass = true;

            for (int j = 0; j < vowels.length(); j++) {
                if (!strs[i].contains(String.valueOf(vowels.charAt(j)))) {
                    pass = false;
                    break;
                }
            }

            if (pass) result.add(strs[i]);
        }

        return result;
    }

    /*
    6.
    Создайте функцию, которая принимает число в качестве аргумента и возвращает true, если это
    число является действительным номером кредитной карты, а в противном случае-false.
    Номера кредитных карт должны быть длиной от 14 до 19 цифр и проходить тест Луна, описанный ниже:
    – Удалите последнюю цифру (это"контрольная цифра").
    – Переверните число.
    – Удвойте значение каждой цифры в нечетных позициях. Если удвоенное значение имеет более 1 цифры,
    сложите цифры вместе (например, 8 x 2 = 16 ➞ 1 + 6 = 7).
    – Добавьте все цифры.
    – Вычтите последнюю цифру суммы (из шага 4) из 10. Результат должен быть равен контрольной цифре из Шага 1.
     */
    public static boolean validateCard(long cardNum) {
        StringBuilder str = new StringBuilder();
        long number = cardNum;

        if (Long.toString(number).length() >= 14 && Long.toString(number).length() <= 19) {
            // step 1
            long lastNum = number % 10;
            StringBuilder cardNumStr = new StringBuilder(Long.toString(number /= 10));
            // step 2
            cardNumStr.reverse();
            // step 3
            for (int i = 0; i < cardNumStr.length(); i++) {
                if (i % 2 == 0) {
                    int c = Character.getNumericValue(cardNumStr.charAt(i)) * 2;

                    if (c > 9) {
                        String buf = Integer.toString(c);

                        str.append(Character.getNumericValue(buf.charAt(0)) + Character.getNumericValue(buf.charAt(1)));
                    } else {
                        str.append(c);
                    }
                } else {
                    str.append(cardNumStr.charAt(i));
                }
            }

            //System.out.println(str);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }

            //System.out.println(sum);
            //System.out.println(lastNum);

            return lastNum == 10 - sum % 10;
        }

        return false;
    }

    /*
    7.
    Напишите функцию, которая принимает положительное целое число от 0 до 999
    включительно и возвращает строковое представление этого целого числа, написанное на английском языке.
     */
    public static String numToEng(int num) {
        String str = "";
        if (num == 0) return "zero";

        switch (num / 100) {
            case 1: {
                str += "one hundred ";
                break;
            }
            case 2: {
                str += "two hundred ";
                break;
            }
            case 3: {
                str += "three hundred ";
                break;
            }
            case 4: {
                str += "four hundred ";
                break;
            }
            case 5: {
                str += "five hundred ";
                break;
            }
            case 6: {
                str += "six hundred ";
                break;
            }
            case 7: {
                str += "seven hundred ";
                break;
            }
            case 8: {
                str += "eight hundred ";
                break;
            }
            case 9: {
                str += "nine hundred ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "ten";
                        return str;
                    }
                    case 1: {
                        str += "eleven";
                        return str;
                    }
                    case 2: {
                        str += "twelve";
                        return str;
                    }
                    case 3: {
                        str += "thirteen";
                        return str;
                    }
                    case 4: {
                        str += "fourteen";
                        return str;
                    }
                    case 5: {
                        str += "fifteen";
                        return str;
                    }
                    case 6: {
                        str += "sixteen";
                        return str;
                    }
                    case 7: {
                        str += "seventeen";
                        return str;
                    }
                    case 8: {
                        str += "eighteen";
                        return str;
                    }
                    case 9: {
                        str += "nineteen";
                        return str;
                    }
                }
            }

            case 2: {
                str += "twenty ";
                break;
            }
            case 3: {
                str += "thirty ";
                break;
            }
            case 4: {
                str += "forty ";
                break;
            }
            case 5: {
                str += "fifty ";
                break;
            }
            case 6: {
                str += "sixty ";
                break;
            }
            case 7: {
                str += "seventy ";
                break;
            }
            case 8: {
                str += "eighty ";
                break;
            }
            case 9: {
                str += "ninety ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "one";
                break;
            }
            case 2: {
                str += "two";
                break;
            }
            case 3: {
                str += "three";
                break;
            }
            case 4: {
                str += "four";
                break;
            }
            case 5: {
                str += "five";
                break;
            }
            case 6: {
                str += "six";
                break;
            }
            case 7: {
                str += "seven";
                break;
            }
            case 8: {
                str += "eight";
                break;
            }
            case 9: {
                str += "nine";
                break;
            }
        }

        return str;
    }
    /*
    Для русского
     */

    public static String numToRus(int num) {
        String str = "";

        if (num == 0) return "ноль";

        switch (num / 100) {
            case 1: {
                str += "сто ";
                break;
            }
            case 2: {
                str += "двести ";
                break;
            }
            case 3: {
                str += "триста ";
                break;
            }
            case 4: {
                str += "четыреста ";
                break;
            }
            case 5: {
                str += "пятьсот ";
                break;
            }
            case 6: {
                str += "шестьсот ";
                break;
            }
            case 7: {
                str += "семьсот ";
                break;
            }
            case 8: {
                str += "восемьсот ";
                break;
            }
            case 9: {
                str += "девятьсот ";
                break;
            }
        }

        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "десять";
                        return str;
                    }
                    case 1: {
                        str += "одиннадцать";
                        return str;
                    }
                    case 2: {
                        str += "двенадцать";
                        return str;
                    }
                    case 3: {
                        str += "тринадцать";
                        return str;
                    }
                    case 4: {
                        str += "четырнадцать";
                        return str;
                    }
                    case 5: {
                        str += "пятнадцать";
                        return str;
                    }
                    case 6: {
                        str += "шестнадцать";
                        return str;
                    }
                    case 7: {
                        str += "семнадцать";
                        return str;
                    }
                    case 8: {
                        str += "восемьнадцать";
                        return str;
                    }
                    case 9: {
                        str += "девятнадцать";
                        return str;
                    }
                }
            }

            case 2: {
                str += "двадцать ";
                break;
            }
            case 3: {
                str += "тридцать ";
                break;
            }
            case 4: {
                str += "сорок ";
                break;
            }
            case 5: {
                str += "пятьдесят ";
                break;
            }
            case 6: {
                str += "шестьдесят ";
                break;
            }
            case 7: {
                str += "семьдесят ";
                break;
            }
            case 8: {
                str += "восемьдесят ";
                break;
            }
            case 9: {
                str += "девяносто ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "один";
                break;
            }
            case 2: {
                str += "два";
                break;
            }
            case 3: {
                str += "три";
                break;
            }
            case 4: {
                str += "четыре";
                break;
            }
            case 5: {
                str += "пять";
                break;
            }
            case 6: {
                str += "шесть";
                break;
            }
            case 7: {
                str += "семь";
                break;
            }
            case 8: {
                str += "восемь";
                break;
            }
            case 9: {
                str += "девять";
                break;
            }
        }

        return str;
    }

    /*
    8.
    Хеш-алгоритмы легко сделать одним способом, но по существу невозможно сделать наоборот.
    Например, если вы хешируете что-то простое, например, password123, это даст вам длинный код,
    уникальный для этого слова или фразы. В идеале, нет способа сделать это в обратном порядке.
    Вы не можете взять хеш-код и вернуться к слову или фразе, с которых вы начали.
    Создайте функцию, которая возвращает безопасный хеш SHA-256 для данной строки.
    Хеш должен быть отформатирован в виде шестнадцатеричной цифры.
     */
    public static String getSha256Hash(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] text = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        return HexBin.encode(text).toLowerCase();
    }

    /*
    9.
    Напишите функцию, которая принимает строку и возвращает строку с правильным
    регистром для заголовков символов в серии "Игра престолов".
    Слова and, the, of и in должны быть строчными. Все остальные слова должны иметь
    первый символ в верхнем регистре, а остальные-в Нижнем.
     */
    public static String correctTitle(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equalsIgnoreCase("of") && !tokens[i].equalsIgnoreCase("and") && !tokens[i].equalsIgnoreCase("the") && !tokens[i].equalsIgnoreCase("in")) {
                tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1).toLowerCase();
            } else {
                tokens[i] = tokens[i].toLowerCase();
            }
        }

        return String.join(" ", tokens);
    }

    /*
    10.
    Как указано в онлайн-энциклопедии целочисленных последовательностей:
    Гексагональная решетка - это привычная двумерная решетка, в которой
    каждая точка имеет 6 соседей.
    Центрированное шестиугольное число - это центрированное фигурное число,
    представляющее шестиугольник с точкой в центре и всеми другими точками, окружающими центральную точку в шестиугольной решетке.
     */
    public static String haxLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        String str2 = "";

        while (n > num) {
            i++;
            num = 3 * i * (i - 1) + 1;
        }

        int l = i;

        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = 0; b < l; b++)
                    res += " o  ";

                res += "\n";
                l++;
            }

            while (l >= i) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = l; b > 0; b--)
                    res += " o  ";

                res += "\n";
                l--;
            }
        }

        return res;
    }
}




