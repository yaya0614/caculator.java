import java.util.regex.Matcher;
import java.util.regex.Pattern;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class Student{
    String name;
    int age;
     Student(String str,int age1){ //建構子，初始化物件內容
        age = age1;
        name = str;
    }
    public void show(int age,String str){
         System.out.println("年紀 "+age +" "+"姓名 "+str);
    }

}
public class Main {
    public static boolean isNumeric(String str) {
        if (str == null) {
            System.out.println("false");
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
    public static void main(String[] args) {
//        Student student = new Student("lawm",30);
//        student.show(20,"ario");
//        String str2 = "39.00";

//        for (int i = 0; i < str2.length(); i++) {
//            System.out.println();
//        }
//
//        String str = null;
//        String str4 = "78.90";
//        String[] tokens = str4.split("\\.");
//        for (String token:tokens) {
//            System.out.println(token);
//            System.out.println(token.charAt(0));
//            if (token.charAt(0)==0){
//                str ="0";
//            }else {
//                str = "1";
//            }
//        }

        Float f = 1f;
        Double a1 = 9.077;
        Double a2 = 9.900;
        System.out.println(a1.toString());//1.0
        System.out.println(subZeroAndDot(a1.toString()));; // 轉換後為1
        System.out.println(subZeroAndDot(a2.toString()));; // 轉換後為10
        System.out.println(subZeroAndDot("1.0"));; // 轉換後為1
        System.out.println(subZeroAndDot("1.010"));; // 轉換後為1.01
        System.out.println(subZeroAndDot("1.01"));; // 轉換後為1.01
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多餘的0
            s = s.replaceAll("[.]$", "");//如最後一位是.則去掉
        }
        return s;
    }

//        System.out.printf("e 的值为 %.4f%n", Math.E);
//        System.out.printf("log(%.3f) 为 %.3f%n", x1, Math.log(x1));
//        double random = Math.random();
//        System.out.println(random);
//        Double a = 9.567;
//        double roundOff = Math.round(a * 100.0) / 100.0;
//        System.out.printf("%.2f",random);
//        String testString3 = "0911-111111, 02-22222222, 0922-222222, 03-33333333";
//        Pattern pattern = Pattern.compile("\\d{4}-\\d{6}");
//        Matcher matcher = pattern.matcher(testString3);
//        while (matcher.find()) {
//            System.out.println("matcher.group():\t"+matcher.group());
//        }
//        System.out.println("\\");
}
