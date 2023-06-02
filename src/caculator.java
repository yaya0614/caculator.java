import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
public class caculator extends JFrame implements ActionListener {

    //類似群組，一區塊聚集元件的面板
    JPanel jPanel2 = new JPanel();
    JPanel jPanel1 = new JPanel();
    String[] btnNmae = {"AC","%","^","√","π","㏒","e","+","9","8","7","-","6","5","4","*","3","2","1","/","0",".","="};
    Double num1,num2,sum ;
    String Firstnum,operator ;
    JTextArea jTextArea = new JTextArea();
    public caculator() //建構函式，此不需帶任何參數，Java已經寫好初始化物件用的
    {
        setTitle("工程計算機");
        // 設置顏色
        getContentPane().setBackground(Color.gray);
        this.setSize(250, 330);
        jTextArea.setFont(new Font("hello",Font.BOLD,25));
        jPanel1.add(jTextArea);

        jPanel2.setLayout(new GridLayout(6,3));
        //透過for建立btnNmae中的所有btn物件
        for (int i = 0; i < btnNmae.length; i++) {
            JButton jButton = new JButton();
            //.setText來賦予btnName的顯示值
            jButton.setText(btnNmae[i]);
            //將btn加入事件觸發中
            jButton.addActionListener(this::actionPerformed);

            //每生成的btn都須放入jPlanel2中
            jPanel2.add(jButton);
        }
        this.setLayout(new GridLayout(2,1));

        this.add(jPanel1);
        this.add(jPanel2);

        setVisible(true);
    }

    //按鈕觸發事件fun()
    public void actionPerformed(ActionEvent event){
        //getActionCommand取得btn上的值，getActionCommand() 的回傳值 (return value) 為 String 型態 (type) 的字串物件 (object) ，不需要參數 (paramenter) 。
        // getSource取的此Button

        //取得按鈕值得狀況
        String clikc = event.getActionCommand();
        //清空的部分

        if ("AC".equals(clikc)){
            this.jTextArea.setText("");
            System.out.println(1);
        }

        else if(".0123456789".indexOf(clikc)!=-1){
            this.jTextArea.setText(jTextArea.getText()+clikc);
            System.out.println(2);
        }
            //利用MARCHER.MATCH（）對比字串是否符合regex
            //regex = regular expression，用來分割字元間的不同 1個\在java中須以\\做分割
        else if(clikc.matches("[+\\-*%./eπ^㏒√]{1}")){
            operator = clikc;
            Firstnum = this.jTextArea.getText();
            System.out.println(3);

            //只在需要兩個變數的地方做清除
            if (clikc.matches("[+\\-*%./^]{1}")) {
                this.jTextArea.setText("");
                System.out.println(4);

            }
        }
           //当点到等号的操作
        else if(clikc.equals("=")) {
            num1 = Double.valueOf(Firstnum);
            num2 = Double.valueOf(this.jTextArea.getText());
            switch (operator) {
                case "+" -> {
                    sum = num1 + num2;
                }
                case "*" -> {
                    sum = num1 * num2;
                }
                case "/" -> {
                    if (num2 != 0)
                        sum = num1 / num2;
                }
                case "%" -> {
                    if (num2 != 0)
                        sum = num1 % num2;
                }
                case "-" -> {
                    sum = num1 - num2;
                }
                case "e" -> {
                    Double a = Math.E;
                    sum = num1 * a;
                }
                case "π" -> {
                    Double pi = Math.PI;
                    //去到小數點第4位 ＿ Math.round()用來做四捨五入
                    Double count_pi = Math.round(pi*10000.0)/10000.0;
                    System.out.println(count_pi);
                    sum = num1 * count_pi;
                }
                case "^" -> {
                    sum = Math.pow(num1,num2);
                }
                case "㏒" -> {
                    sum = Math.pow(num1,num2);
                }
                case "√" -> {
                    sum = Math.sqrt(num1);
                }
            }

            System.out.println("我是："+sum);

            this.jTextArea.setText(subZeroAndDot(sum.toString()));
            //做一個如果小數點第一位為0則遮沒
            //設定做多到小數點第2位
        }

    }

    //去掉.後的0
    public static String subZeroAndDot(String a){
        if(a.indexOf(".") > 0){
            a = a.replaceAll("0+?$", "");//去掉多餘的0
            a = a.replaceAll("[.]$", "");//如最後一位是.則去掉
        }
        return a;
    }

    public static void main(String[] args) {
        new caculator();
    }

}

