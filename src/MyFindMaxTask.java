import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyFindMaxTask implements Callable<Integer> {
    private Collection<Integer> collection;

    public MyFindMaxTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Integer call() {
        int max = Collections.max(collection);
        return max;
    }
}
