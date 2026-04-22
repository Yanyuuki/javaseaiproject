package com.yanyuuki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//自定义窗口类，创建对象，展示一个主窗口
public class MainFrame extends JFrame {

    //设置图片位置
    private static final String IMAGE_PATH="stone-maze/src/image/";

    //准备一个数组，用户存储数字色块的行列位置：4*4
    private int[][] imageData={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    private final int[][] winData={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //定义两个整数变量，记录当前空白色块的位置
    private int whiteRow;//行
    private int whiteCol;//列
    private int count=0;//记录移动的步数

    public MainFrame() {
        //1.调用一个初始化方法，初始化窗口大小等信息
        initFrame();
        //4.打乱数字色块的顺序，再展示图片
        initRandomImage();
        //2.初始化界面，展示数字色块
        initImage();
        //3.初始化系统菜单，点击弹出菜单信息是系统退出没重启游戏
        initMenu();
        //5.给当前窗口绑定上下左右按键实现
        initKeyPressEvent();
        //设置窗口的显示
        this.setVisible(true);
    }

    private void initKeyPressEvent() {
        //监听键盘按键给绑定的按键添加事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                //获取按键的键值
                int keyCode=e.getKeyCode();
                //根据键值判断按键类型
                switch (keyCode){
                    case KeyEvent.VK_LEFT:
                        switchAndMove(Direction.LEFT);
                        break;
                    case KeyEvent.VK_UP:
                        switchAndMove(Direction.UP);
                        break;
                    case KeyEvent.VK_RIGHT:
                        switchAndMove(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_DOWN:
                        switchAndMove(Direction.DOWN);
                        break;
                }
            }
        });
    }

    private void switchAndMove(Direction r){
        //判断图片的方向，在控制图片移动
        switch (r){
            case UP:
                //上交换的条件是行必须<3
                if(whiteRow<imageData.length-1){
                    //交换
                    int temp=imageData[whiteRow][whiteCol];
                    imageData[whiteRow][whiteCol]=imageData[whiteRow+1][whiteCol];
                    imageData[whiteRow+1][whiteCol]=temp;
                    //更新空白色块的位置
                    whiteRow++;
                    //重新展示图片
                    count++;
                }
                break;
            case DOWN:
                //下交换的条件是行必须>0
                if(whiteRow>0){
                    //交换
                    int temp=imageData[whiteRow][whiteCol];
                    imageData[whiteRow][whiteCol]=imageData[whiteRow-1][whiteCol];
                    imageData[whiteRow-1][whiteCol]=temp;
                    //更新空白色块的位置
                    whiteRow--;
                    //重新展示图片
                    count++;
                }
                break;
            case LEFT:
                //左交换的条件是列必须<3
                if(whiteCol<imageData[0].length-1){
                    //交换
                    int temp=imageData[whiteRow][whiteCol];
                    imageData[whiteRow][whiteCol]=imageData[whiteRow][whiteCol+1];
                    imageData[whiteRow][whiteCol+1]=temp;
                    //更新空白色块的位置
                    whiteCol++;
                    //重新展示图片
                    count++;
                }
                break;
            case RIGHT:
                //右交换的条件是列必须>0
                if(whiteCol>0){
                    //交换
                    int temp=imageData[whiteRow][whiteCol];
                    imageData[whiteRow][whiteCol]=imageData[whiteRow][whiteCol-1];
                    imageData[whiteRow][whiteCol-1]=temp;
                    //更新空白色块的位置
                    whiteCol--;
                    //重新展示图片
                    count++;
                }
                break;
        }
        initImage();
    }

    private void initRandomImage() {
        //打乱二维数组中的元素顺序
        //随机两个行列位置，让这两个位置交换
        for(int i=0;i<100;i++){
            int x1=(int)(Math.random()*4);
            int y1=(int)(Math.random()*4);
            int x2=(int)(Math.random()*4);
            int y2=(int)(Math.random()*4);
            //交换
            int temp=imageData[x1][y1];
            imageData[x1][y1]=imageData[x2][y2];
            imageData[x2][y2]=temp;
        }
        //定位空白色块的位置
        //去二维数组中遍历每个数据，只要发现这个数据等于0
        OUT:
        for(int i=0;i<imageData.length;i++){
            for(int j=0;j<imageData[i].length;j++){
                if(imageData[i][j]==0){
                    whiteRow=i;
                    whiteCol=j;
                    break OUT;
                }
            }
        }
    }

    private void initMenu() {
        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("系统");
        JMenuItem exitJi=new JMenuItem("退出");
        menu.add(exitJi);
        exitJi.addActionListener(e -> {
            dispose();//销毁
            System.exit(0);
        });
        JMenuItem restartJi=new JMenuItem("重启");
        menu.add(restartJi);
        restartJi.addActionListener(e -> {
            count=0;//重置步数
            dispose();
            new MainFrame();
            //重启游戏
        });
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    private void initImage() {
        //先清空窗口上的全部图层
        this.getContentPane().removeAll();

        //刷新页面时展示步数
        //给窗口添加一个显示文字的组件
        JLabel countTxt=new JLabel("当前步数："+count);
        countTxt.setBounds(20,20,100,20);
        //文字展示成红色
        countTxt.setForeground(Color.RED);
        //加粗
        countTxt.setFont(new Font(null,Font.BOLD,12));
        this.add(countTxt);

        //判断是否赢了
        if(isWin()){
            JLabel win=new JLabel();
            win.setIcon(new ImageIcon(IMAGE_PATH+"win.png"));
            win.setBounds(124,260,266,88);
            this.add(win);
        }
        //1.展示一个行列矩阵的图片色块，一次铺满窗口（4*4）
        for(int i=0;i<imageData.length;i++){
            for(int j=0;j<imageData[i].length;j++){
                //拿到图片名称
                String imageName=imageData[i][j]+".png";
                //2.创建一个JLabel对象，展示图片
                JLabel label=new JLabel();
                //3.设置图片
                label.setIcon(new ImageIcon(IMAGE_PATH+imageName));
                //4.把JLabel对象添加到窗口中
                label.setBounds(23+j*100,60+i*100,100,100);
                //5.添加到窗口中
                this.add(label);
            }
        }
        //设置窗口的背景图片
        JLabel background=new JLabel(new ImageIcon(IMAGE_PATH+"background.png"));
        background.setBounds(0,0,450,484);
        this.add(background);

        //刷新图层，重新绘制
        this.repaint();
    }

    private boolean isWin() {
        for(int i=0;i<imageData.length;i++){
            for(int j=0;j<imageData[i].length;j++){
                if(imageData[i][j]!=winData[i][j]){
                    return false;
                }
            }
        }
        //如果循环结束，没有返回false，则表示游戏胜利
        return true;
    }

    private void initFrame() {
        //初始化窗口标题
        this.setTitle("stone-maze");
        //设置窗口宽高
        this.setSize(465,575);
        //设置窗口关闭方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口的居中显示
        this.setLocationRelativeTo(null);
        //设置布局方式为绝对位置定位
        this.setLayout(null);

    }

    public int[][] getWinData() {
        return winData;
    }
}
