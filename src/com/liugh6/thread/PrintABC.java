package com.liugh6.thread;

/**
 * @author liugh6 TODO 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行，交替打印10次ABC
 */
public class PrintABC implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private PrintABC(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			// 先获取上一个对象的锁：保证上一个字母不会被打印
			synchronized (prev) {
				// 再获取当前对象锁：保证下一个字母不会被打印
				synchronized (self) {
					System.out.print(name);
					count--;
					// 唤醒当前对象上阻塞的线程：下一个字母可以被打印
					self.notify();
				}

				try {
					// 阻塞上一个对象锁监听的线程：保证当前字母和上一个字母不会打印
					prev.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		PrintABC pa = new PrintABC("A", c, a);
		PrintABC pb = new PrintABC("B", a, b);
		PrintABC pc = new PrintABC("C", b, c);

		new Thread(pa).start();
		Thread.sleep(100); // 确保按顺序A、B、C执行
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}
}