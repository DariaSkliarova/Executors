import java.util.Collection;
import java.util.concurrent.Callable;

public class MyFindAverageTask implements Callable<Double> {
    private Collection<Integer> collection;

    public MyFindAverageTask(Collection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public Double call() {
        double sum = 0;
        for (Integer integer : collection) {
            sum += integer;
        }
        double aver = sum / collection.size();
        return aver;
    }
}
