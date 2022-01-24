package org.lumenk.romeonavigation.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RomeoQueue<Type> {

    private Node front = null;
    private Node rear = null;
    private int count = 0;

    public RomeoQueue() {
    }

    public void enqueue(@NotNull Type in){
        Node temp = new Node();
        temp.data = in;

        if(front == null){
            front = temp;
            //front.link = temp;
        }else{
            rear.link = temp;
        }

        rear = temp;
        count++;
    }

    @Nullable
    public Type dequeue(){
        if(count == 0)return null;
        Type result = front.data;
        front = front.link;
        count--;
        if(count == 0)rear = null;
        return result;
    }

    public int getCount() {
        return count;
    }

    private class Node{
        Type data = null;
        Node link = null;
    }
}
