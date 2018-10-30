package com.suanfa;

/**
 * 汉诺塔算法
 *
 * @Author:zhou
 * @Create:2018/10/24 17:18
 */
public class LuoTa{
    /**
     * @Description //TODO
     * @Param [n:共有n个盘子, from:开始的柱子, in:中间的柱子, to:目标柱子]
     * @return void
     */
    public static void haoNi(int n,char from,char in,char to){
        if (n==1){
            System.out.println("第一个盘子从"+from+"移动"+to);
        }else {
            //移动上面盘子到中间位置
            haoNi(n-1,from,to,in);
            //移动下面的盘子
            System.out.println("第"+n+"个盘子"+from+"移动到"+to);
            //把上面所有盘子从中间位置移动到目标位置
            haoNi(n-1,in,from,to);

        }
    }

    public static void main(String[] args) {
        haoNi(3,'A','B','C');

    }
} 
