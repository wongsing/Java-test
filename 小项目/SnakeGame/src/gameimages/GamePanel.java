package gameimages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
GamePanel 继承了jPanel以后，才具备面板功能,才成为面板
 */
public class GamePanel extends JPanel {
    //定义两个数组
    //蛇的长度
    int length;
    //一个数组，专门储存蛇的x坐标
    int[] snakeX = new int[200];
    //一个数组，专门储存蛇的y坐标
    int[] snakeY = new int[200];
    //游戏只有两个状态：开始、暂停
    boolean isStart = false;//默认游戏是暂停结果
    //加入一个定时器
    Timer timer;
    //定义蛇的行走方向
    String direction;
    //定义食物的x,y坐标
    int foodX , foodY;
    //定义一个积分
    int score;
    //加入一个变量判定小蛇死亡状态
    boolean isDie = false;//默认小蛇没死
    public void init()
    {
        //初始化蛇长度
        length = 3;
        //初始化蛇头坐标
        snakeX[0] = 175;
        snakeY[0] = 275;
        //初始化第一节身子
        snakeX[1] = 150;
        snakeY[1] = 275;
        //初始化第二节身子
        snakeX[2] = 125;
        snakeY[2] = 275;
        //初始化蛇头方向
        direction = "R"; //U D R L
        //初始化食物的坐标
        foodX = 200;
        foodY = 300;
    }
    public GamePanel()
    {
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {    //监听键盘按键的按下操作
                super.keyPressed(e);
                int keyCode= e.getKeyCode();
                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_SPACE){//监听空格
                    if (isDie){
                        //全部恢复到初始化状态
                        init();
                        isDie = false;
                    }
                    else {
                        isStart = !isStart;
                        repaint();  //重绘，调用paintComponent
                    }

                }
                //监听向上箭头
                if (keyCode == KeyEvent.VK_UP){
                    direction = "U";
                }
                //监听向下箭头
                if (keyCode == KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //监听向左箭头
                if (keyCode == KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //监听向右箭头
                if (keyCode == KeyEvent.VK_RIGHT){
                    direction = "R";
                }
            }
        });
        //对定时器进行初始化工作
        timer = new Timer(100, new ActionListener() {
            /*ActionListener 事件监听
            相当于每100ms监听一下是否发生了一个动作
            具体的动作加入actionPerformed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && isDie == false){//游戏是开始状态时并且小蛇活着，蛇才动；
                    //后一节身子走到前一节身子的位置
                    for (int i = length - 1;i>0;i--)
                    {
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }
                    //动头
                    if ("R".equals(direction)){
                        snakeX[0] += 25;
                    }
                    if ("L".equals(direction)){
                        snakeX[0] -= 25;
                    }
                    if ("U".equals(direction)){
                        snakeY[0] -= 25;
                    }
                    if ("D".equals(direction)){
                        snakeY[0] += 25;
                    }

                    //防止蛇超出边界
                    if (snakeX[0] > 750)
                    {
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 25)
                    {
                        snakeX[0] = 750;
                    }
                    if (snakeY[0] <100)
                    {
                        snakeY[0] = 725;
                    }
                    if (snakeY[0] >725)
                    {
                        snakeY[0] = 100;
                    }
                    //检测碰撞动作
                    //食物坐标和蛇头坐标一致
                    if (snakeX[0]==foodX && snakeY[0] == foodY)
                    {
                        //蛇长+1
                        length++;
                        /*食物坐标改变:随机生成坐标-->细节：必须是25的倍数
                        [25,750]-->[1,30]*25
                        Math.random()-->[0.0,1.0)
                        Math.random()*30-->[0.0,30.0]
                        (int)Math.random()*30-->[0,29]
                        (int)Math.random()*30 +1 -->[1,30]
                         */
                        foodX =((int)Math.random()*30 +1) *25  ; //[25,750]
                        /*
                        [100,750] --> [4,29] * 25
                        [4,29] ->[0,25]+4
                        [0,25]
                        new Random().nextInt(26) ->[0,26) ->[0,25]
                         */
                        foodY = (new Random().nextInt(26)+4)*25;  //[100,725]
                        //吃上食物以后，积分加10分
                        score += 10;
                    }
                    //死亡判定:蛇头和任意一节身体碰撞都是死亡
                    for (int i = 1; i < length; i++)
                    {
                        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i])
                            //设置死亡状态
                            isDie = true;
                    }
                    repaint() ;//重绘
                }
            }
        });
        //定时器必须要启动
        timer.start();
    }
    /*
    paintComponent方法属于图形版的main方法
    自动调用
     */
    protected void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        //填充背景颜色
        this.setBackground(new Color(169, 205, 169));
        //画头部图片
        /*
        paintIcon四个参数，this指的是当前面板，g：使用的画笔，x，y对应的坐标
         */
        Images.headerImg.paintIcon(this,g,10,10);
        //调节画笔颜色
        g.setColor(new Color(0xD4D4D0));
        //画一个矩形
        g.fillRect(10,70,770,685);

        //画小蛇
        //画蛇头

        if ("R".equals(direction))
        {
            Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if ("L".equals(direction))
        {
            Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if ("U".equals(direction))
        {
            Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if ("D".equals(direction))
        {
            Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        /*
        //画第一节身子
        Images.bodyImg.paintIcon(this,g,snakeX[1],snakeY[1]);
        //画第二节身子
        Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);
         */
        //优化为循环画蛇身子
        for (int i = 1;i <length;i++)
        {
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //如果游戏暂停，界面中间要有句提示语
        if (isStart == false)
        {
            //画一个文字
            g.setColor(new Color(144,98,255));
            //三个参数：字体，加粗，字号
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //三个参数：文字内容，x坐标，y坐标
            g.drawString("点击空格开始游戏",250,330);
        }

        //画食物
        Images.foodImg.paintIcon(this,g,foodX,foodY);

        //画积分
        g.setColor(new Color(244, 244, 245));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分："+score,640,40);

        //画死亡状态
        if (isDie)
        {
            g.setColor(new Color(39, 196, 39));
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.drawString("小蛇死亡，游戏停止，按下空格重新开始游戏",200,330);
        }

    }
}
