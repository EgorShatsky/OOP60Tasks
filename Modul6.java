package modul6;

import java.util.ArrayList;

public class Modul6 {
    public static void main(String[] args) {
        //System.out.println(bell(3));
        //System.out.println(translateWord("flag"));
        //System.out.println( validColor("rgb(0,0,0)"));
        //System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        //System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        //System.out.println(ulam(206));
        //System.out.println(longestNonrepeatingSubstring("abcabcbb") );
        //System.out.println(convertToRoman(12) );
        //System.out.println(formula("6 * 4 = 24") );
        //System.out.println(palindromedescendant(11211230));
    }

    /*
    1.
    Число Белла - это количество способов, которыми массив из n элементов может
    быть разбит на непустые подмножества. Создайте функцию, которая принимает число n
    и возвращает соответствующее число Белла.
     */
    public static int bell(int n) {
        int[][] bellTriangle = new int[n+1][n+1];
        bellTriangle[0][0] = 1;

        for (int i=1; i<=n; i++) {
            bellTriangle[i][0] = bellTriangle[i-1][i-1];

            for (int j=1; j<=i; j++) {
                bellTriangle[i][j] = bellTriangle[i-1][j-1] + bellTriangle[i][j-1];
            }
        }

        return bellTriangle[n][0];
    }

    public static String translateWord(String word) {
        String result = word;

        if (String.valueOf(result.charAt(0)).toLowerCase().matches("[aeiouy]")) {
            result += "yay";
        } else {
            result = result.toLowerCase();
            String newWord = result.split("[aeiouy]")[0];
            result = result.replaceFirst(newWord,"") + newWord + "ay";
            result = String.valueOf(result.charAt(0)).toUpperCase() + result.substring(1);
        }

        return result;
    }

