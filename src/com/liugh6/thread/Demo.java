package com.liugh6.thread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.liugh6.util.StringTools;

public class Demo {

	class Thread1 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}
	}

	static class synClass {
		public synchronized void printA() {
			StringTools.println("a");
			printB();
		}

		public synchronized void printB() {
			StringTools.println("B");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 0, 0, TimeUnit.SECONDS, null);
		threadPoolExecutor.execute(null);
		ExecutorService executorService = Executors.newCachedThreadPool();
		StringBuilder sb = new StringBuilder();
		String s = "";
		new HashMap();
		new LinkedHashMap();
		new Hashtable<>();

		/*
		 * Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		 * treeMap.put(1, "2"); treeMap.put(2, "1"); for (String value :
		 * treeMap.values()) { StringTools.println(value); } for (Integer key :
		 * treeMap.keySet()) { StringTools.println(key); }
		 */

		Thread t = new Thread();

		Lock lock = new ReentrantLock();
		lock.newCondition();
		synClass sc = new synClass();
		sc.printA();
		new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		};

	}

}
