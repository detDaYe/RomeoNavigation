package org.lumenk.romeonavigation.datastructures;

import org.jetbrains.annotations.Nullable;

public class RomeoStack <Type>{

    private Node top = null;
    private int count = 0;

    public RomeoStack() {
    }

    @Nullable
    public Type pop(){
        if(top == null) return null;
        Type temp = top.data;
        top = top.link;
        count--;
        return temp;
    }


    public void push(Type data){
        top = new Node(data, top);
        count++;
    }


    public int getCount() {
        return count;
    }

    private class Node{
        Type data = null;
        Node link = null;

        public Node(Type data, Node link) {
            this.data = data;
            this.link = link;
        }
    }
}
