package com.liugh6.thread;

/**
 * @author liugh6 TODO ���������̣߳�A�̴߳�ӡ10��A��B�̴߳�ӡ10��B,C�̴߳�ӡ10��C��Ҫ���߳�ͬʱ���У������ӡ10��ABC
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
			// �Ȼ�ȡ��һ�������������֤��һ����ĸ���ᱻ��ӡ
			synchronized (prev) {
				// �ٻ�ȡ��ǰ����������֤��һ����ĸ���ᱻ��ӡ
				synchronized (self) {
					System.out.print(name);
					count--;
					// ���ѵ�ǰ�������������̣߳���һ����ĸ���Ա���ӡ
					self.notify();
				}

				try {
					// ������һ���������������̣߳���֤��ǰ��ĸ����һ����ĸ�����ӡ
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
		Thread.sleep(100); // ȷ����˳��A��B��Cִ��
		new Thread(pb).start();
		Thread.sleep(100);
		new Thread(pc).start();
		Thread.sleep(100);
	}
}