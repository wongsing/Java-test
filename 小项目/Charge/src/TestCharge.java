import java.util.Scanner;

public class TestCharge {
    public static void main(String[] args) {
        //定义一个字符串，用来接收整个收支功能
        String details = "";
        //定义一个变量，接收余额，初始化为0
        int balance = 0;
        while (true){
        System.out.println("-------欢迎使用记账小助手！！！！-------");
        System.out.println("1.收支明细");
        System.out.println("2.登记收入");
        System.out.println("3.登记支出");
        System.out.println("4.退出");
        System.out.println("请将输入要选择的功能：");
        //得到一个扫描器
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        //对录入的choice做一个过滤
        while (choice !=1&&choice!=2&&choice!=3&&choice!=4)
        {
            System.out.println("对不起，你录入的功能错误，请重新输入:");
            int newChoice = sc.nextInt();
            choice = newChoice;
        }
        //根据录入数学，判断选择功能
        switch (choice){
                case 1 : System.out.println("记账小助手-----收支明细:");
                        //如果直接输出details，最后多了一个换行
                         //System.out.println(details);
                        //截取字符串
                        //String s = details.substring(0,details.length()-1);
                    if (details !=""){
                        System.out.println(details.substring(0,details.length()-1));
                    }else{
                        System.out.print(details);
                    }
                         break;
                case 2 : System.out.println("记账小助手-----登记收入:");
                         System.out.println("请录入收入金额：");
                         int income = sc.nextInt();
                         System.out.println("请录入收入说明：");
                         String incomeDetail = sc.next();
                         balance += income;
                         details = details + "收入：" + income + ",收入说明："+incomeDetail+",账户余额：" + balance+"\n";
                         break;
                case 3 : System.out.println("记账小助手-----登记支出:");
                         System.out.println("请录入支出金额：");
                         int expend = sc.nextInt();
                         System.out.println("请录入支出说明：");
                         String expendDetail = sc.next();
                         balance -= expend;
                         details = details + "收入：" + expend + ",收入说明："+expendDetail+",账户余额：" + balance+"\n";
                         break;
                case 4 : System.out.println("记账小助手-----退出功能");
                         System.out.println("确定要退出吗？Y/N");
                         String isExit = sc.next();
                         switch (isExit){
                             case "Y" :
                                 System.out.println("系统已退出，欢迎下次使用");
                                 return;
                         }

            }
        }

    }
}
