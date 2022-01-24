package org.lumenk.romeonavigation;

import org.lumenk.romeonavigation.utils.RomeoQueue;

public class Test {
    public static void main(String[] args) {
        RomeoQueue<Integer> queue = new RomeoQueue<>();
        queue.enqueue(1);
        System.out.println(queue.dequeue());

        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
