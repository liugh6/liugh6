package com.liugh6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

class Thread1 extends Thread {
	private String name;

	public Thread1(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

public class Demo {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("主线程执行：  " + i);
		}

		List list = new LinkedList();
		// mTh2.start();
		Map map = new HashMap();

		List lst = new ArrayList();
		// 初始容量为10
		for (int i = 0; i < 10; i++) {
			lst.add(i);
		}
		lst.add(10);
		for (int i = 0; i < 4; i++) {
			lst.add(10 + i);
		}
		lst.add(15);
		lst = new Vector();
		lst = Collections.synchronizedList(null);
		lst = new LinkedList();

		Set set = new HashSet();
		set = new LinkedHashSet();
		set = new TreeSet<>();

		Queue queue = new PriorityQueue<>();
		queue = new ArrayDeque<>();
		queue = new LinkedList();
		// Map map = new TreeMap();
		Stack v = new Stack();

	}

}
