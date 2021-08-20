package main;
public class parser {

    static int num1,num2;
    static char operator;
    static char[] arr ={'/','+','*','-'};

    static char[] ch;
    static String str1="";
    static String str2="";
    public static int result(){
        switch (operator){
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
        }
        return 1;
    }

    public static void parse(String str){
        ch = str.toCharArray();
        int flag = 0;
        for(int i = 0; i<ch.length;i++){
            for(int j=0;j<arr.length;j++){
                if (ch[i] == arr[j]) {
                    flag++;
                }
            }
        }
        try{
           if (flag > 1 || flag == 0) throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
       }
       catch (Exception ex) {
           System.out.println(ex.getMessage());
           System.exit(1);
       }
        for(int i =0;i< str.length();i++){
            for(int j = 0; j<4;j++){
                if(ch[i]==arr[j]){
                    operator = ch[i];
                    for(int u=0;u<str.length();u++){
                        if(u==i) continue;
                        if(u<i){
                            str1+=ch[u];
                            str1 = str1.replaceAll("\\s+","");
                        }else {
                            str2+=ch[u];
                            str2 = str2.replaceAll("\\s+","");
                        }
                    }
                    if(!rim.is_rim(str1) && !rim.is_rim(str2)) {//точно не римское
                        try{
                            int num = Integer.parseInt(str1);
                            num = Integer.parseInt(str2);
                        }catch (Exception e){
                            System.out.println("throws Exception //т.к. один из операндов не удовлетворяет условию");
                            System.exit(1);
                        }

                        num1 = Integer.parseInt(str1);
                        num2 = Integer.parseInt(str2);
                        try {
                            if (num1 > 10 || num1 < 1 ||
                                    num2 > 10 || num2 < 1) {
                                throw new Exception("throws Exception //т.к. один из операндов не удовлетворяет условию (1<=x<=10)");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.exit(1);
                        } //от 1 до 10
                       //
                    }else if(rim.is_rim(str1) && rim.is_rim(str2)){
                        num1 = rim.rim_to_arab(str1);
                        num2 = rim.rim_to_arab(str2);
                    } else {
                        System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                        System.exit(1);
                    }
                }
            }
        }
    }
}
