package StackQueue스택큐;

import java.util.*;

// Queue : offer(e), poll(), peek() : 들어간 순서대로
// Stack : push(e), pop(), peek() : 들어간 반대로
// DeQueue : offerFirst(e), pollFirst(), peekFirst(), offerLast(e), pollLast(), peekLast()

public class StackQueue실습 {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        System.out.println(list);
//        //큐
////        System.out.println(list.remove(0);
////        System.out.println(list);
////
////        System.out.println(list.remove(0);
////        System.out.println(list);
////
////        System.out.println(list.remove(0);
////        System.out.println(list);
//
//        //스택
//        System.out.println(list.remove(list.size()-1));
//        System.out.println(list);
//
//        System.out.println(list.remove(list.size()-1));
//        System.out.println(list);
//
//        System.out.println(list.remove(list.size()-1));
//        System.out.println(list);



        //큐
        //add(e), remove(), element() == 못할시 에러
        //offer(e) poll() peek() == 못할시 0값
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
//
//        System.out.println(queue);
//        queue.poll();
//        System.out.println(queue);
//        queue.poll();
//        System.out.println(queue);
//        queue.poll();
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue);


        //스택
        //push(e), pop(), peek()
//        Stack<Integer> stack = new Stack<>();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.println(stack);
//
//        stack.pop();
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);

        //디큐
        //offerFIrst(e), pollFirst(), peekFirst(), offerLast(e), pollLast(), peekLast()
        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(1);
        System.out.println(deque);

        deque.offerLast(2);
        System.out.println(deque);

        deque.offerFirst(3);
        System.out.println(deque);

        deque.offerLast(4);
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);
    }
}
