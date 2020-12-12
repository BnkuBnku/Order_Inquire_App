/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueuePack;

/**
 *
 * @author Admin
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] elements;
    private int front;
    private int size;
    private int capacity;
    
    public ArrayQueue(){
        capacity = 10;
        elements = (E[]) new Object[capacity];
    }
    
    public ArrayQueue(int capacity){
        elements = (E[]) new Object[capacity];
    }
    
    @Override
    public E first() {
        return  elements[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E element) throws FullQueueException{
        if(size == capacity){
            throw new FullQueueException("Queue is full.");
        }
        
        int avail = (front + size) % capacity;
        elements[avail] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        
        E temp = elements[front];
        elements[front] = null;
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

   

   
}
