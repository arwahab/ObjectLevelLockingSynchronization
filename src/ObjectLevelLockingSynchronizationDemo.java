// Java program to illustrate
// Object locking concept
public class ObjectLevelLockingSynchronizationDemo implements Runnable {
	public void run() {
		Lock();
	}

	public void Lock() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		ObjectLevelLockingSynchronizationDemo objectLevelLockingDemo = new ObjectLevelLockingSynchronizationDemo();
		Thread thread1 = new Thread(objectLevelLockingDemo);
		Thread thread2 = new Thread(objectLevelLockingDemo);
		ObjectLevelLockingSynchronizationDemo objectLevelLockingDemo1 = new ObjectLevelLockingSynchronizationDemo();
		Thread thread3 = new Thread(objectLevelLockingDemo1);
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread3.setName("thread3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}