package com.pibigstar;

/**
 * 两个线程交互打印
 * 学习锁的用法
 * @author pibigstar
 *
 */
public class PrintJiOu {

	public static int number = 1;
	public static boolean flag = false;//标志位，false为奇数打印，true为偶数打印

	public static void main(String[] args) {
		PrintJiOu printJiOu = new PrintJiOu();
		Thread t1 = new Thread(new OuThread(printJiOu));
		Thread t2 = new Thread(new JiThread(printJiOu));

		t1.start();
		t2.start();


	}

	/**
	 * 偶数打印线程
	 * @author pibigstar
	 */
	public static class OuThread implements Runnable{
		private PrintJiOu print;

		public OuThread(PrintJiOu print) {
			this.print = print;
		}

		@Override
		public void run() {
			while (print.number<=100) {
				synchronized (PrintJiOu.class) {
					if (flag) {
						System.out.println("偶数打印:"+print.number);
						print.number++;
						print.flag = false;
						PrintJiOu.class.notify();
					}else {
						try {
							PrintJiOu.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}

	}
	public static class JiThread implements Runnable{
		private PrintJiOu print;

		public JiThread(PrintJiOu print) {
			this.print = print;
		}

		@Override
		public void run() {
			while (print.number<=100) {
				synchronized (PrintJiOu.class) {
					if (flag) {
						try {
							PrintJiOu.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						System.out.println("奇数打印:"+print.number);
						print.number++;
						print.flag = true;
						PrintJiOu.class.notify();
					}
				}
			}
		}
	}
}
