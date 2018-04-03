package com.liugh6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	}

}
