package modul3;

public class Modul3 {
    public static void main(String[] args) {
        //solution(1,0,1);                                            //Для активации необходимо убрать комментарий
        //findzip("all zip files are zipped");                        //Для активации необходимо убрать комментарий
        //System.out.println(checkPerfect(497));                      //Для активации необходимо убрать комментарий
        //flipEndChars("booney");                                     //Для активации необходимо убрать комментарий
        //System.out.println(isValidHexCode("1ABc12"));               //Для активации необходимо убрать комментарий
        //int[]arr1={1,3,4,4,4};                                      //Для активации необходимо убрать комментарий
        //int[]arr2={2,5,7};                                          //Для активации необходимо убрать комментарий
        //System.out.println(same(arr1,arr2));                        //Для активации необходимо убрать комментарий
        //System.out.println(isKaprekar(5));                          //Для активации необходимо убрать комментарий
        //int[]mas={0,1,1,0,0,0,0,1,0,1,1,0,0,0};                     //Для активации необходимо убрать комментарий
        //longestZero("0110000101100000");                            //Для активации необходимо убрать комментарий
        //nextPrime(600);                                             //Для активации необходимо убрать комментарий
        //System.out.println(rightTriangle(145,105,101));;            //Для активации необходимо убрать комментарий

    }


    /*
    1.
    Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1,
    либо 2 различных решения для действительных значений x.
    учитывая a, b и c, вы должны вернуть число решений в уравнение.
     */
    public static void solution(int a,int b,int c){
        int D=b*b-(4*a*c);// Формула дискриминанта
        if (D>0){
            System.out.println(2);
        }
        if (D==0){
            System.out.println(1);
        }
        if (D<0){
            System.out.println(0);
        }
    }


    /*
    2.
    Напишите функцию, которая возвращает позицию второго вхождения " zip " в строку, или -1,
    если оно не происходит по крайней мере дважды. Ваш код должен быть достаточно общим,
    чтобы передать все возможные случаи, когда "zip" может произойти в строке.
     */
    public static void findzip(String str){
        char[]mas=str.toCharArray();// Преобразование строки в чаровый массив
        int k=0;
        for (int i=0;i<mas.length;i++){
            if ((mas[i]=='z')&&(mas[i+1]=='i')&&(mas[i+2]=='p')){// Проверка на zip в массиве
                k=k+1;//Счетчик
                if (k==2){
                    System.out.println(i);
                }
            }
        }
        if (k<2){
            System.out.println(-1);
        }
    }


    /*
    3.
    Создайте функцию, которая проверяет, является ли целое число совершенным числом или нет.
    Совершенное число - это число, которое можно записать как сумму его множителей, исключая само число.
    Например, 6-это идеальное число, так как 1 + 2 + 3 = 6, где 1, 2 и 3-Все коэффициенты 6.
    Точно так же 28-это совершенное число, так как 1 + 2 + 4 + 7 + 14 = 28.
     */
    public static boolean checkPerfect(int n){
        int[]mas=new int[n]; //Создание массива
        for (int i=1;i<n;i++){
            if (n%i==0){ //проверка является множетелем или нет
                mas[i]=i;
            }
            else{
                mas[i]=0;
            }
        }
        int sum=0;
        for (int j=0;j<mas.length;j++){
            sum=sum+mas[j];
        }
        if (n==sum){
            return true;
        }
        return false;
    }


    /*
    4.
    Создайте функцию, которая принимает строку и возвращает новую строку с заменой ее первого и последнего символов,
    за исключением трех условий:
    – Если длина строки меньше двух, верните "несовместимо".".
    – Если первый и последний символы совпадают, верните "два-это пара.".
     */
    public static void flipEndChars(String word){
        char[]mas=word.toCharArray();// Преобразование слова в чаровый массив
        if (word.length()<2){// Проверка условия меньше двух
            System.out.println("Несовместимо");
        }

        if (mas[0]==mas[mas.length-1]){ // Проверка два-это пара
            System.out.println("Два-это пара");
        }
        else {
            char A=mas[0]; // Присвоение первого элемента массива
          mas[0]=mas[mas.length-1];// Присвоение первому элементу последнего
          mas[mas.length-1]=A;// Присвоение последнего первому
          String str=new String(mas);// Присвоение измененной строки
            System.out.println(str);
        }
    }