    /*
    2.
    В «поросячей латыни» (свинский латинский) есть два очень простых правила:
    – Если слово начинается с согласного, переместите первую букву (буквы) слова
    до гласного до конца слова и добавьте «ay» в конец.
    have ➞ avehay
    cram ➞ amcray
    take ➞ aketay
    cat ➞ atcay
    shrimp ➞ impshray
    trebuchet ➞ ebuchettray
    –	Если слово начинается с гласной, добавьте "yay" в конце слова.
    ate ➞ ateyay
    apple ➞ appleyay
    oaken ➞ oakenyay
    eagle ➞ eagleyay
    Напишите две функции, чтобы сделать переводчик с английского на свинский латинский.
    Первая функция translateWord (word) получает слово на английском и возвращает это слово,
    переведенное на латинский язык. Вторая функция translateSentence (предложение) берет английское
    предложение и возвращает это предложение, переведенное на латинский язык.
     */
    public static String translateSentence(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            if (String.valueOf(tokens[i].charAt(0)).toLowerCase().matches("[aeiouy]")) {
                if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 1) + "yay" + tokens[i].charAt(tokens[i].length() - 1);
                } else {
                    tokens[i] += "yay";
                }
            } else {
                if (String.valueOf(tokens[i].charAt(0)).matches("[QWRTPSDFGHJKLZXCVBNM]")) {
                    if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                        char mark = tokens[i].charAt(tokens[i].length() - 1);
                        tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1) + mark;
                    } else {
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1);
                    }
                } else {
                    if (String.valueOf(tokens[i].charAt(tokens[i].length() - 1)).matches("[!?.,:;]")) {
                        char mark = tokens[i].charAt(tokens[i].length() - 1);
                        tokens[i] = tokens[i].substring(0, tokens[i].length() - 1);
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                        tokens[i] = tokens[i] + mark;
                    } else {
                        tokens[i] = tokens[i].toLowerCase();
                        String newWord = tokens[i].split("[aeiouy]")[0];
                        tokens[i] = tokens[i].replaceFirst(newWord,"") + newWord + "ay";
                    }
                }
            }
        }

        return String.join(" ", tokens);
    }

    /*
    3.
    Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых значений допустимым или нет.
    Создайте функцию, которая принимает строку (например, " rgb(0, 0, 0)") и возвращает true, если ее формат
    правильный, в противном случае возвращает false.
     */
    public static boolean validColor(String str) {
        if (!str.startsWith("rgb") && !str.startsWith("rgba")) {
            return false;
        }

        String[] numbers = str.split("\\(")[1].split(",");
        numbers[numbers.length - 1] = numbers[numbers.length - 1].substring(0, numbers[numbers.length - 1].length() - 1);

        if (str.startsWith("rgb") && !str.startsWith("rgba")) {
            if (str.contains(".")) {
                return false;
            }

            for (int i = 0; i < numbers.length; i ++) {
                if (numbers[i].trim().equals("")) {
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i ++) {
                if (numbers[i].trim().equals("")) {
                    return false;
                }

                int num = Integer.parseInt(numbers[i].trim());

                if (!(num >= 0 && num <= 255)) {
                    return false;
                }
            }

            if (numbers[3].trim().equals("")) return false;

            double num = Double.parseDouble(numbers[3].trim());

            return num >= 0 && num <= 1;
        }

        return true;
    }

    /*
    4.
    Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся параметры запроса и параметры,
    указанные во втором аргументе (который будет необязательным массивом).
     */
    public static String stripUrlParams(String url, String ...paramsToStrip) {
        String str = "";

        if (!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }

        char[] params = str.toCharArray();
        StringBuilder print = new StringBuilder();

        for (char param : params) {
            if (Character.isLetter(param))
                if (!(print.toString().contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                        }
                    }
                    else
                        print.append(str, str.lastIndexOf(param), str.lastIndexOf(param) + 3).append("&");
                }
        }

        return url + print.substring(0, print.length()-1);
    }

    /*
    5.
    Напишите функцию, которая извлекает три самых длинных слова из заголовка газеты и преобразует их в хэштеги.
    Если несколько слов одинаковой длины, найдите слово, которое встречается первым.
     */
    public static ArrayList<String> getHashTags(String str){
        String[] tokens = str.toLowerCase().split(" ");
        ArrayList<String> hashtags = new ArrayList<>();

        while (hashtags.size() < 3) {
            double maxLength = Double.NEGATIVE_INFINITY;
            String word = "";
            int idx = 0;

            try {
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].length() > maxLength) {
                        maxLength = tokens[i].length();
                        word = tokens[i];
                        idx = i;
                    }
                }

                if (String.valueOf(word.charAt(word.length() - 1)).matches("[!?.,;:]")) {
                    hashtags.add("#" + word.substring(0, word.length() - 1));
                } else {
                    hashtags.add("#" + word);
                }
                tokens[idx] = "";
            } catch (StringIndexOutOfBoundsException e) {
                return hashtags;
            }
        }

        return hashtags;
    }

    /*
    6.
    Последовательность Улама начинается с:
    ulam = [1, 2]
    Следующее число в последовательности - это наименьшее положительное число,
    равное сумме двух разных чисел (которые уже есть в последовательности) ровно одним способом.
    Тривиально, это 3, так как в стартовой последовательности есть только 2 числа.
    ulam = [1, 2, 3]
    Следующее число 4, которое является суммой 3 + 1. 4 также равно 2 + 2, но это уравнение не учитывается,
    так как 2 добавления должны быть различны.
    ulam = [1, 2, 3, 4]
    Следующее число не может быть 5, так как 5 = 1 + 4, но также и 5 = 2 + 3.
    Должен быть только один способ сделать число Улама из 2 различных добавлений, найденных в последовательности. Следующее число 6 (2 + 4). Есть 2 способа сделать 7 (1 + 6 или 3 + 4), поэтому следующий - 8 (2 + 6). И так далее.
    ulam = [1, 2, 3, 4, 6, 8, 11, 13, 16, 18, 26, 28, 36, 38, 47, 48, 53, …]
    Создайте функцию, которая принимает число n и возвращает n-е число в последовательности Улама.
     */
    public static int ulam (int n){
        int[] arr = new int[n];
        arr[0]=1;
        arr[1]=2;
        int len=2, next=3;

        while (next < Integer.MAX_VALUE && len < n){
            int count = 0;

            for (int i = 0; i < len; i++){
                for (int j = len-1; j > i; j--){
                    if (arr[i] + arr[j] == next && arr[i] != arr[j])
                        count++;
                    else if (count > 1)
                        break;
                }

                if (count > 1)
                    break;
            }
            if (count == 1) {
                arr[len] = next;
                len++;
            }
            next++;
        }
        return arr[n-1];
    }

    /*
    7.
    Напишите функцию, которая возвращает самую длинную неповторяющуюся подстроку для строкового ввода.
     */
    public static String longestNonrepeatingSubstring(String str){
        String substr = "";
        char [] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : chars) {
            if (!builder.toString().contains(String.valueOf(c)))
                builder.append(c);
            else {
                if (builder.length() > substr.length()) {
                    substr = builder.toString();
                }
                builder = new StringBuilder("" + c);
            }
        }

        str = builder.toString();

        if (str.length() > substr.length())
            substr = str;

        return substr;
    }

    /*
    8.
    Создайте функцию, которая принимает арабское число и преобразует его в римское число.
     */
    public static String convertToRoman (int num){
        StringBuilder roman = new StringBuilder();

        if (num < 1 || num > 3999)
            return "Введите число поменьше. ";

        while (num >= 1000) {
            roman.append("M");
            num -= 1000;
        }

        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }

        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }

        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }

        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }

        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }

        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }

        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }

        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }

        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }

        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }

        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }

        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }

        return roman.toString();
    }

    /*
    9.
    Создайте функцию, которая принимает строку и возвращает true или false в зависимости от того,
    является ли формула правильной или нет.
     */
    public static boolean formula(String formula){
        String[] tokens = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;

        if (!Character.isDigit(tokens[0].charAt(0))) return false;
        else ans = Integer.parseInt(tokens[0]);

        int i = 1;

        while (!tokens[i].equals("=")) {
            if (tokens[i].equals("+")){
                ans += Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("-")){
                ans -= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("*")){
                ans *= Integer.parseInt(tokens[i + 1]);
            }
            if (tokens[i].equals("/")){
                ans /= Integer.parseInt(tokens[i + 1]);
            }

            i += 2;
        }

        i = formula.indexOf('=');
        String check = formula.substring(i + 1);

        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(tokens[tokens.length - 1]);

        return ans == expectedResult;
    }

    /*
    10.
    Число может не быть палиндромом, но его потомком может быть.
    Прямой потомок числа создается путем суммирования каждой пары соседних цифр,
    чтобы создать цифры следующего числа.
    Например, 123312 – это не палиндром, а его следующий потомок 363, где: 3 = 1 + 2; 6 = 3 + 3; 3 = 1 + 2.
    Создайте функцию, которая возвращает значение true, если само число является палиндромом или любой
    из его потомков вплоть до 2 цифр (однозначное число - тривиально палиндром).
     */
    public static boolean palindromedescendant(int num){
        boolean isDescendant = false;
        StringBuffer buffer1 =new StringBuffer(num);
        StringBuffer buffer2 =new StringBuffer(num);

        if (buffer1.length() % 2 != 0)
            return false;
        else {
            while (!isDescendant){
                if(buffer1 != buffer1.reverse()){
                    for(int i = 0; i < buffer1.length(); i += 2){
                        int a = Integer.parseInt(String.valueOf(buffer1.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(buffer1.charAt(i + 1)));
                        buffer2.append(a + b);
                    }
                }
                else
                    isDescendant = true;
            }
        }

        return isDescendant;
    }
}

