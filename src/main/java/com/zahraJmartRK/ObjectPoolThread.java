package com.zahraJmartRK;

import java.util.Vector;
import java.util.function.Function;
import java.lang.Object;
/*
public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal;
    private Vector<T> objectPool;
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine){
        super(name);
        this.routine = routine;
    }
    public ObjectPoolThread(Function <T, Boolean> routine){
        this.routine = routine;
    }

    public synchronized void add(T object){
        objectPool.add(object);
        this.notify();
    }
    public synchronized void exit(){
        exitSignal = true;
    }
    @Override
    public void run(){
        while(!exitSignal){
            try{
                synchronized(this){
                    System.out.println("i");
                    for(T t : objectPool){
                        routine.apply(t);
                    }
                    try{
                        this.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public int size(){
        return objectPool.size();
    }
}


import java.lang.Object;
        import java.util.Vector;
        import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread
{
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector <>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine){
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread(Function <T, Boolean> routine){
        this.routine = routine;
    }

    public int size(){
        return objectPool.size();
    }

    public synchronized void add(T object){
        objectPool.add(object);
        this.notify();
    }

    public synchronized void exit(){
        exitSignal = true;
        super.notify();
    }

    @Override
    public void run(){
        while(true){
            synchronized(this) {
                while(objectPool.isEmpty() && !exitSignal) {
                    try {
                        super.wait();
                    }
                    catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(exitSignal) {
                    break;
                }
            }
            for(int i=0; i<objectPool.size();++i) {
                if(routine.apply(objectPool.get(i))) {
                    objectPool.set(i, null);
                }
            }
            objectPool.removeIf(obj -> obj==null);
        }
    }
}
*/


public class ObjectPoolThread<T> extends Thread {
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector<>();
    private Function<T, Boolean> routine;

    public ObjectPoolThread(String name, Function<T, Boolean> routine) {
        super(name);
        this.routine = routine;
    }

    public ObjectPoolThread(Function<T, Boolean> routine) {
        this.routine = routine;
    }

    public synchronized void add(T object) {
        objectPool.add(object);
        super.notify();
    }

    public synchronized void exit() {
        exitSignal = true;
        super.notify();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (objectPool.isEmpty() && !exitSignal) {
                    try {
                        super.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (exitSignal) {
                    break;
                }
            }

            for (int i = 0; i < objectPool.size(); ++i) {
                if (routine.apply(objectPool.get(i))) {
                    objectPool.set(i, null);
                }
            }

            objectPool.removeIf(obj -> obj == null);
        }
    }

//    public int size() { }

}