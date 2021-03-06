package com.kyson.chapter1.section3;

import java.util.Iterator;

/***
 * 1.3.12 编写一个可迭代的Stack用例，它含有一个静态的copy()方法，接受一个字符串的栈作为参数并返回该栈的一个副本。注意：
 * 这种能力是迭代器价值的一个重要体现，因为有了它我们无需改变基本 API 就能实现这种功能。
 * 
 * 1.3.12 Write an iterable Stack client that has a static method copy() that
 * takes a stack of strings as argument and returns a copy of the stack. Note:
 * This ability is a prime example of the value of having an iterator, because
 * it allows development of such functionality without changing the basic API.
 */
public class Stack2<Item> implements Iterable<Item> {

	/**
	 * 
	 ***** 链表实现*****
	 */
	private int N;
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public Stack2() {
		N = 0;
		first = null;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item top() {
		return first.item;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public boolean isEmpty() {
		// 或:first = null
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterater();
	}

	private class ArrayIterater implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
		}

	}

	public static Stack2<String> copy(Stack2<String> stack2) {
		Stack2<String> resultStack = new Stack2<String>();
		//逆序1
		Stack2<String> tempStack = new Stack2<String>();
		Iterator<String> iterator = stack2.iterator();
		while (iterator.hasNext()) {
			tempStack.push(iterator.next());
		}
		//逆序2
		Iterator<String> tempIterator = tempStack.iterator();
		while (tempIterator.hasNext()) {
			resultStack.push(tempIterator.next());
		}

		return resultStack;
	}

	public static void main(String[] args) {
		// String testString =
		// "it was - the best - of times - - - it was - the - -";
		Stack2<String> stack = new Stack2<String>();
		stack.push("我");
		stack.push("的");
		stack.push("名字");
		stack.push("叫");
		stack.push("顶级程序员不穿女装");
		stack.push("微博:https://m.weibo.cn/p/1005056186766482");
		//打印
		System.out.println("原栈逆序输出:");
		for (String string : stack) {
			System.out.print(string);
		}
		System.out.println("");
		System.out.println("开始拷贝...");
		//拷贝
		Stack2<String> stack2 = Stack2.copy(stack);
		System.out.println("拷贝成功");
		System.out.println("开始打印拷贝后的栈");
		//创建迭代器
		for (String string : stack2) {
			System.out.print(string);
		}

	}

}
