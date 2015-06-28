package com.anyonecan.tal.drawgame;

public class Page {
    private Class previous;
    private Class next;

    Page(Class prev, Class next) {
        this.previous = prev;
        this.next = next;
    }

    public Class getPrevious() {
        return previous;
    }

    public Class getNext() {
        return next;
    }
}
