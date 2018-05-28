package wait_notify;

import java.time.LocalDateTime;

public class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message m) {
		this.msg = m;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try {
				System.out.println(
						"Thread [" + name + "] waiting to get notified. Time: " + LocalDateTime.now().toString());
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread [" + name + "] waiter thread got notified. Time: " + LocalDateTime.now().toString());
			System.out.println("Thread [" + name + "] processed with message ->: " + msg.getMsg());
		}
	}

}