    /*
    5.
    Создайте функцию, которая определяет, является ли строка допустимым шестнадцатеричным кодом.
    Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6 символов.
    Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F. все буквенные символы
    могут быть прописными или строчными.
     */
    public static boolean isValidHexCode(String hexcode){
        char[]mas=hexcode.toCharArray();
        char[]mas1={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','a','b','c','d','e','f'};
        for (int i=1;i< mas.length;i++){
            for (int j=0;j<mas1.length;j++){
                if ((mas[0]=='#')&&(hexcode.length()==6)&&(mas[i]==mas1[j])){// Проверка условий
                    return true;
                }
            }
        }
        return false;
    }


    /*
    6.
    Напишите функцию, которая возвращает true,
    если два массива имеют одинаковое количество уникальных элементов,
    и false в противном случае.
     */
    public static boolean same(int[]arr1,int[]arr2){
        int k=0;
        int s=0;
       for (int i=0;i<arr1.length;i++){
           for (int j=i+1;j<arr1.length;j++){
               if (arr1[i]==arr1[j]){//Сравнение соседних элементов массива
                  k=k+1;//Если уникальный, то счетчик увеличивается
                  i=j;//Если уникальный перепрыгиваем, чтобы избежать повторений

               }
           }
       }

        for (int i=0;i<arr2.length;i++){
            for (int j=i+1;j<arr2.length;j++){
                if (arr2[i]==arr2[j]){//Сравнение соседних элементов массива
                   s=s+1;//Если уникальный, то счетчик увеличивается
                   i=j;//Если уникальный перепрыгиваем, чтобы избежать повторений
                }
            }
        }
        return (arr1.length-k)==(arr2.length-s);
    }

    /*
    7.
	Число Капрекара-это положительное целое число, которое после возведения в квадрат и разбиения на две
	лексикографические части равно сумме двух полученных новых чисел:
    – Если количество цифр квадратного числа четное, то левая и правая части будут иметь одинаковую длину.
    – Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной половиной,
    а левая-самой маленькой или равной нулю, если количество цифр равно 1.
    – Учитывая положительное целое число n, реализуйте функцию, которая возвращает true,
    если это число Капрекара, и false, если это не так.
    */
    public static boolean isKaprekar(int n){
       if (n==1){
           return true;
       }
       int square=n*n; // 297*297(88209)
       int length=0;
       while (square!=0){
           length=length+1; // ищем длину числа, полученного возведением n в квадрат  (5)
           square=square/10; // убираем последнюю цифру
       }

       square=n*n; // (88209)восстанавливаем изначальное значение
        int left=((length+1)/2)-1;// формирование количества цифр левой части, которая меньше правой
        int right=left+1;//формирование кличества цифр правой части
        int leftsum=(int)(square%(int)Math.pow(10,right)); // выделение последних 3 цифр
        //System.out.println(leftsum);
        int rightsum=(int)(square/ (int)Math.pow(10,right));// выделение первых двух цифр
        //System.out.println(rightsum);
        int sum=leftsum+rightsum;// сложение двух частей
        //System.out.println(sum);
        if (sum==n){
            return true;
        }
        return false;
    }

    /*
    8.
    Напишите функцию, которая возвращает самую длинную последовательность последовательных нулей в двоичной строке.
    */
    public static void longestZero(String s){
        char N='0';
        int zero=0;
        int maxzero=0;
        for(int i=0;i<s.length();i++){
            if (N==s.charAt(i)){
                zero++;
                if (zero>maxzero){
                    maxzero=zero;
                }
            }
            else {
               zero=0;
            }

        }
        StringBuilder newString=new StringBuilder("");
        for(int i=0;i<maxzero;i++){
            newString.insert(i,'0');
        }
        System.out.println(newString);
    }

    /*
    9.
    Если задано целое число, создайте функцию, которая возвращает следующее простое число.
    Если число простое, верните само число.
     */
    public static boolean IsPrime(int n){
        for (int i=2;i<n;i++){ //Цикл от 2 до n
            if (n%i==0){ // Если n делится нацело на i
                return false;
            }
        }
        return true;
    }
    public static void nextPrime(int n){
       if (IsPrime(n)==true){
           System.out.println(n);
       }
       while (IsPrime(n)==false){
           n=n+1;
       }
        System.out.println(n);
    }

    /*
    10.
    Учитывая три числа, x, y и z, определите, являются ли они ребрами прямоугольного треугольника.
     */
    public static boolean rightTriangle(int a,int b,int c){
        int gipotenyza=0;
        if (a>b){
            gipotenyza=a;
        }
        else {
            gipotenyza=b;
        }
        if (gipotenyza>c){
            gipotenyza=gipotenyza;
        }
        else {
            gipotenyza=c;
        }
        if (gipotenyza==a){
            if (gipotenyza==Math.sqrt(b*b+c*c)){
                return true;
            }
        }
        if (gipotenyza==b){
            if (gipotenyza==Math.sqrt(a*a+c*c)){
                return true;
            }
        }
        if (gipotenyza==c){
            if (gipotenyza==Math.sqrt(b*b+a*a)){
                return true;
            }
        }
        return false;
    }
}
