package com.tasks3.linkedlist;

public class LinkedList {
    private Node root;

    public LinkedList() {

    }

    public void add(Integer data) {
        if (this.root == null) {
            this.root = new Node();
            this.root.setData(data);
            return;
        } else {
            Node nextEl = this.root;
            while (nextEl.getNext() != null) {
                nextEl = nextEl.getNext();
            }
            nextEl.setNext(new Node());
            nextEl.getNext().setData(data);
        }
    }


    public Integer get(int index) {
        if(index < 0 || index >=this.size())
            return null;
        Node nextEl = this.root;
        for(int i=0;i<index;i++){
            nextEl = nextEl.getNext();
        }
        return nextEl.getData();

    }

    public boolean delete(int index) {
        if(index < 0 || index >=this.size())
            return false;
        if(index>0){
            Node nextEl = this.root;
            for(int i=0;i<index-1;i++){
                nextEl = nextEl.getNext();
            }
            nextEl.setNext(nextEl.getNext().getNext());
            return true;
        }
        else{
            this.root = this.root.getNext();
            return true;
        }

    }


    public int size() {
        if(this.root==null)
            return 0;
        Node nextEl = this.root;
        int size = 1;
        while (nextEl.getNext() != null) {
            nextEl = nextEl.getNext();
            size++;
        }
        return size;
    }

    class Node{
        private Node next;
        private Integer data;

        public Node() {
        }

        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Integer getData() {
            return data;
        }
        public void setData(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(45);
        list.add(55);
        list.add(65);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.get(5));
        list.delete(4);
        System.out.println(list.get(4));
        System.out.println(list.size());
    }
}
