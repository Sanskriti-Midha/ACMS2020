import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Priority_Sched {
 
    private ExecutorService priorityJobPoolExecutor;
    private ExecutorService priorityJobScheduler 
      = Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<scraper> priorityQueue;
 
    public Priority_Sched(Integer poolSize, Integer queueSize) {
        priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
        priorityQueue = new PriorityBlockingQueue<scraper>(
          queueSize, 
          Comparator.comparing(scraper::getJobPriority));
        priorityJobScheduler.execute(() -> {
            while (true) {
                try {
                    priorityJobPoolExecutor.execute(priorityQueue.take());
                } catch (InterruptedException e) {
                    // exception needs special handling
                    break;
                }
            }
        });
        
        //priorityJobPoolExecutor.shutdown();
    }
 
    public void scheduleJob(scraper job) {
        priorityQueue.add(job);
    }
}