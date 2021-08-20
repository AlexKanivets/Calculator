package main;

public class rim{
    static boolean flag_rim = false;

    public static boolean is_rim(String str){
        switch (str){
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X": flag_rim=true; return true;
            default: return false;
        }
    }

    public static int rim_to_arab(String str) {
        int num = 0;
        switch (str){
            case "I": num = 1;break;
            case "II": num = 2;break;
            case "III": num = 3;break;
            case "IV": num = 4;break;
            case "V": num = 5;break;
            case "VI": num = 6;break;
            case "VII": num = 7;break;
            case "VIII": num = 8;break;
            case "IX": num = 9;break;
            case "X": num = 10;break;
        }
        return num;
    }
    public static String arab_to_rim(int number) {
        try {
            if (number <= 0) {
                throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел и 0");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        int[] rim_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rim_char_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < rim_list.length; i += 1) {
            while (number >= rim_list[i]){
                number -= rim_list[i];
                res.append(rim_char_list[i]);
            }
        }
        return res.toString();
    }
}
