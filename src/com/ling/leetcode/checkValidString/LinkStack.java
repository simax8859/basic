package com.ling.leetcode.checkValidString;

/**
 * @ClassName LinkStack
 * @Deacription TODO
 * @Author ljxia
 * @Date 2019/05/28 9:21
 * @Version 1.0
 **/
public class LinkStack<E> {
    //链栈的节点
    class Node<E>{
        E e;
        Node<E> next;

        public Node(){}
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
    }
    //栈顶元素
    private Node<E> top;
    //当前栈大小
    private int size;

    public LinkStack(){
        top = null;
    }

    //当前栈大小
    public int length(){
        return size;
    }

    //判空
    public boolean empty(){
        return size==0;
    }

    //入栈：让top指向新创建的元素，新元素的next引用指向原来的栈顶元素
    public boolean push(E e){
        top = new Node(e,top);
        size ++;
        return true;
    }

    //查看栈顶元素但不删除
    public Node<E> peek(){
        if(empty()){
            throw new RuntimeException("空栈异常！");
        }else{
            return top;
        }
    }

    //出栈
    public Node<E> pop(){
        if(empty()){
            throw new RuntimeException("空栈异常！");
        }else{
            //得到栈顶元素
            Node<E> value = top;
            //让top引用指向原栈顶元素的下一个元素
            top = top.next;
            //释放原栈顶元素的next引用
            value.next = null;
            size --;
            return value;
        }
    }
}
