package com.cz.demo.test;

/**
 * Created 2020/4/8. 4:08 下午
 *
 * @author changzheng
 */
public class Demo1 {
    private  static  Demo1 single = new Demo1();

    private Demo1(){
    }

    public static Demo1 getDemo1(){
        return single;
    }

    public int search(int[]a,int l,int r,int key){
        if (a.length == 0|| key<a[l] || key>a[r] ||l>r){
            return  -1;
        }
        int length = a.length;
        int low=l ,high = r;
        int middle = (low+high)/2;
        if (a[middle]>key){
            return search(a,low,middle-1,key);
        }else if ((a[middle]<key)){
            return search(a,middle+1,high,key);
        }else {
            return middle;
        }
    }

    public static  Node reverse(Node root){
        if(root==null){
            return null;
        }
        Node head = new Node(0);
        Node p = head;
        Node q;
        while (true){
            if (p==null){
                break;
            }
            q = root.next;
            p.next=head.next;
            head.next=p;
            p=q;
        }
        return head.next;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node head1 = new Node(2);
        Node head2 = new Node(3);
        head.next=head1;
        head1.next=head2;
        head2.next=null;
        System.out.println(reverse(head).value);

    }

}
