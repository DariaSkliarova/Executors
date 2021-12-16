import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyFindMinTask implements Callable<Integer> {

    private Collection<Integer> collection;

    public MyFindMinTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Integer call() {
        int min = Collections.min(collection);
        return min;
    }

}
