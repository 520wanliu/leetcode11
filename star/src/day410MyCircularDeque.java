/**
 * @ClassName day410MyCircularDeque
 * @Description TODO
 * @Author 橙子
 * @Date 2022-04-10 13:46
 * @Version 1.0
 */

public class day410MyCircularDeque {

    //用数组实现双端队列
    private int[] elements;
    private int size;
    private int front = 0;
    private int tear;
    public day410MyCircularDeque(int k) {
        elements = new int[k];
        tear = k - 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = front == 0 ? elements.length - 1 : front - 1;
        //队列不为空，头指针左移
        elements[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        tear = tear == elements.length - 1 ? 0 : tear + 1;
        elements[tear] = value;
        size ++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = front == elements.length - 1 ? 0 : front + 1;
        size --;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tear = tear == 0 ? elements.length - 1 : tear - 1;
        size --;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return elements[tear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }


    //环形队列

}























