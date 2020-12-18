package modul1;
/*
В данном классе реализовано решение 10 задач из 1 модуля.
 */
public class Modul1 {
    public static void main(String[] args) {

        //System.out.println(ostatok(1,3));               //Для активации необходимо убрать комментарий
        //System.out.println(triArea(10,10));             //Для активации необходимо убрать комментарий
        //System.out.println(animals(5,2,8));             //Для активации необходимо убрать комментарий
        //System.out.println(profitableGamble(0.9,1,2));  //Для активации необходимо убрать комментарий
        //operation(2,2,1);                               //Для активации необходимо убрать комментарий
        //ctoa('л');                                      //Для активации необходимо убрать комментарий
        //addUpTo(7);                                     //Для активации необходимо убрать комментарий
        //System.out.println(nextEdge(9,2));              //Для активации необходимо убрать комментарий
        //System.out.println(sumOfCubes(3,4,5));          //Для активации необходимо убрать комментарий
        //System.out.println(abcmath(5,2,1));             //Для активации необходимо убрать комментарий
    }
    /*
    1.
         Функция метода ostatok возвращает отстаток от деления двух чисел
    */
    public static int ostatok(int a,int b) {
        int c=a%b;
        return c;
    }
    /*
    2.
        Функция метода triArea принимает основание и высоту треугольника и возвращает его площадь
     */
    public static double triArea(int a,int b){
        double S=1.0/2*a*b;
        return S;
    }
    /*
    3.
        Функция метода animals принимает количество животных(куриц, коров, свиней) и возвращет общее количество ног
        всех животных
    */
    public static int animals(int chikens,int cows,int pigs){
        int legs=(chikens*2)+(cows*4)+(pigs*4);
        return legs;
    }
    /*
    4.
        Функция метода profitableGamble принимает значения prob,prize,pay и при соблюдении условия prob*prize>pay
        возвращает true, в противном случае false
     */
    public static boolean profitableGamble(double prob,double prize,double pay){
        if (prob*prize>pay){
            return true;
        }
        return false;
    }
    /*
    5.
       Функция метода operation принимает значения a,b,c и вычисляет какое действие(сложение, вычитание, умножение, деление)
       можно совершить с числами b и c, чтобы в итоге получилось число a. В результате функция выдает словом арифметическую
       операцию, которая была совершена с числами или слово none, которое означает невозможность совершения вышеперечисленных
       операций.
    */
    public static void operation(double a, double b, double c){
        double added=b+c;
        double subtracted=b-c;
        double multiplication=b*c;
        double division=b/c;

        if (a==added){
            System.out.println("added");
        }
        if (a==subtracted){
            System.out.println("subtracted");
        }
        if (a==multiplication){
            System.out.println("multiplication");
        }
        if (a==division){
            System.out.println("division");
        }
        if ((a!=added)&&(a!=subtracted)&&(a!=multiplication)&&(a!=division)){
            System.out.println("none");
        }
    }
    /*
    6.
        Функция метода ctoa принимает любой символ из кодировки ascii и выдает его десятичное значение из таблицы
        кодирования.
     */
    public static void ctoa(char A){
        System.out.println((int)A);
    }
    /*
    7.
        Функция метода addUpTo принимает число n и возвращает сумму целых чисел, которые ему предшествовали
        (включая само число)
    */
    public static double addUpTo(int n){
        int sum=0;
        for (int i=0;i<=n;i++){
            sum=i+sum;
        }
        System.out.println(sum);
        return sum;
    }
    /*
    8.
       Функция метода nextEdge принимает стороны треугольника a и b и возвращает максимально возможную длину
       третьей стороны треугольника.
    */
    public static int nextEdge(int a,int b){
        int c=(a+b)-1;
        return c;
    }
    /*
    9.
       Функция метода sumOfCubes принимает числа a,b,c и возвращает сумму кубов каждого числа.
    */
    public static double sumOfCubes(int a,int b,int c){
        double cubesum=Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3);
        return cubesum;
    }
    /*
    10.
      Функция метода abcmath принимает числа a,b,c и отвечает (true or false) делится ли сумма числа a,
      умноженная b на число c.
    */
    public static boolean abcmath(int a,int b,int c){
        int s=a;
        int sum=0;
        for (int i=0;i<b;i++){
            sum=2*s;
            s=sum;
        }
        if (sum%c==0){
            return true;
        }
        return false;
    }
}
