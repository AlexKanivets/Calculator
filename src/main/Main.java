package main;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String str = in.nextLine();
        parser.parse(str);
        int res = parser.result();
        if (rim.flag_rim){
            System.out.println(rim.arab_to_rim(res));
        }
        else {
            System.out.println(res);
        }
    }
}
