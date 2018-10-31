package com.suanfa;

/**
 * 单链表
 *
 * @Author:zhou
 * @Create:2018/10/31 21:47
 */
//一个节点
public class Node{
    //节点内容
    int data;
    //下一个节点
    Node next;
    public Node(int data){
     this.data=data;
    }
    //为节点追加节点
    public void append(Node node){
        //当前节点
        Node currentNode=this;
        //循环向后找
        while (true){
            //取出下一个节点
            Node nextNode=currentNode.next;
            //如果下一个节点为null,当前节点已经是最后一个节点
            if (nextNode==null){
                break;
            }
            //赋值给当前节点
            currentNode=nextNode;
        }
        //把需要追加的节点追加为找到的当前节点的下一个节点
        currentNode.next=node;
    }
    //获取下一个节点
    public Node next(){
        return this.next;
    }
    //获取节点中的数据
    public int getData(){
        return this.data;
    }
    //当前节点是否是最后一个节点
    public boolean isLast(){
        return next==null;
    }

} 
