public class MyAnalyzeCpuTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(50000);
            System.out.println("Hurrah! This is result!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
