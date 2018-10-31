package com.suanfa;

/**
 * 单链表测试
 *
 * @Author:zhou
 * @Create:2018/10/31 21:49
 */
public class TestNode{
    public static void main(String[] args) {
        //创建节点
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        //追加节点
        n1.append(n2);
        n1.append(n3);
        n1.append(n4);
        //取出下一个节点
        System.out.println(n1.next().next().next().getData());
        System.out.println(n1.next().next().next().next().isLast());

    }

}
