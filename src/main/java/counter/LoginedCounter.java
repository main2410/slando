package counter;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

@Component
public class LoginedCounter implements ICounter{
    
    private final AtomicInteger counter = new AtomicInteger(0);
    
    @Override
    public int get() {
        return counter.get();
    }

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public void decrement() {
        counter.decrementAndGet();
    }

}
