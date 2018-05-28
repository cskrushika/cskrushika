package wait_notify;

import java.util.Scanner;

public class Notifier implements Runnable {

	private Message msg;

	public Notifier(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Thread [" + name + "] started");
		try {
			Thread.sleep(1000);
			Scanner scan;
			while (true) {
				System.out.println("Enter the time to wait. Enter 0 to notifyAll threads to complete");
				scan = new Scanner(System.in);
				int waitTime = scan.nextInt();
				if (waitTime != 0) {
					Thread.currentThread().sleep(waitTime + 1000);
				} else {
					break;
				}
			}
			synchronized (msg) {
				msg.setMsg(name + " work done");
				// msg.notify();
				msg.notifyAll();
				scan.close();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
