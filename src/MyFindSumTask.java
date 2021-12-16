import java.util.Collection;
import java.util.concurrent.Callable;

public class MyFindSumTask implements Callable<Integer> {
    private Collection<Integer> collection;

    public MyFindSumTask(Collection<Integer> collection){
        this.collection = collection;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (Integer integer : collection) {
            sum += integer;
        }
        return sum;
    }
}
